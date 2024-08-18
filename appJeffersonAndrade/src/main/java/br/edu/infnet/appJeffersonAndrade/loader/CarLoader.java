package br.edu.infnet.appJeffersonAndrade.loader;

import br.edu.infnet.appJeffersonAndrade.domain.Car;
import br.edu.infnet.appJeffersonAndrade.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class CarLoader implements ApplicationRunner {

    @Autowired
    private CarService carService;

    @Override
    public void run(ApplicationArguments args) throws Exception {



        String filePath = ("appJeffersonAndrade/files/car.txt");

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(line -> {
                String[] elements = line.split(";");

                int id = Integer.parseInt(elements[0]);
                String brand = elements[1].trim();
                String model = elements[2].trim();
                String color = elements[3].trim();
                int year = Integer.parseInt(elements[4].trim());
                String fuelType = elements[5].trim();

                int numberOfDoors = Integer.parseInt(elements[6].trim());
                double trunkSize = Double.parseDouble(elements[7].trim());
                boolean hasSunroof = Boolean.parseBoolean(elements[8].trim());


                Car car = new Car(id, brand,fuelType, year,color,model,numberOfDoors,trunkSize,hasSunroof);
                this.carService.create(car);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Car c : carService.getAll()){
            System.out.println("[CAR]: " + c);
    }

    }

    }

