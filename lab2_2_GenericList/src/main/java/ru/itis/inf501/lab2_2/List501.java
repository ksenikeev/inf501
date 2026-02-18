package ru.itis.inf501.lab2_2;

public interface List501<T> {
    /*методы:
    размер
    проверка на пустоту
    проверка наличия элемента
    добавление элемента
    удаление элемента (по индексу)
    очистка структуры
    получение элемента по индексу

    Разработать реализацию на массиве как внутреннем хранилище,
    Элементы - <T>
     */

    int size();
    boolean isEmpty();
    boolean isExist(T o);
    void add(T o);
    T delete(int i);
    void clean();
    T get(int i);
}
