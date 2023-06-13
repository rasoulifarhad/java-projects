package com.farhad.example.string;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtilsTest {
    

    @Test
    public void twoStringLiteralsInAClassTest() throws Exception {

        String one = "xyz";
        String two = "xyz";

        log.info("one.value: {}", Utils.showInternalCharArrayHashCode(one));
        log.info("two.value: {}", Utils.showInternalCharArrayHashCode(two));

        log.info("one: {}", System.identityHashCode(one));
        log.info("two: {}", System.identityHashCode(two));

    }

    @Test 
    public void LiteralAndNewStringTestr() throws Exception {

        String one = "xyz";
        String two = new String("xyz");

        log.info("one.value: {}", Utils.showInternalCharArrayHashCode(one));
        log.info("two.value: {}", Utils.showInternalCharArrayHashCode(two));

        log.info("one: {}", System.identityHashCode(one));
        log.info("two: {}", System.identityHashCode(two));
    }

    @Test
    public void runtimeModificationAndInternTest() throws Exception {


        String one = "xyz" ;
        String two = "?xyz".substring(1); //also two = "xyz"

        log.info("one.value: {}", Utils.showInternalCharArrayHashCode(one));
        log.info("two.value: {}", Utils.showInternalCharArrayHashCode(two));

        log.info("one: {}", System.identityHashCode(one));
        log.info("two: {}", System.identityHashCode(two));
    }

    @Test
    public void runtimeModificationAndInternTestFirstChange() throws Exception {


        String one = "xyz" ;
        String two = "?xyz".substring(1); //also two = "xyz"

        two = two.intern();

        log.info("one.value: {}", Utils.showInternalCharArrayHashCode(one));
        log.info("two.value: {}", Utils.showInternalCharArrayHashCode(two));

        log.info("one: {}", System.identityHashCode(one));
        log.info("two: {}", System.identityHashCode(two));
    }

    @Test
    public void runtimeModificationAndInternTestSecondChange() throws Exception {


        String one = "xyz" ;
        String two = "xyz".substring(1); 

        log.info("one.value: {}", Utils.showInternalCharArrayHashCode(one));
        log.info("two.value: {}", Utils.showInternalCharArrayHashCode(two));

        log.info("one: {}", System.identityHashCode(one));
        log.info("two: {}", System.identityHashCode(two));
    }

    @Test
    void testSuccessor() {
        String s = "b";
        log.info("'{}' is successor of '{}'", Utils.successor(s), s);
    }

}
