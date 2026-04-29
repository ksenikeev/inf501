package ru.itis.inf501.lab2_15;

import java.lang.module.FindException;
import java.util.Arrays;

public class MathUtil {

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int compare(int a, int b) {
        return a - b;
    }

    public static int divide(int a, int b) throws IllegalArgumentException {
        if (b == 0)
            throw new IllegalArgumentException("Знаменатель не 0!");
        return a / b;
    }

    public static int[] sort(int[] array) {
        // сортировка
        return array;
    }
}
