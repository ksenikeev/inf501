package ru.itis.inf501.lab2_9;

import java.util.List;

public class Geometry {
    private String type;
    private List<Double[]> coordinates;

    public List<Double[]> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double[]> coordinates) {
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
