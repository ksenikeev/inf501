package ru.itis.inf501.lab2_3;

public class TestMap {
    public static void main(String[] args) {
        Map501<Integer, String> map = new Map501Impl<>();

        map.put(1, "Один");
        map.put(1, "Один 1");

        System.out.println(map.get(1));

        System.out.println(map.getEntries());
    }
}
