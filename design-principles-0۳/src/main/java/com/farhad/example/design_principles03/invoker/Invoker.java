package com.farhad.example.design_principles03.invoker;

import java.lang.reflect.Method;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Invoker {

    public static void invokeVoidMethodNoArgs(String className, String methodName)  {

        try {
            Class<?> clazz = Class.forName(className);
            Object object = clazz.newInstance();
            Method method = clazz.getMethod(methodName);
            method.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
