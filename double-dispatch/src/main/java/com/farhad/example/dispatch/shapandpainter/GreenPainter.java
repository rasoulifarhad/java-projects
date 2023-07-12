package com.farhad.example.dispatch.shapandpainter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GreenPainter  implements Painter{

    @Override
    public void paint(Triangle triangle) {
        log.info("Green Triangle painted");
    }

    @Override
    public void paint(Square square) {    
        log.info("Green square painted.");
    }
    
}
