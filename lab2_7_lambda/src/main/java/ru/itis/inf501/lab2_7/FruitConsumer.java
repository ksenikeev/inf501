package ru.itis.inf501.lab2_7;

import java.util.function.Consumer;

public class FruitConsumer implements Consumer<Fruit> {
    public void accept(Fruit t) {
        System.out.println(t.getName() + " : " + t.getPrice());
    }
}
