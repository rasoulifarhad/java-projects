package com.farhad.example.string;

import java.text.Collator;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CollatorTest {

    @Test
    public void normalCollatorTest1() {

        Collator collator = Collator.getInstance();
        if (collator.compare("red", "red  ") == 0 ) {
            log.info("`red` and `Red  ` have equal values.");
        } else {
            log.info("`red` and `Red  ` do not have equal values.");
        }
    }

    @Test
    public void normalCollatorTest() {

        Collator collator = Collator.getInstance();
        if (collator.compare("red", "Red") == 0 ) {
            log.info("`red` and `Red` have equal values.");
        } else {
            log.info("`red` and `Red` do not have equal values.");
        }
    }

    @Test
    public void primaryStrengthCollatorTest() {

        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);
        if (collator.compare("red", "Red") == 0 ) {
            log.info("`red` and `Red` have equal values.");
        } else {
            log.info("`red` and `Red` do not have equal values.");
        }
    }

    @Test
    public void primaryStrengthCollatorWithWhiteSpaceTest() {

        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);
        if (collator.compare("red", "Red  ") == 0 ) {
            log.info("`red` and `Red  ` have equal values.");
        } else {
            log.info("`red` and `Red  ` do not have equal values.");
        }
    }

    @Test
    public void secondaryStrengthCollatorTest() {

        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.SECONDARY);
        if (collator.compare("red", "Red") == 0 ) {
            log.info("`red` and `Red` have equal values.");
        } else {
            log.info("`red` and `Red` do not have equal values.");
        }
    }

    @Test
    public void secondaryStrengthCollatorWithWhiteSpaceTest() {

        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.SECONDARY);
        if (collator.compare("red", "Red  ") == 0 ) {
            log.info("`red` and `Red  ` have equal values.");
        } else {
            log.info("`red` and `Red  ` do not have equal values.");
        }
    }

}
