package ru.itis.inf501.lab1_13;

public class TestHashString {
    public static void main(String[] args) {
        String a = "hello!";

        String b = new String(new char[]{'h','e','l','l','o','!'});

        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
