package ru.itis.inf501.lab1_13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptTest2 {

    private static int inputNumber() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        try {
            result = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException();
        } finally {
            scanner.close();
        }
        return result;
    }

    public static void main(String[] args) {
        int a;
        int b;

        System.out.println("Введите число 1:");
        a = inputNumber();
        System.out.println("Введите правильное число");

        System.out.println("Введите число 2:");
    }
}
