//package br.edu.infnet.appJeffersonAndrade.loader;
//
//import br.edu.infnet.appJeffersonAndrade.domain.Motorcycle;
//import br.edu.infnet.appJeffersonAndrade.service.MotorcycleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.stream.Stream;
//
//@Component
//public class MotorcycleLoader implements ApplicationRunner {
//
//    @Autowired
//   private MotorcycleService motorcycleService;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//
//        String filePath = ("appJeffersonAndrade/files/motorcycle.txt");
//
//        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
//            lines.forEach(line -> {
//                String[] elements = line.split(";");
//
//                int id = Integer.parseInt(elements[0]);
//                String brand = elements[1].trim();
//                String model = elements[2].trim();
//                String color = elements[3].trim();
//                int year = Integer.parseInt(elements[4].trim());
//                String fuelType = elements[5].trim();
//
//                String motorcycleType = elements[6].trim();
//                int engineDisplacement = Integer.parseInt(elements[7].trim());
//                String startType = elements[8].trim();
//
//                Motorcycle moto = new Motorcycle(id,brand,fuelType,year,color,model,engineDisplacement,startType,motorcycleType);
//                motorcycleService.create(moto);
//                System.out.println(moto);
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for(Motorcycle m: motorcycleService.getAll()){
//            System.out.println("[MotorCycle]: " + m);
//    }
//
//    }
//}
