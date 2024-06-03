package com.farhad.example.refactoring.hide_delegate.demo2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Person {

    @Getter
    private final String name;
    private final Department department;

    public Manager getManager() {
        return department.getManager();
    }
}
