package com.farhad.example.ddd_tips.application_services_security_enforcement.command_based_app_services;

public class CommandGateway {
    public <C extends Command<R>, R> R handleCommand(C command) {
        // var handler = commandHandlers.findHandlerFor(command)
        //     .orElseThrow(() -> new IllegalStateException("No command handler found"));
        // return handler.handleCommand(command);
        return null;
    }
}
