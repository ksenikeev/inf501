package ru.itis.inf501.lab2_16.integral;

public class PartIntegralSum implements Runnable {

    private double a;
    private double b;
    private int taskNumber;

    public PartIntegralSum() {

    }

    @Override
    public void run() {


        Integral.totalSum[taskNumber] = 0;
    }

    private double func(double x) {
        return 0; // ...
    }
}
