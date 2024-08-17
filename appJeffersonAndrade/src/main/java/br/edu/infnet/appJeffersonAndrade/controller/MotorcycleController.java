package br.edu.infnet.appJeffersonAndrade.controller;

import br.edu.infnet.appJeffersonAndrade.domain.Motorcycle;
import br.edu.infnet.appJeffersonAndrade.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class MotorcycleController {

    @Autowired
    private MotorcycleService motorcycleService;

    @GetMapping("motorcycle/listar")
    public Collection<Motorcycle> getAllMotorcycles() {

        return motorcycleService.getAll();
    }

    @GetMapping("motorcycle/{id}")
    public Motorcycle getMotorcycles(@PathVariable Integer id) {
        return  motorcycleService.geById(id);
    }

    @PostMapping("motorcycle/creat")
    public String createMotorcycles(@RequestBody Motorcycle motorcycle) {
        motorcycleService.create(motorcycle);
        return "Criado com sucesso!";
    }

    @DeleteMapping("motorcycle/{id}")
    public String deleteMotorcycles(@PathVariable Integer id) {
        motorcycleService.deleteById(id);
        return " Deletado com sucesso!";
    }
}
