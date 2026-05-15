package ru.itis.inf501.lab2_16;

public class TaskRunnableMain {
    public static void main(String[] args) throws InterruptedException {

        int countProc = Runtime.getRuntime().availableProcessors();
        System.out.println(countProc);

        System.out.println("Начало работы");

        Object mutex = new Object();

        Thread task1 = new Thread(new TaskRunnable("Выполняется задача 1", mutex));
        Thread task2 = new Thread(new TaskRunnable("Выполняется задача 2", mutex));
        Thread task3 = new Thread(new TaskRunnable("Выполняется задача 3", mutex));

        System.out.println("Запускаем потоки");
        // запуск start() создает поток и запускает run()
        task1.start();
        task2.start();
        task3.start();

        task1.join(); // блокируется поток main до завершения task1
        task2.join();
        task3.join();

        System.out.println("Завершаем программу");


    }
}
