package com.farhad.example.remote_controlled_ship;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
public class Planet {

    @Getter
    private final Point max;

    @Getter
    @Setter
    private List<Point> obstacles;



}
