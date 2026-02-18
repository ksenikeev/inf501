package ru.itis.inf501.lab2_1.generic;

public interface Set501Gen<T> {
/*методы:
размер
проверка на пустоту
проверка наличия элемента
добавление элемента
удаление элемента (по значению)
очистка структуры*/
    int size();
    boolean checkEmpty();
    boolean contains(T o);
    void add(T o);
    void delete(T o);
    void clean();
    Object[] getAll();
}
