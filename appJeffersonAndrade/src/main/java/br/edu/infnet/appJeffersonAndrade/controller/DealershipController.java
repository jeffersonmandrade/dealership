package br.edu.infnet.appJeffersonAndrade.controller;

import br.edu.infnet.appJeffersonAndrade.domain.Dealership;
import br.edu.infnet.appJeffersonAndrade.domain.Motorcycle;
import br.edu.infnet.appJeffersonAndrade.service.DealershipService;
import br.edu.infnet.appJeffersonAndrade.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class DealershipController {

    @Autowired
    private DealershipService dealershipService;

    @GetMapping("dealership/listar")
    public Collection<Dealership> listar() {

        return dealershipService.listar();
    }
}
