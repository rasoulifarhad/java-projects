package com.farhad.example.string;

import java.lang.reflect.Field;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {
    
    /**
     * It will print hashCode() of char[] value
     * @param s
     * @return
     * @throws Exception
     */
    public static int showInternalCharArrayHashCode(String s) throws Exception {
        final Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);
        return value.get(s).hashCode();

    }

    //  the successor of a string s in String's natural ordering is s + "\0" — that is, s with a null character appended.
    public static String successor(String s) {
        return s + "\0";
    }

    public static void main(String[] args) throws Exception {
        
        String one = "XYZ";
        String two = "XYZ";

        log.info("one.value: {}", showInternalCharArrayHashCode(one));
        log.info("two.value: {}", showInternalCharArrayHashCode(two));

        log.info("one: {}", System.identityHashCode(one));
        log.info("two: {}", System.identityHashCode(two));

        log.info("one: {}", one);
        log.info("two: {}", two);

        String s = "b";
        log.info("'{}' is successor of '{}'", Utils.successor(s), s);

    }
}
