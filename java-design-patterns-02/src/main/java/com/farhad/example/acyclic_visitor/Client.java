package com.farhad.example.acyclic_visitor;

public class Client {
    public static void main(String[] args) {
        ConfigureForDosVisitor configureForDosVisitor = new ConfigureForDosVisitor();
        ConfigureForUnixVisitor configureForUnixVisitor = new ConfigureForUnixVisitor();

        Zoom zoom = new Zoom();
        Hayes hayes = new Hayes();

        hayes.accept(configureForDosVisitor);
        zoom.accept(configureForDosVisitor);

        hayes.accept(configureForUnixVisitor);
        zoom.accept(configureForUnixVisitor);

    }
}
