package ru.itis.inf501.lab1_12.store;
/*
Создать иерархическую структуру классов, описывающих перемещение товара между складами:
Класс Склад (кодСклада, храним что-то типа СКЛ1, СКЛ2, …; адресСклада, храним как строку), наличие конструктора с аргументами, инициализирующими члены класса.
Интерфейс ПеремещениеТовара, один метод,  возвращает целое число перемещенных товаров, принимает на вход склад, количество.
Абстрактный класс Товар, реализует интерфейс ПеремещениеТовара
(артикул, наименование, склад, количество, пошлина),
наличие конструктора с аргументами, инициализирующими члены класса,
реализация интерфейса,
описание абстрактного метода оформлениеТаможеннойПошлины()

Создать Классы, описывающие автомобили, компьютеры, одежда (текстиль)

 */
public abstract class Merch implements MoveMerch {
    private Store store;
    private String articul;
    private String name;
    private int count;
    protected int poshlina;

    public Merch(Store store, String articul, String name, int count) {
        this.store = store;
        this.name = name;
        this.articul = articul;
        this.count = count;
    }
    public int move(Store store, int count) {
        this.store = store;
        this.count = this.count - count;
        return count;
    }

    public abstract void oformleniePoshlin();

    public int getPoshlina() {
        return poshlina;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        return name + " " + store + " " + count + " " + poshlina;
    }

}
