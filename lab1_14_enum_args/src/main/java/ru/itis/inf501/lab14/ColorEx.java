package ru.itis.inf501.lab14;

public enum ColorEx {
    Red(1),
    Yellow(2),
    Green(3);

    private int code;
    ColorEx(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

/*

public class Color {
    private String name;
    public Color(String name) {
        this.name = name;
    }

    public static Color Red = new Color("Red");
    public static Color Yellow = new Color("Yellow");
    public static Color Green = new Color("Green");
}

 */