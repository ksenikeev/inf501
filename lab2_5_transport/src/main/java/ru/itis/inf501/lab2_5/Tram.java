package ru.itis.inf501.lab2_5;

public class Tram extends Transport{
    public Tram(String number, String routeNumber,
                String workTimeBegin, String workTimeEnd) {
        super(TransportType.tram, number, routeNumber, workTimeBegin, workTimeEnd);
    }
}
