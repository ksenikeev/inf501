package ru.itis.inf501;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TestLambda {
    public static void main(String[] args) {
        Predicate<String> predicate =
                (s) -> s.startsWith("Муз");

        List<Integer> arr = new ArrayList<>(List.of(1,553,212,434,21));
        arr.replaceAll((arg) -> arg % 16);
        arr.forEach((a) -> System.out.println(a));
    }
}
