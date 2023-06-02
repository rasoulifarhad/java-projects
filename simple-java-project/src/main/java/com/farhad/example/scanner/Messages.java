package com.farhad.example.scanner;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Messages {
    
    private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("com.farhad.example.scanner.Interviewer");

    public static String getString(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }

    public static Map<String,String> getStrings(String prefix) {
        Map<String,String> retVal = new HashMap<>();
        Enumeration<String> keys = RESOURCE_BUNDLE.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            if (key.startsWith(prefix)) {
                retVal.put(key, RESOURCE_BUNDLE.getString(key));
            }
        }
        return retVal;
    }

}
