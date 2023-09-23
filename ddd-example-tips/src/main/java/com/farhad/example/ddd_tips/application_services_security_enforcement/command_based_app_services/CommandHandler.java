package com.farhad.example.ddd_tips.application_services_security_enforcement.command_based_app_services;

public interface CommandHandler<C extends Command<R>, R> {
    R handleCommand(C command) ;
}
