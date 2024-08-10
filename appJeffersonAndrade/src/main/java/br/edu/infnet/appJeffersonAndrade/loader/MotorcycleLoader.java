package br.edu.infnet.appJeffersonAndrade.loader;

import br.edu.infnet.appJeffersonAndrade.domain.Car;
import br.edu.infnet.appJeffersonAndrade.domain.Motorcycle;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class MotorcycleLoader implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        String filePath = ("appJeffersonAndrade/motorcycle.txt");

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(line -> {
                String[] elements = line.split(";");

                String motorcycleType = elements[0].trim();
                int engineDisplacement = Integer.parseInt(elements[1].trim());
                String startType = elements[2].trim();

                Motorcycle moto = new Motorcycle(engineDisplacement, motorcycleType, startType);
                System.out.println(moto);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
