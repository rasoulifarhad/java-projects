package com.farhad.example.acyclic_visitor;

public abstract class Modem {
    abstract void accept(ModemVisitor modemVisitor);
}
