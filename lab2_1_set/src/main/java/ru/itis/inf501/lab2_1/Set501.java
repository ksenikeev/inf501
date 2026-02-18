package ru.itis.inf501.lab2_1;

public interface Set501 {
/*методы:
размер
проверка на пустоту
проверка наличия элемента
добавление элемента
удаление элемента (по значению)
очистка структуры*/
    int size();
    boolean checkEmpty();
    boolean contains(Object o);
    void add(Object o);
    void delete(Object o);
    void clean();
    Object[] getAll();
}
