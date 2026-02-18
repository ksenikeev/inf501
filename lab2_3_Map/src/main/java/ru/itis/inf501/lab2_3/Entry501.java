package ru.itis.inf501.lab2_3;

/*
    Дженерики двух типов: K - для ключа, V - для значения
 */
public interface Entry501<K, V> {
    K getKey();
    V getValue();
}
