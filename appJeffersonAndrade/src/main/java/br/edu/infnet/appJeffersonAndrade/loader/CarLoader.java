package br.edu.infnet.appJeffersonAndrade.loader;

import br.edu.infnet.appJeffersonAndrade.domain.Car;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class CarLoader implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        String filePath = ("appJeffersonAndrade/car.txt");

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(line -> {
                String[] elements = line.split(";");

                int numberOfDoors = Integer.parseInt(elements[0].trim());
                double trunkSize = Double.parseDouble(elements[1].trim());
                boolean hasSunroof = Boolean.parseBoolean(elements[2].trim());

                Car car = new Car(numberOfDoors,trunkSize, hasSunroof);
                System.out.println(car);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }

