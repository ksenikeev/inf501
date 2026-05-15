package ru.itis.inf501.lab2_16.partsum;

public class TaskWork implements Runnable {

    private double x;

    public static double totalSum = 0;

    public TaskWork(double x) {
        this.x = x;
    }

    @Override
    public void run() {
        calculate();
    }

    public void calculate() {
        double sum = 0;
        double p = 1;
        for (int i = 1; i < 1_000_000; ++i) {
            sum += p;
            p *= x/i;
        }

        TaskWorkMain.putPartSum(sum);

/*
        synchronized (TaskWork.class) {
            totalSum += sum;
        }
*/

        System.out.println("f(" + x + ") = " + sum);
    }

}
