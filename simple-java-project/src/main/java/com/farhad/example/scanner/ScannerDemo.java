package com.farhad.example.scanner;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Interviewer interviewer = new Interviewer();
        System.out.println(interviewer.askColorQuestion());
        Scanner scanner = new Scanner(System.in);
        String color = scanner.nextLine();
        System.out.println(interviewer.respondToColorAnswer(color));
        scanner.close();
    }
}
