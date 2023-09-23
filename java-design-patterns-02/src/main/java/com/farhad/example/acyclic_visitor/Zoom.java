package com.farhad.example.acyclic_visitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Zoom extends Modem {

    @Override
    public void accept(ModemVisitor modemVisitor) {
        if(modemVisitor instanceof ZoomVisitor) {
            ((ZoomVisitor)modemVisitor).visit(this);
        } else {
            log.info("Only ZoomVisitor is allowed to visit Zoom modem");
        }
    }
    
}
