package ru.itis.inf501.lab2_16;
/*
 */
public class TaskRunnable implements Runnable {

    private String message;
    private Object mutex;

    public TaskRunnable(String message, Object mutex) {
        super();
        this.message = message;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        print();

        calculate();
    }

    private void print() {
        // TODO исключить дурное влияние других потоков
        synchronized (TaskRunnable.class) {
            System.out.println(Thread.currentThread().threadId() + " : print");
            for (int i = 0; i < message.length(); ++i) {
                System.out.print(message.charAt(i));
            }
            System.out.println();
        }
    }

    private void calculate() {
        synchronized (mutex) {
            //...
            System.out.println(Thread.currentThread().threadId() + " : calculate");
        }
    }

}
