package ru.itis.inf501.lab2_11;

import java.io.*;
import java.util.Date;

/*
    реализовать работу с бинарным файлом, хранящим информацию в следующей форме
    Person
        name: String
        birthday: String(yyyyMMdd)
        gender: byte {0 - M, 1 - F}

        ФОРМАТ:
        Заголовок (HEADER)
        Данные (DATA)

        lenName(1)
        name (lenName)
        birthday: y(2)M(1)d(1)
        gender: (1)
 */
public class DataFileTest {

    private static final String FILE_NAME = "person.dat";

    public static void main(String[] args) throws IOException {
        Person p = new Person();
        p.setName("Абрамский М. М.");
        p.setBirthDate("1988-08-30");
        p.setGender((byte) 0);

        DataFileTest converter = new DataFileTest();
        converter.saveToFile(p);
    }

    public void saveToFile(Person p) throws IOException {
        try (DataOutputStream os = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            //пишем в файл длину имени lenName(1)
            os.writeByte(p.getName().length());
            // пишем name в UTF-8
            os.writeUTF(p.getName());
            // пишем год рождения
            os.writeShort(Short.parseShort(p.getBirthDate().substring(0, 4)));
            // пишем месяц рождения
            os.writeByte(Byte.parseByte(p.getBirthDate().substring(5, 7)));
            // пишем день рождения
            os.writeByte(Byte.parseByte(p.getBirthDate().substring(8, 10)));
            // пишем пол
            os.write(p.getGender());
            os.flush();
        }
    }

    public Person readFromFile() throws IOException {
        try (DataInputStream os = new DataInputStream(new FileInputStream(FILE_NAME))) {

        }
        return null;
    }
}
