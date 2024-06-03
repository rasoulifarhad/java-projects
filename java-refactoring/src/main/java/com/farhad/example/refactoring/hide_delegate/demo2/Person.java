package com.farhad.example.refactoring.hide_delegate.demo2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class Person {

    @Getter
    private final String name;

    @Getter
    @Setter
    private Department department;

    public Manager getManager() {
        return department.getManager();
    }
}
