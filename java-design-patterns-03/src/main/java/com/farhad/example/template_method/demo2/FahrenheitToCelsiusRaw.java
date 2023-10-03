package com.farhad.example.template_method.demo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FahrenheitToCelsiusRaw {
    
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        boolean done = false;
        while (!done) {
            String fahrenheitString = br.readLine();
            if(fahrenheitString == null || fahrenheitString.length() == 0) {
                done = true;
            } else {
                double fahrenheit = Double.parseDouble(fahrenheitString);
                double celsius = 5.0 / 9.0 * ( fahrenheit - 32 );
                System.out.println(String.format("F=%.2f, C=%.2f", fahrenheit, celsius));
            }

        }
        System.out.println("FahrenheitToCelsiusRaw exits");
    }
}
