package br.edu.infnet.appJeffersonAndrade.controller;

;
import br.edu.infnet.appJeffersonAndrade.controller.dto.DealershipDTO;
import br.edu.infnet.appJeffersonAndrade.domain.Dealership;
import br.edu.infnet.appJeffersonAndrade.service.DealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class DealershipController {

    @Autowired
    private DealershipService dealershipService;

    @GetMapping("dealership/list")
    public Collection<Dealership> listar() {
        return dealershipService.getAll();
    }

    @GetMapping("dealership/{id}")
    public Dealership getDealership(@PathVariable Integer id) {
        return  dealershipService.geById(id);
    }

    @PostMapping("delearship/creat")
    public String createDealership(@RequestBody DealershipDTO dealership) {
        dealershipService.create(dealership.toDomain());
        return "Criado com sucesso!";
    }

    @DeleteMapping("dealership/{id}")
public String deleteDealership(@PathVariable Integer id) {
        dealershipService.deleteById(id);
        return " Deletado com sucesso!";
    }
}
