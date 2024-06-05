package com.farhad.example.working_legacy_code.statistical_moment;

import java.util.ArrayList;
import java.util.List;

// We’re working on a ﬁnancial application, and we need a
// class that is going to use some high-powered mathematics to verify whether cer-
// tain commodities should be traded. We need a Java class that calculates some-
// thing called the ﬁrst statistical moment about a point. We don’t have a method
// that does that yet, but we do know that we can write a test case for the method.
// We know the math, so we know that the answer should be -0.5 for the data we
// code in the test.
public class InstrumentCalculator {

    private List<Double> elements = new ArrayList<>();

    public void addElement(double point) {
        elements.add(point);
    }

    public Double firstMomentAbout(double point) throws InvalidBasicException {
        return nthMomentAbout(point, 1.0);
    }

    public Double secondMomentAbout(double point) throws InvalidBasicException {
        if(elements.isEmpty()) {
            throw new InvalidBasicException();
        }
        double numinator = 0.0;
        for (Double element : elements) {
            numinator += Math.pow(element - point, 2.0);
        }
        return numinator / elements.size();
    }

    private Double nthMomentAbout(double point, double n) throws InvalidBasicException {
        if(elements.isEmpty()) {
            throw new InvalidBasicException();
        }
        double numinator = 0.0;
        for (Double element : elements) {
            numinator += Math.pow(element - point, n);
        }
        return numinator / elements.size();
    }

}
