package com.farhad.example.work;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(staticName = "of")
@Getter
@ToString
public class CalcResult {
    double result;
}
