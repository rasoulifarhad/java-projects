package com.farhad.example.command.demo2;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GhostRider {
    
    private Command command;

    public void takeAction() {
        command.execute();
    }

    public void revertAction() {
        command.revert();
    }
}
