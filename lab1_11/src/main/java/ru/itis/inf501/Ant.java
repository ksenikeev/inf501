package ru.itis.inf501;

public class Ant extends Animal {

    @Override
    public void move() {
        System.out.println("Ход муравья " + name);
    }
}
