package br.edu.infnet.appJeffersonAndrade.loader;

import br.edu.infnet.appJeffersonAndrade.domain.Automobile;
import br.edu.infnet.appJeffersonAndrade.domain.Car;
import br.edu.infnet.appJeffersonAndrade.domain.Dealership;
import br.edu.infnet.appJeffersonAndrade.domain.Motorcycle;
import br.edu.infnet.appJeffersonAndrade.service.CarService;
import br.edu.infnet.appJeffersonAndrade.service.DealershipService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private DealershipService dealershipService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String filePath = "appJeffersonAndrade/files/dealership.txt";

//        AtomicReference<Integer> id = new AtomicReference<>(1);
        Map<Integer, Automobile> map = new HashMap<Integer, Automobile>();

        Dealership dealership = null;

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {

            for (String line : (Iterable<String>) lines::iterator) {
                String[] elements = line.split(";");
                switch (elements[0].toUpperCase()) {
                    case "D":

                        if (dealership != null) {
                            dealershipService.create(dealership);
                        }
                        dealership = new Dealership();

                        Integer iD = Integer.parseInt(elements[1].trim());
                        String name = elements[2].trim();
                        String email = elements[3].trim();
                        String phone = elements[4].trim();
                        String cnpj = elements[5].trim();

                        dealership.setId(iD);
                        dealership.setName(name);
                        dealership.setEmail(email);
                        dealership.setPhone(phone);
                        dealership.setCnpj(cnpj);
                        break;
                    case "M":
                        if (dealership == null) {
                            throw new IllegalStateException("A Motorcycle was found before a Dealership.");
                        }
                        int id = Integer.parseInt(elements[1].trim());
                        String brand = elements[2].trim();
                        String model = elements[3].trim();
                        String color = elements[4].trim();
                        int year = Integer.parseInt(elements[5].trim());
                        String fuelType = elements[6].trim();
                        String motorcycleType = elements[7].trim();
                        int engineDisplacement = Integer.parseInt(elements[8].trim());
                        String startType = elements[9].trim();

                        Motorcycle moto = new Motorcycle(id, brand, fuelType, year, color, model, engineDisplacement, startType, motorcycleType);

                        dealership.getAutomobiles().add(moto);
                        break;
                    case "C":
                        if (dealership == null) {
                            throw new IllegalStateException("A Car was found before a Dealership.");
                        }
                        id = Integer.parseInt(elements[1].trim());
                        brand = elements[2].trim();
                        model = elements[3].trim();
                        color = elements[4].trim();
                        year = Integer.parseInt(elements[5].trim());
                        fuelType = elements[6].trim();
                        int numberOfDoors = Integer.parseInt(elements[7].trim());
                        double trunkSize = Double.parseDouble(elements[8].trim());
                        boolean hasSunroof = Boolean.parseBoolean(elements[9].trim());

                        Car car = new Car(id, brand, fuelType, year, color, model, numberOfDoors, trunkSize, hasSunroof);

                        dealership.getAutomobiles().add(car);
                        break;
                    default:
                        System.out.println("Unknown type: " + elements[0].toUpperCase());
                }
            }

            if (dealership != null) {
                dealershipService.create(dealership);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Automobile automobile : map.values()) {
            System.out.println("[Automobile]: " + automobile);
        }
    }

}
