package com.farhad.example.java_tips.no_getter;

public class Main {

    public static void main(String[] args) {
        UserDataRecord user = new UserDataRecord("boy")    ;
        System.out.println(displayGreeting(user));
    }

    public static String displayGreeting(UserDataRecord user) {
        return String.format("Hi %s!", user.getName());
    }
}
