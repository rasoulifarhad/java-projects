package com.farhad.example.designpatterns.anotherCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandLambda {
    
    public static void log(String msg) {
        System.out.println(String.format("Logging: %s%n",msg));
    }

    public static void save(String msg) {
        System.out.println(String.format("Saving: %s%n",msg));
    }

    public static void mail(String msg) {
        System.out.println(String.format("Mailing: %s%n",msg));
    }

    public static class CommandExecutor {
        public void execute(List<Runnable> tasks) {
            tasks.forEach(Runnable::run);
        }
    }

    public static void main(String[] args) {
        List<Runnable> tasks = new ArrayList<>();
        tasks.add(() -> log("Message logged"));
        tasks.add(() -> save("File not found"));
        tasks.add(() -> mail("Mail subject is empty"));

        new CommandExecutor().execute(tasks);
    }
}
