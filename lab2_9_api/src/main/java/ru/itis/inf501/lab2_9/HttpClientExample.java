package ru.itis.inf501.lab2_9;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {
    public static void main(String[] args) {
        try {
            // Создаем клиент
            HttpClient client = HttpClient.newHttpClient();

            String url = "https://yandex.ru/maps/api/masstransit/getVehiclesInfoWithRegion?ajax=1&csrfToken=4fd11ee112192bfdf089f9dbc4be284d60851b67%3A1774418302&lang=ru&lineId=2079775734&ll=49.132378%2C55.803212&locale=ru_RU&s=716464481&sessionId=1774418301922270-10466358929881314970-balancer-l7leveler-kubr-yp-vla-107-BAL&spn=0.108662%2C0.094172&type=bus";

            // Создаем запрос
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .header("Accept", "text/plain")
                    .header("cookie","")
                    .build();

            // Отправляем запрос и получаем ответ
            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            // Получаем статус и тело ответа
            System.out.println("Status: " + response.statusCode());
            System.out.println("Body: " + response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}