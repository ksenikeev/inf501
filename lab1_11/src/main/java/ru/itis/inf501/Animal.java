package ru.itis.inf501;

public class Animal {
    private String name;

    public Animal() {
        this.name = this.getClass().getName();
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move() {

    }

    public String toString() {
        return "Зверушка - " + name;
    }
}
