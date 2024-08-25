package br.edu.infnet.appJeffersonAndrade.service;

import br.edu.infnet.appJeffersonAndrade.domain.Dealership;
import br.edu.infnet.appJeffersonAndrade.domain.Motorcycle;
import br.edu.infnet.appJeffersonAndrade.repository.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class MotorcycleService {

    @Autowired
    private MotorcycleRepository motorcycleRepository;


    public void create(Motorcycle motorcycle) {
        motorcycleRepository.save(motorcycle);
    }

    public Collection<Motorcycle> getAll() {
        return motorcycleRepository.findAll();
    }

    public Motorcycle geById(Integer id) {
        return motorcycleRepository.findById(id).get();
    }

    public void deleteById(Integer id) {
        motorcycleRepository.deleteById(id);
    }

}

