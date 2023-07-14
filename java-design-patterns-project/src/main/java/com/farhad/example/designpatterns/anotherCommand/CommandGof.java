package com.farhad.example.designpatterns.anotherCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandGof {
    
    interface Command {
        void run();
    }

    public static class Filer implements Command {

        private String msg;
        
        public Filer(String msg) {
            this.msg = msg;
        }
        @Override
        public void run() {
            System.out.println(String.format("Filing: %s%n",msg));
        }
    }

    public static class Logger implements Command {

        private String msg;
        
        public Logger(String msg) {
            this.msg = msg;
        }
        @Override
        public void run() {
            System.out.println(String.format("Logging: %s%n",msg));
        }
    }
    public static class Mailer implements Command {

        private String msg;
        
        public Mailer(String msg) {
            this.msg = msg;
        }
        @Override
        public void run() {
            System.out.println(String.format("mailing: %s%n",msg));
        }
    }

    public static class CommandExecutor {
        public void execute(List<Command> tasks) {
            tasks.forEach(task -> task.run());
        }
    }

    public static void main(String[] args) {
        List<Command> tasks = new ArrayList<>();
        tasks.add(new Logger("Message logged")); 
        tasks.add(new Filer("File not found"));
        tasks.add(new Mailer("Maile sended to party."));

        new CommandExecutor().execute(tasks);
    }
}
