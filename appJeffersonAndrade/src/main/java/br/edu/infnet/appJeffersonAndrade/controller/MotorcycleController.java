package br.edu.infnet.appJeffersonAndrade.controller;

import br.edu.infnet.appJeffersonAndrade.domain.Motorcycle;
import br.edu.infnet.appJeffersonAndrade.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MotorcycleController {

    @Autowired
    private MotorcycleService motorcycleService;

    @GetMapping("moto/listar")
    public Collection<Motorcycle> listar() {

        return motorcycleService.listar();
    }
}
