package br.edu.infnet.appJeffersonAndrade.loader;

import br.edu.infnet.appJeffersonAndrade.domain.Car;
import br.edu.infnet.appJeffersonAndrade.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CarService carService;

    @Override
    public void run(ApplicationArguments args) throws Exception {



        String filePath = ("appJeffersonAndrade/files/car.txt");

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(line -> {
                String[] elements = line.split(";");

                int numberOfDoors = Integer.parseInt(elements[0].trim());
                double trunkSize = Double.parseDouble(elements[1].trim());
                boolean hasSunroof = Boolean.parseBoolean(elements[2].trim());


                Car car = new Car();
                this.carService.incluir(car);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Car c : carService.listar()){
            System.out.println("[CAR]: " + c);
    }

    }

    }

