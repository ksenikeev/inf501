package ru.itis.inf501.lab2_13.jsonmapper;

public class JsonMapper {
    public String write(Object o) {
        // 1. Получить список всех полей
        // 2. Получить значения полей
        // 3. формируем json
        //  значение строка - печатаем пару "имяПоля":"значение"
        //  значение число - печатаем пару "имяПоля":значение
        //  значение объект - печатаем пару "имяПоля":write(value)
        Class clazz = o.getClass();
        //if (clazz.equals(String.class))

        return "{}";
    }
}
