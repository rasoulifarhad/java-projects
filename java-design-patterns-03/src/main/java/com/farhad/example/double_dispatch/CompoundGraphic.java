package com.farhad.example.double_dispatch;

import java.util.ArrayList;
import java.util.List;

public class CompoundGraphic  {
    
    List<Graphic> graphics = new ArrayList<>();

    // @Override
    public void draw() {
        graphics.forEach(s -> s.draw());
    }
}
