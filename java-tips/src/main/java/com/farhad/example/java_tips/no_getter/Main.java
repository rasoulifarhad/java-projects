package com.farhad.example.java_tips.no_getter;

public class Main {

    public static void main(String[] args) {
        UserDataRecordBad user = new UserDataRecordBad("boy")    ;
        System.out.println(displayGreeting(user));

        UserDataRecord userBetter = new UserDataRecord("boy")    ;
        System.out.println(displayGreeting(userBetter));

        displayGreeting(new UserFromDatabase("user from db"));
        displayGreeting(new UserFromJson("User fromjson"));
    }

    public static String displayGreeting(UserDataRecordBad user) {
        return String.format("Hi %s!", user.getName());
    }

    public static String displayGreeting(UserDataRecord user) {
        return user.greeting();
    }

    public static void displayGreeting(User user) {
        System.out.println(user.greeting());
    }
}
