package br.edu.infnet.appJeffersonAndrade.loader;

import br.edu.infnet.appJeffersonAndrade.domain.Automobile;
import br.edu.infnet.appJeffersonAndrade.domain.Car;
import br.edu.infnet.appJeffersonAndrade.domain.Dealership;
import br.edu.infnet.appJeffersonAndrade.domain.Motorcycle;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

@Component
public class DealershipLoader implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String filePath = "appJeffersonAndrade/files/dealership.txt";

        Dealership dealership = new Dealership();
         AtomicReference<Integer> id = new AtomicReference<>(1);
        Map<Integer, Automobile> map = new HashMap<Integer, Automobile>();

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(line -> {
                String[] elements = line.split(";");
                switch (elements[0].toUpperCase()) {
                    case "D":
                        String name = elements[1].trim();
                        String email = elements[2].trim();
                        String phone = elements[3].trim();
                        String cnpj = elements[4].trim();

                        dealership.setName(name);
                        dealership.setEmail(email);
                        dealership.setPhone(phone);
                        dealership.setCnpj(cnpj);
                        break;
                    case "M":
                        String brand = elements[1].trim();
                        String model = elements[2].trim();
                        String color = elements[3].trim();
                        int year = Integer.parseInt(elements[4].trim());
                        String fuelType = elements[5].trim();
                        String motorcycleType = elements[6].trim();
                        int engineDisplacement = Integer.parseInt(elements[7].trim());
                        String startType = elements[8].trim();

                        Motorcycle moto = new Motorcycle(brand, fuelType, year, color, model, engineDisplacement, startType, motorcycleType);

                        moto.setId(id.get());
                        map.put(id.get(), moto);
                        id.set(id.get() + 1);

                        dealership.getAutomobiles().add(moto);
                        System.out.println(dealership.toString());
                        break;
                    case "C":
                        brand = elements[1].trim();
                        model = elements[2].trim();
                        color = elements[3].trim();
                        year = Integer.parseInt(elements[4].trim());
                        fuelType = elements[5].trim();
                        int numberOfDoors = Integer.parseInt(elements[6].trim());
                        double trunkSize = Double.parseDouble(elements[7].trim());
                        boolean hasSunroof = Boolean.parseBoolean(elements[8].trim());

                        Car car = new Car(brand, fuelType, year, color, model, numberOfDoors, trunkSize, hasSunroof);

                        car.setId(id.get());
                        map.put(id.get(), car);
                        id.set(id.get() + 1);

                        dealership.getAutomobiles().add(car);

                        System.out.println(dealership.toString());
                        break;
                    default:
                        System.out.println("Unknown type: " + elements[0].toUpperCase());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Automobile automobile : map.values()) {
            System.out.println("[Automobile]: " + automobile);
        }
    }
}
