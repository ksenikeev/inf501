package ru.itis.inf501.lab1_13;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ExceptTest {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner scanner;

        System.out.println("Введите число 1:");

        while (true)
            try {
                scanner = new Scanner(System.in);
                a = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введите правильное число");
            }

        System.out.println("Введите число 2:");
        while (true)
            try {
                scanner = new Scanner(System.in);
                b = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введите правильное число");
            }

        try {
            System.out.printf("частное чисел %d/%d = %d", a, b, a / b);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
}
