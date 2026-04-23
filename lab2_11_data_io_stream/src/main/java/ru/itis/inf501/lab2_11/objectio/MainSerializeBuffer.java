package ru.itis.inf501.lab2_11.objectio;

import java.io.*;

public class MainSerializeBuffer {
    public static void main(String[] args) {
        // 1. Создаем объект
        Car car = new Car("KIA RIO", "седан", "12312313");
        // 2. Сериализуем объект

        byte[] buffer;

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(bos)) {

            os.writeObject(car);
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream is = new ObjectInputStream(
                new ByteArrayInputStream(buffer))) {

            Car car1 = (Car) is.readObject();
            System.out.println(car1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
