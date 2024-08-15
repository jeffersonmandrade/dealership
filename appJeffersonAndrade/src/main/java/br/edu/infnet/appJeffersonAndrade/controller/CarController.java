package br.edu.infnet.appJeffersonAndrade.controller;

import br.edu.infnet.appJeffersonAndrade.domain.Car;
import br.edu.infnet.appJeffersonAndrade.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("car/listar")
    public Collection<Car> listar() {
       return carService.listar();
    }
}
