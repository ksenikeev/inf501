package ru.itis.inf501.lab2_8.booking;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Exercises {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        BookingData data;
        try {
            data = mapper.readValue(new File("bookings.json"), BookingData.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

            //1. Найти гостиницу с максимальным числом броней за январь 2023 года
        String hotel = data.getBookings().stream()
                .filter(a -> a.getArrivaldate().startsWith("2022-01"))
                .collect(Collectors.toMap(
                        k -> k.getHotel().getName(),
                        v -> 1,
                        (a, b) -> a + b
                ))
                .entrySet().stream()
                .max((a, b) ->
                        a.getValue() - b.getValue()).get().getKey();

        //2. Вывести список городов из которых прибыли мужчины от 35 до 45 лет (смотрим только год рождения)
        data.getBookings().stream()
                        .filter(a -> {
                            if (a.getPerson().getBirthdate() == null) return false;
                            String str = a. getPerson().getBirthdate().substring(0, 4);
                            if (str == null) return false;
                            Integer i = Integer.parseInt(str);
                            if (i >= 1973 && i <= 1983) {
                                return true;
                            } else {
                                return false;
                            }
                        })
                                .collect(Collectors.toMap(
                                        b -> b.getPerson().getFromcity(),
                                        b -> 1,
                                        (a,b) -> a + b
                                )).forEach((a,b) -> System.out.println(a));
        System.out.println(hotel);


//        вывести список гостиниц (названия) в которых проживали дети до 14 лет
//                (сравниваем год регистрации и год рождения)
        data.getBookings().stream()
                .filter(a -> {
                    if (a.getPerson().getBirthdate() == null) return false;
                    if (a.getArrivaldate() == null) return false;
                    String str = a. getPerson().getBirthdate().substring(0, 4);
                    if (str == null) return false;
                    Integer i = Integer.parseInt(str);
                    String str1 = a. getArrivaldate().substring(0, 4);
                    Integer d = Integer.parseInt(str1);
                    if (d - i <= 14 && d-i >= 0) {
                        return true;
                    } else {
                        return false;
                    }

                })
                .map(a -> a.getHotel().getName())
                .collect(Collectors.toSet())
                .forEach(a -> System.out.println(a));
//        4. вывести список людей с количеством бронирований больше 3
        data.getBookings().stream().collect(Collectors.toMap(
                b -> b.getPerson(),
                b -> 1,
                (a,b) -> a+b
        )).entrySet().stream()
                .filter(e -> e.getValue() > 3)
                .forEach(e -> System.out.println(e.getKey()));

        //5 5. Вывести гостиницы в которых проживали женщины из Санкт-Петербурга
        //в период с февраля по март 2022 года (использовать несколько фильтров)
        data.getBookings().stream()
                .filter(a -> a.getPerson().getGender() != null && a.getPerson().getGender().equals("Female"))
                .filter(a -> a.getPerson().getFromcity() != null && a.getPerson().getFromcity().contains("Город Санкт-Петербург"))
                .filter(a -> proverka(a.getArrivaldate(),a.getDeparturedate()))
                .map(a -> a.getHotel().getName())
                .forEach(a -> System.out.println(a));
        // 7. вывести список проживающих в гостинице с id=123, приехавших из Самарской области с апреля по май 2023г.
        data.getBookings().stream()
                .filter(a -> a.getHotel().getId() == 123)
                .filter(a -> a.getPerson().getFromcity().contains("Самарская область"))
                .filter(a -> a.getArrivaldate().startsWith("2022-03") || a.getArrivaldate().startsWith("2022-04"))
                .forEach(a -> System.out.println(a.getPerson().toString()));


    }

    public static boolean proverka(String a, String s) {
        if (a == null || s == null) return false;
        int a1 = Integer.parseInt(a.substring(5,7));
        int s1 = Integer.parseInt(s.substring(5,7));
        return (a1 <= 3 && s1 >= 2);

    }
}
