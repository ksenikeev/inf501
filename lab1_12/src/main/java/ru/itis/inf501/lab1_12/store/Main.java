package ru.itis.inf501.lab1_12.store;

public class Main {
    public static void main(String[] args) {
        Store store = new Store("s1", "");
        Merch[] products = {
                new Car(store, "13", "bmw", 2),
                new Computer(store, "134", "asus", 12),
                new Tekstil(store, "135", "vvv", 192)};
        for (Merch m : products) {
            m.oformleniePoshlin();
            System.out.println(m);
        }

        Merch car = new Car(store, "13", "Mercedes", 2);

        ((Car)car).getPower();
    }
}
