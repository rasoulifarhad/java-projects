package com.farhad.example.strategy.demo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FtoCStrategy implements Application{

    private InputStreamReader isr;
    private BufferedReader br;
    private boolean isDone = false;

    @Override
    public void init() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(br);
    }

    @Override
    public void idle() {
        String fahrenheitString = readLineAndReturnNullIfError();
        if(fahrenheitString == null || fahrenheitString.length() == 0) {
            isDone = true;;
        } else {
            double fahrenheit = Double.parseDouble(fahrenheitString);
            double celsius = 5.0 / 9.0 * ( fahrenheit - 32 );
            System.out.println(String.format("F=%.2f, C=%.2f", fahrenheit, celsius));
        }    
    }

    @Override
    public void cleanup() {
        System.out.println("ftoc exit");
    }

    @Override
    public boolean done() {
        return isDone;
    }
    
    private String readLineAndReturnNullIfError() {
        String s;
        try {
            s = br.readLine();

        } catch (Exception e) {
            s = null;
        }
        return s;
    }    
}
