package ru.itis.inf501.lab2_8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TestStream {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(3, 6, 5, 11, 18, 0, 9, 22));

        // 1. найти максимум (сразу применяется финализирующий метод)
        Integer max = numbers.stream().max((a, b) -> a - b).get();

        System.out.println(max);

        // 2. найти минимум (сразу применяется финализирующий метод)
        Integer min = numbers.stream().min((a, b) -> a - b).get();

        System.out.println(min);

        // 3. выбрать четные числа и найти их среднее
        Double avg = numbers.stream()
                .filter(a -> a % 2 == 0) // применяем фильтрацию (конвейерный метод)
                .mapToInt(a -> a) // преобразуем в целочисленный стрим (тривиальное преобразование)
                .average().getAsDouble(); // находим среднее (финализирующий метод)

                /*
                new Predicate<Integer>() {
                    public boolean test(Integer a) {
                        return a % 2 == 0
                    }
                }

                 */

        System.out.println(avg);

        // Преобразование списка целых чисел в список строк
        List<String> list = numbers.stream()
                .map(a -> String.valueOf(a)) // описываем способ преобразования числа в строку
                .toList(); // финализирующий метод

        System.out.println(list);
    }
}
