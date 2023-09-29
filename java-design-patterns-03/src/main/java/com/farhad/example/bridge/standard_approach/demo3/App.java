package com.farhad.example.bridge.standard_approach.demo3;

public class App {
    
    public static void main(String[] args) {
        
        Double rawdata=34.56565;

        GroupCalibration groupX = new Group1(new HuwCalibration());
        System.out.println(groupX.applyCorrection(rawdata));

        GroupCalibration groupY = new Group1(new BrocadeCalibration());
        System.out.println(groupY.applyCorrection(rawdata));

        GroupCalibration groupV = new Group2(new HuwCalibration());
        System.out.println(groupV.applyCorrection(rawdata));

        GroupCalibration groupZ = new Group3(new BrocadeCalibration());
        System.out.println(groupZ.applyCorrection(rawdata));
    }
}
