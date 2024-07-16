package com.farhad.example.codekata.leader_board_kata;

import lombok.Getter;
import lombok.Setter;

public class SelfDrivingCar extends Driver {

    @Getter
    @Setter
    private String algorithmVersion;

    public SelfDrivingCar(String algorithmVersion, String company) {
        super(algorithmVersion, company);
        this.algorithmVersion = algorithmVersion;
    }

    
}
