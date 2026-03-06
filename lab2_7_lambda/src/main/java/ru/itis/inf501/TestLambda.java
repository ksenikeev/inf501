package ru.itis.inf501;

import java.util.function.Predicate;

public class TestLambda {
    public static void main(String[] args) {
        Predicate<String> predicate =
                (s) -> s.startsWith("Муз");
    }
}
