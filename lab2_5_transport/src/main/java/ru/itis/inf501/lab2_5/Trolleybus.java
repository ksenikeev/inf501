package ru.itis.inf501.lab2_5;

public class Trolleybus extends Transport{
    public Trolleybus(String number, String routeNumber,
                      String workTimeBegin, String workTimeEnd) {
        super(TransportType.trolleybus, number, routeNumber, workTimeBegin, workTimeEnd);
    }
}
