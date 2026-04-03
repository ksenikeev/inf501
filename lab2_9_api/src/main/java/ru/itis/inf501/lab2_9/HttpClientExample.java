package ru.itis.inf501.lab2_9;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {
    public static void main(String[] args) {
        try {
            // Создаем клиент
            HttpClient client = HttpClient.newHttpClient();

            String url = "https://yandex.ru/maps/api/masstransit/getVehiclesInfoWithRegion?ajax=1&csrfToken=2be6bc693e61a665c1c0021ee3d44480ada29e57%3A1774430860&lang=ru&ll=49.115588%2C55.813611&locale=ru_RU&s=2626370372&sessionId=1774430859899619-16724694248173115061-balancer-l7leveler-kubr-yp-klg-25-BAL&spn=0.113417%2C0.088684&type=bus";

            // Создаем запрос
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .header("Accept", "text/plain")
                    .header("cookie","yuidss=1297249381731249722; _ym_uid=173124973731802944; yandexuid=1297249381731249722; adrdel=1740064835973; adrcid=AmCKaa9tyQSJ2bEa0o8DSzA; acs_3=%7B%22hash%22%3A%222519d36ba1d6b3a4bd08e045fbf175fd06f869ed%22%2C%22nextSyncTime%22%3A1740151235979%2C%22syncLog%22%3A%7B%22224%22%3A1740064835979%2C%221228%22%3A1740064835979%7D%7D; my=YycCAAEA; ymex=2078371797.yrts.1763011797; _ym_d=1764828012; gdpr=0; yashr=1936976301770184478; is_gdpr=0; is_gdpr_b=CMzOaRCq8wIoAg==; i=mtb/OhpD9MLtV6PqDpofBDdhsxBJKObyMoYgvgPwySgRsGgSJagq4F7iUNuNZhXEYpr7D8nzYEPCR1hYA0lpP1pj93c=; pi=9l/7kh5JWDKBFM53SePv3Zn33WD81y4duO3mbIwkjfG90XxRqac0clguU/V7ApW3x3uAH5ViKhM2qaLJCo8KQkSUbMY=; _ym_isad=1; sae=0:fbf46b0a-dc65-4527-af74-f61bB9BA5735:c:25.2.4.1000:l:d:RU:20241110; instruction=1; L=QxhlAnNeVkRAYAcFWGtlY05pfXBSBXVwV1QoGTkIDAZZOyEQViM=.1774430820.1791208.328118.0ff12f55b18a3782b7f3bc5aeb9dff3f; yandex_login=; ys=c_chck.1476213504; _ym_visorc=b; _yasc=BXcbJmDYfIKNS8m0xoNW4DlZOU8/D2vX40FAntr4irJAKvSneY6kZ04QV17ZYeYBBuGtsQoDVeRkKOcn; maps_session_id=1774430859899619-16724694248173115061-balancer-l7leveler-kubr-yp-klg-25-BAL; yandex_expboxes=1518098%2C0%2C63%3B1517701%2C0%2C65%3B1512069%2C0%2C78%3B1512800%2C0%2C14%3B912281%2C0%2C87%3B1493354%2C0%2C42%3B1502455%2C0%2C58%3B1509085%2C0%2C80%3B663872%2C0%2C7%3B1257223%2C0%2C92; gpauto=55_791194:49_122077:140:0:1774430854; gpb=gpauto.55_791194%3A49_122077%3A140%3A0%3A1774430854; yp=1774517165.uc.ru#1774517165.duc.ru#1794547797.cld.2707771#1800735352.dc_neuro.7#1774526489.dlp.2#1776340889.hdrc.1#2083741356.multib.1#2089022488.pcs.0#1802458260.swntab.0#1773798373.szm.1:1920x1080:1876x1004:15#1774438065.gpauto.55_791194:49_122077:140:0:1774430854; bh=EmoiTm90IEEoQnJhbmQiO3Y9IjgiLCAiQ2hyb21pdW0iO3Y9IjEzMiIsICJZYUJyb3dzZXIiO3Y9IjI1LjIiLCAiWW93c2VyIjt2PSIyLjUiLCAiWWFCcm93c2VyQ29ycCI7dj0iMTMyLjAiGgUieDg2IiINIjI1LjIuNC4xMDAwIioCPzAyAiIiOgciTGludXgiQgkiNS4xMC44MiJKBCI2NCJSgwEiTm90IEEoQnJhbmQiO3Y9IjguMC4wLjAiLCAiQ2hyb21pdW0iO3Y9IjEzMi4wLjY4MzQuMTAwMCIsICJZYUJyb3dzZXIiO3Y9IjI1LjIuNC4xMDAwIiwgIllvd3NlciI7dj0iMi41IiwgIllhQnJvd3NlckNvcnAiO3Y9IjEzMi4wIloCPzBgl9WOzgZqHNzK6YgO8qy3pQv7+vDnDev//fYPoeiflA/zgQI=")
                    .build();

            // Отправляем запрос и получаем ответ
            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            // Получаем статус и тело ответа
            System.out.println("Status: " + response.statusCode());

            String body = response.body();

            System.out.println("Body: " + body );

            ObjectMapper mapper = new ObjectMapper();

            Vehicles vehicles = mapper.readValue(body, Vehicles.class);

            vehicles.getData().getVehicles().stream()
                .forEach(v -> System.out.println(
                        v.getProperties().getVehicleMetaData()
                                .getTransport().getName()
                ));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}