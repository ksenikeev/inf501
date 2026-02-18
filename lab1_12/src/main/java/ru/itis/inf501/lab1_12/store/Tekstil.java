package ru.itis.inf501.lab1_12.store;

public class Tekstil extends Merch{

    public Tekstil(Store store, String articul, String name, int count) {
        super(store, articul, name, count);
    }
    @Override
    public void oformleniePoshlin() {
        poshlina = 100;
    }
}
