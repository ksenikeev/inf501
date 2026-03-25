package ru.itis.inf501.lab2_8;

//2. Список целых чисел отсортировать по убыванию, преобразовать
//в список дйствительных чисел из корней исходных чисел

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>(List.of(
                12, 3, 56, 123, 1, 32, 81
        ));
        List<Double> newList = list.stream()
                .sorted((a, b) -> b - a)
                .map(a -> Math.sqrt(a))
                .toList();
        System.out.println(newList);

        List<String> list1 = new ArrayList<>(List.of(
                "Сыр","Карп","Приве","Сорок","Цапля"));
        List<String> list2 = list1.stream()
                .filter(a -> a.length() == 5)
                .sorted().toList();

        System.out.println(list2);

    }
}
