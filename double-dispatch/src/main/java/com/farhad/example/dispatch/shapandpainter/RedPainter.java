package com.farhad.example.dispatch.shapandpainter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RedPainter implements Painter {

    @Override
    public void paint(Triangle triangle) {
        log.info("Red triangle painted");
    }

    @Override
    public void paint(Square square) {
        log.info("Red square painted");
    }
    
}
