package br.edu.infnet.appJeffersonAndrade.loader;

import br.edu.infnet.appJeffersonAndrade.domain.Automobile;
import br.edu.infnet.appJeffersonAndrade.domain.Car;
import br.edu.infnet.appJeffersonAndrade.domain.Motorcycle;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Component
public class AutomobileLoader implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String filePath = ("appJeffersonAndrade/files/automobile.txt");
        Map<Integer, Automobile> map = new HashMap<Integer, Automobile>();
        Integer id = 0;

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(line -> {
                String[] elements = line.split(";");
                 String brand = elements[0].trim();
                 String model = elements[1].trim();
                 String color = elements[2].trim();
                 int year = Integer.parseInt(elements[3].trim());
                 String fuelType = elements[4].trim();

                Automobile automobile = new Automobile(brand,model,year,color,fuelType);
                automobile.setId(id + 1);
                map.put(automobile.getId(), automobile);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Automobile automobile : map.values()) {
            System.out.println("[Automobile]: " + automobile);
        }
    }
}
