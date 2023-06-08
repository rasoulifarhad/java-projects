package com.farhad.example.string;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringEqualityDemoTest {
    
    @Test
    public  void stringEqualityTest() {

        String str1 = "red";
        String str2 = "red";
        if (str1.equals(str2)) {
            log.info("str1 and str2 have equal values.");
        }
        if (str1 == str2) {
            log.info("str1 and str2 have equal references.");   
        }

        String str3 = "green";
        String str4 = new String("green");
        if (str3.equals(str4)) {
            log.info("str3 and str4 have equal values.");
        }
        if (str3 == str4) {
            log.info("str3 and str4 have equal references.");   
        }
    } 

    @Test
    public void stringEqualityWithoutIgnoreCase() {

        String str1 = "red";
        String str2 = "Red";
        if (str1.equals(str2)) {
            log.info("str1 and str2 have equal values.");
        } else {
            log.info("str1 and str2 do NOT have equal values.");   
        }
    }

    @Test
    public void stringEqualityWithIgnoreCase() {

        String str1 = "red";
        String str2 = "Red";
        if (str1.equalsIgnoreCase(str2)) {
            log.info("str1 and str2 have equal values.");
        } else {
            log.info("str1 and str2 do NOT have equal values.");   
        }
    }

}
