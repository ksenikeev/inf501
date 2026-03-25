package ru.itis.inf501.lab2_8.booking;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainBooking {
    public static void main(String[] args) {
        // считаем файл в объект BookingData
        ObjectMapper mapper = new ObjectMapper();

        try {
            BookingData data = mapper.readValue(new File("bookings.json"), BookingData.class);

            //data.getBookings().forEach(b -> System.out.println(b.getId()));
            long countMale = data.getBookings().stream()
                    .filter(b -> b.getHotel().getId() == 150)
                    .filter(b -> b.getPerson().getGender().equals("Male"))
                    .count();

            long countFemale = data.getBookings().stream()
                    .filter(b -> b.getHotel().getId() == 150)
                    .filter(b -> b.getPerson().getGender().equals("Female"))
                    .count();

            Map<String, Integer> hotelCount = data.getBookings().stream()
                    .collect(Collectors.toMap(
                            b -> b.getHotel().getName(), // как формируется ключ
                            b -> 1, // как формируется значение
                            (a, b) -> a + b // разрешаем конфликт разных значений
                                    // для одного ключа
                    ));

            System.out.println("Females: " + countFemale + ", Males:" + countMale);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
