package com.farhad.example.designpatterns.iterator;

import org.junit.jupiter.api.Test;

import com.farhad.example.designpatterns.iterator.IteratorDemoGof.DesignPattern;
import com.farhad.example.designpatterns.iterator.IteratorDemoGof.PatternAggregate;
import com.farhad.example.designpatterns.iterator.IteratorDemoGof.PatternAggregateImpl;
import com.farhad.example.designpatterns.iterator.IteratorDemoGof.PatternIterator;

public class IteratorDemoGof_PatternAggregateImplTest {

    @Test
    public void testPatternIterator() {

        DesignPattern pattern1 = new DesignPattern("Creational", "Factory Method");
        DesignPattern pattern2 = new DesignPattern("Creational", "Abstract Factory");
        DesignPattern pattern3 = new DesignPattern("Structural", "Adapter");
        DesignPattern pattern4 = new DesignPattern("Structural", "Bridge");
        DesignPattern pattern5 = new DesignPattern("Behavioral", "Chain of Responsibility");
        DesignPattern pattern6 = new DesignPattern("Behavioral", "Iterator");
        
        PatternAggregate patternAggregate = new PatternAggregateImpl();
        patternAggregate.addPattern(pattern1);
        patternAggregate.addPattern(pattern2);
        patternAggregate.addPattern(pattern3);
        patternAggregate.addPattern(pattern4);
        patternAggregate.addPattern(pattern5);
        patternAggregate.addPattern(pattern6);

        printPatterns(patternAggregate);

        patternAggregate.removePattern(pattern1);
        patternAggregate.removePattern(pattern2);
        printPatterns(patternAggregate);

    }

    private void printPatterns(PatternAggregate patternAggregate) {
        PatternIterator iterator = patternAggregate.getPatternIterator();
        while(!iterator.isLastPattern()) {
            DesignPattern designPattern = iterator.nextPattern();
            System.out.println(designPattern);
        }
    }
}
