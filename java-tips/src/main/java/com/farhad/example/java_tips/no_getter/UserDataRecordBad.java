package com.farhad.example.java_tips.no_getter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserDataRecordBad {

    private final String name;
}
