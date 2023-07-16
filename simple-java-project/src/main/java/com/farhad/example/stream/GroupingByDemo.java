package com.farhad.example.stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

public class GroupingByDemo {
    

    public static Map<Currency, List<Transaction>> filterAndGroupbyCurrencyExpensiveTransactions(List<Transaction> transactions) {
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
        for (Transaction transaction : transactions) {
            if (transaction.getPrice() > 1000 ) {
                Currency currency = transaction.getCurrency();
                List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
                if (transactionsForCurrency == null) {
                    transactionsForCurrency = new ArrayList<>();
                    transactionsByCurrencies.put(currency, transactionsForCurrency);
                }
                transactionsForCurrency.add(transaction);
            }
        }
        return transactionsByCurrencies;
    }

    public static Map<Currency, List<Transaction>> expensivesByCurrency(List<Transaction> transactions) {
        return
            transactions.stream()
                .filter((Transaction t) -> t.getPrice() > 1000)
                .collect(groupingBy(Transaction::getCurrency));
    }

    @Data
    @AllArgsConstructor
    static class Transaction {
        private int price;
        private Currency currency;
    }

    @AllArgsConstructor
    @Data
    public static class Apple {
        private int weight = 0;
        private String color = "";
    }

    public static void main(String[] args) {
        
        List<Apple> inventory = new ArrayList<Apple>() {
            {
                add(new Apple(80, "green"));
                add(new Apple(155, "green"));
                add(new Apple(120, "red"));
            }
        };

        List<Apple> heavyApples = inventory.stream()
                                        .filter((Apple a) -> a.getWeight() > 150)
                                        .collect(toList());
        System.out.println(heavyApples);

        heavyApples = inventory.parallelStream()
                            .filter((Apple a) -> a.getWeight() > 150)
                            .collect(toList());
        System.out.println(heavyApples);
                            

    }

}
