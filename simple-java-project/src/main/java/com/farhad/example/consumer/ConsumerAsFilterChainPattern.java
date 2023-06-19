package com.farhad.example.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerAsFilterChainPattern {
    static class EmailManager {

        public void spellChecker(String emailBody) {
            System.out.println("Spell checking on " + emailBody);
        }

        public void grammarChecker(String emailBody) {
            System.out.println("Grammar checking on " + emailBody);
        }

        public void formatChecker(String emailBody) {
            System.out.println("Format checking on " + emailBody );
        }

        public void applyFilter(List<Consumer<String>> filters, String emailBody) {
            filters.forEach(f -> f.accept(emailBody));
        }

        public void applyFilter(Consumer<String> filter, String emailBody) {
            filter.accept(emailBody);
        }
    }

    public void demonstrateApplyListFilters() {
        EmailManager emailManager = new EmailManager();

        System.out.println();
        String emailBody = "This is email from me";
        List<Consumer<String>> filters = new ArrayList<>();
        filters.add(emailManager::spellChecker);
        filters.add(emailManager::grammarChecker);
        filters.add(emailManager::formatChecker);

        emailManager.applyFilter(filters, emailBody);
    }

    public void demonstrateApplyCompositFilters() {
        EmailManager emailManager = new EmailManager();

        System.out.println();
        String emailBody = "This is email from me";
        Consumer<String> filter = emailManager::spellChecker;
        Consumer<String> compositFilter = 
                    filter
                        .andThen(emailManager::grammarChecker)
                        .andThen(emailManager::formatChecker);
        emailManager.applyFilter(compositFilter, emailBody);
    }

    public static void main(String[] args) {
        ConsumerAsFilterChainPattern demo = new ConsumerAsFilterChainPattern();

        demo.demonstrateApplyListFilters();
        demo.demonstrateApplyCompositFilters();
    }
    
}
