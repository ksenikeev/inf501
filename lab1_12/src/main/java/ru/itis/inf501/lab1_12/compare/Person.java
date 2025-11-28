package ru.itis.inf501.lab1_12.compare;

public class Person implements Comparable {
    public String name;
    public int height;

    public int compareTo(Comparable other) {
        return this.height - ((Person)other).height;
    }
}
