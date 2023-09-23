package com.farhad.example.acyclic_visitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hayes extends Modem {

    @Override
    void accept(ModemVisitor modemVisitor) {
        if(modemVisitor instanceof HayesVisitor){
            ((HayesVisitor)modemVisitor).visit(this);
        } else {
            log.info("Only HayesVisitor is allowed to visit Hayes modem");
        }
    }
    
}
