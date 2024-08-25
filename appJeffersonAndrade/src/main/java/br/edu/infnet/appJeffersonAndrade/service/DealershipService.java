package br.edu.infnet.appJeffersonAndrade.service;

import br.edu.infnet.appJeffersonAndrade.domain.Dealership;
import br.edu.infnet.appJeffersonAndrade.repository.DealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class DealershipService {
    @Autowired
    private DealershipRepository dealershipRepository;

    public void create(Dealership dealership) {
        dealershipRepository.save(dealership);
    }

    public Collection<Dealership> getAll() {
        return dealershipRepository.findAll();
    }

    public Dealership geById(Integer id) {
        return dealershipRepository.findById(id).get();
    }

    public void deleteById(Integer id) {
        dealershipRepository.deleteById(id);
    }
}
