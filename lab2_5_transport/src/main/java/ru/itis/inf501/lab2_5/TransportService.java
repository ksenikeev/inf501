package ru.itis.inf501.lab2_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransportService {
    private static final String FILE_NAME = "transport.csv";

    public List<Transport> readAll() {
        try {
            Scanner scanner = new Scanner(new File(FILE_NAME));
            List<Transport> result = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //
                String[] data = line.split(";");
                Transport transport =
                    switch (data[0]) {
                        case "bus" -> new Bus(data[1], data[2], data[3], data[4]);
                        case "tram" -> new Tram(data[1], data[2], data[3], data[4]);
                        case "trolleybus" -> new Trolleybus(data[1], data[2], data[3], data[4]);
                        default -> null;
                    };
                if (transport != null) result.add(transport);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
