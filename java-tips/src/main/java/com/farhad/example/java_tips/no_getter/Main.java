package com.farhad.example.java_tips.no_getter;

public class Main {

    public static void main(String[] args) {
        UserDataRecordBad user = new UserDataRecordBad("boy")    ;
        System.out.println(displayGreeting(user));

        UserDataRecord userBetter = new UserDataRecord("boy")    ;
        System.out.println(displayGreeting(userBetter));
    }

    public static String displayGreeting(UserDataRecordBad user) {
        return String.format("Hi %s!", user.getName());
    }

    public static String displayGreeting(UserDataRecord user) {
        return user.greeting();
    }
}
