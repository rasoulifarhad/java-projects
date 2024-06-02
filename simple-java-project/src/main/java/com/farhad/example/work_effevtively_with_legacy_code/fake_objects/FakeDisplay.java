package com.farhad.example.work_effevtively_with_legacy_code.fake_objects;

import lombok.Getter;

public class FakeDisplay implements Display {

    @Getter
    private String lastLine;

    @Override
    public void showLine(String line) {
        lastLine = line;
    }

}
