package ru.itis.inf501.lab2_13;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Создать экземпляр класса Student
 * для полей отмеченных аннотацией @DefaultValue задать значение из атрибута аннотации
 */
public class MainAnnotationReader {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Student.class;

        // 1. Создание экземпляра класса
        Constructor constructor = clazz.getConstructor();

        Student student = (Student) constructor.newInstance();

        System.out.println(student);

        // 2. Считываем список всех членов
        Field[] fields = clazz.getDeclaredFields();

        // 3. Ищем среди членов класса аннотированные DefaultValue
        for (Field field : fields) {
            if (field.isAnnotationPresent(DefaultValue.class)) {
                Annotation annotation = field.getAnnotation(DefaultValue.class);
                String value = ((DefaultValue)annotation).value();
                field.setAccessible(true);
                field.set(student, value);
            }
        }

        System.out.println(student);
    }
}
