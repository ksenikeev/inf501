package ru.itis.inf501.lab2_16.partsum;

import ru.itis.inf501.lab2_16.TaskRunnable;

public class TaskWorkMain  {

    public static double totalSum = 0;

    public static void main(String[] args) throws InterruptedException {

        int countProc = Runtime.getRuntime().availableProcessors();

        Thread[] tasks = new Thread[countProc];

        for (int i = 0; i < countProc; ++i) {
            tasks[i] = new Thread(new TaskWork(i));
        }

        System.out.println("Запускаем потоки");
        // запуск start() создает поток и запускает run()
        for (int i = 0; i < countProc; ++i) {
            tasks[i].start();
        }

        for (int i = 0; i < countProc; ++i) {
            tasks[i].join();
        }

        Thread.sleep(1000);

        System.out.println("Завершаем программу c итогом " + TaskWorkMain.totalSum);
    }

    // Т.к. метод статический, то синхронизация произойдет на TaskWorkMain.class
    public synchronized static void putPartSum(double sum) {
       totalSum += sum;
    }
}
