package com.farhad.example.template_method.demo2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ahrenheitToCelsiusTemplateMethod extends Application {

    private InputStreamReader isr;
    private BufferedReader br;

    @Override
    protected void init() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
    }

    @Override
    protected void idle() {
        String fahrenheitString = readLineAndReturnNullIfError();
        if(fahrenheitString == null || fahrenheitString.length() == 0) {
            setDone();
        } else {
            double fahrenheit = Double.parseDouble(fahrenheitString);
            double celsius = 5.0 / 9.0 * ( fahrenheit - 32 );
            System.out.println(String.format("F=%.2f, C=%.2f", fahrenheit, celsius));
        }        
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

    @Override
    protected void cleanup() {
        System.out.println("ahrenheitToCelsiusTemplateMethod exits");

    }
    
}
