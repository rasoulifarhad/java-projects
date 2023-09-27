package com.farhad.example.double_dispatch;

public interface Graphic {
    void draw();
    void accept(Exporter exporter);
}
