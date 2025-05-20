package com.farhad.example.world_of_zuul.demo01;

public class Command {

    private String commandWord;
    private String secondWord;

    public Command(String commandWord, String secondWord) {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public boolean isUnknown() {
        return commandWord == null;
    }

    public boolean hasSecondWord() {
        return secondWord != null;
    }
}
