package com.farhad.example.designpatterns.iterator;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class IteratorDemoGof {
    
    @RequiredArgsConstructor
    @Data
    public static class DesignPattern {
        private final String patternType;
        private final String patternName;

    }

    public interface PatternAggregate {
        void addPattern(DesignPattern designPattern);
        void removePattern(DesignPattern designPattern);
        PatternIterator getPatternIterator();
    }

    public static class PatternAggregateImpl implements PatternAggregate {

        private List<DesignPattern> designpatterns = new ArrayList<>();
        
        @Override
        public void addPattern(DesignPattern designPattern) {
            this.designpatterns.add(designPattern);            
        }

        @Override
        public PatternIterator getPatternIterator() {
            return new PatternIteratorImpl(designpatterns);
        }

        @Override
        public void removePattern(DesignPattern designPattern) {
            this.designpatterns.remove(designPattern);
        }

    }

    public interface PatternIterator {
        DesignPattern nextPattern();
        boolean isLastPattern();
    }

    @RequiredArgsConstructor
    public static class PatternIteratorImpl implements PatternIterator {

        private final List<DesignPattern> designPatterns;

        int position = 0;
        DesignPattern designPattern;
        @Override
        public boolean isLastPattern() {
            return !(position < designPatterns.size());
        }

        @Override
        public DesignPattern nextPattern() {
            System.out.println("returning pattern at position " + position);
            designPattern = designPatterns.get(position);
            position++;
            return designPattern;
        }  
        
        
    }
}
