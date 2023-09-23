package com.farhad.example.acyclic_visitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigureForUnixVisitor implements ZoomVisitor {

    @Override
    public void visit(Zoom zoom) {
        log.info(zoom + " used with Unix configurator.");    
    }
    
}
