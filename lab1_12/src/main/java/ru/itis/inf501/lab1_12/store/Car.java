package ru.itis.inf501.lab1_12.store;

public class Car extends Merch{

    public Car(Store store, String articul, String name, int count) {
        super(store, articul, name, count);
    }

    public int getPower() {
        return 500;
    }

    @Override
    public void oformleniePoshlin() {
        poshlina = 1_000_000;
    }
}
