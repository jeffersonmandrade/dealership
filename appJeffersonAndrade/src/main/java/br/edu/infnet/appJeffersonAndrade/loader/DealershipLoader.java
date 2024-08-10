package br.edu.infnet.appJeffersonAndrade.loader;

import br.edu.infnet.appJeffersonAndrade.domain.Dealership;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class DealershipLoader implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String filePath = "appJeffersonAndrade/dealership.txt";

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(line -> {
                String[] elements = line.split(";");

                String name = elements[0].trim();
                String email = elements[1].trim();
                String phone = elements[2].trim();
                String cnpj = elements[3].trim();

                Dealership dealership = new Dealership(name, email, phone, cnpj);

                System.out.println(dealership);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

