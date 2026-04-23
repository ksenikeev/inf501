package ru.itis.inf501.lab2_13;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {
        Group group = new Group();
        group.setName("11-501");

        Student student = new Student("Первый", 18, group);

        //----------------------------------------------------------
        // Определим класс объекта
        System.out.println(student.getClass().getName());
        System.out.println("//----------------------------------");
        // Определяем публичные члены
        Field[] fields = student.getClass().getFields();

        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("//----------------------------------");
        // Определяем все члены
        Field[] allFields = student.getClass().getDeclaredFields();
        for (Field field : allFields) {
            System.out.println(
                    field.getClass().getName() + ":" +
                    field.getName());
        }
        System.out.println("//----------------------------------");
        // Определяем публичные методы
        Method[] methods = student.getClass().getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("//----------------------------------");
        // Определяем публичные методы
        Method[] allMethods = student.getClass().getDeclaredMethods();
        for (Method method : allMethods) {
            System.out.println(method);
        }

        System.out.println("//----------------------------------");
        // Получить значение членов
        // нехороший способ
        for (Field field : allFields) {
            field.setAccessible(true);
            System.out.println(field.get(student));
        }

        // Хороший способ
        for (Field field : allFields) {
            // конструируем имя геттера
            String getterName = "get"
                    + field.getName().substring(0,1).toUpperCase()
                    + field.getName().substring(1);

            Method getter = student.getClass().getMethod(getterName);
            if (getter != null) {
                // вызываем метод
                Object value = getter.invoke(student);
                System.out.println(value);
            }
        }
    }
}
