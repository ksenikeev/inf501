package ru.itis.inf501;

public class Animal {
    protected String name;

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
         System.out.println(name + " moved");
    }

    public String toString() {
        return "Зверушка - " + name;
    }
}
