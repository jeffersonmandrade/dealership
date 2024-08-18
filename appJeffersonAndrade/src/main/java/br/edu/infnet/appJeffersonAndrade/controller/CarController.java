package br.edu.infnet.appJeffersonAndrade.controller;

import br.edu.infnet.appJeffersonAndrade.controller.dto.CarDTO;
import br.edu.infnet.appJeffersonAndrade.domain.Car;
import br.edu.infnet.appJeffersonAndrade.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("car/list")
    public Collection<Car> getAllCars() {
       return carService.getAll();
    }

    @GetMapping("car/{id}")
    public Car getCar(@PathVariable Integer id) {
        return  carService.geById(id);
    }

    @PostMapping("car/creat")
    public String createCar(@RequestBody CarDTO car) {
        carService.create(car.toDomain());
        return "Criado com sucesso!";
    }

    @DeleteMapping("car/{id}")
    public String deleteCar(@PathVariable Integer id) {
        carService.deleteById(id);
        return " Deletado com sucesso!";
    }
}
