package ru.itis.inf501.lab2_13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) throws ParseException {

        // Текущее время - дата
        Date date = new Date();

        // выведем кол-во миллисекунд с 01.01.1970
        System.out.println(date.getTime());

        // Задание конкретной даты
        // + 1 сутки
        Date date2 = new Date(date.getTime() + 1000 * 60 * 60 * 24);
        System.out.println(date2);

        Date date3 = new SimpleDateFormat("dd.MM.yyyy").parse("21.05.2026");
        System.out.println(date3);

        // Вывести красиво дату и время

        System.out.println(new SimpleDateFormat("dd.MM.yy hh:mm:ss").format(date));
        System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm").format(date));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));

    }
}
