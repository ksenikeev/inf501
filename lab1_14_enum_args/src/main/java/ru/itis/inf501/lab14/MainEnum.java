package ru.itis.inf501.lab14;

public class MainEnum {
    public static void main(String[] args) {

        for (int i = 0; i < args.length; ++i) {
            System.out.println(args[i]);
        }

        Color color = Color.Green;

        System.out.println(color.name());
    }
}
