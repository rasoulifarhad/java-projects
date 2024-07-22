package com.farhad.example.design_principles03.command_dispatcher;

import lombok.RequiredArgsConstructor;

// A common data-driven scenario arises when processing command- line or some 
// remote-invocation interfaces in which a dispatcher uses an Abstract Factory 
// to generate Command pattern [DP] objects for execution.
@RequiredArgsConstructor
public class CommandDispatcher {

    private final CommandFactory commandFactory;

    public void dispatch(String commandName) {
        Command command = commandFactory.createCommand(commandName);
        command.execute();
    }
}
