package ru.itis.inf501.lab2_11.objectio;

import java.io.*;

public class MainSerialize {
    public static void main(String[] args) {
        // 1. Создаем объект
        Car car = new Car("KIA RIO", "седан", "12312313");
        // 2. Сериализуем объект

        try (FileOutputStream fos = new FileOutputStream("car.obj", true);
                ObjectOutputStream os = new ObjectOutputStream(fos)) {

            os.writeObject(car);
            fos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("car.obj"))) {
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
