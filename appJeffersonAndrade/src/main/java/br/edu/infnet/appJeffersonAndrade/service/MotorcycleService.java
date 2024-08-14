package br.edu.infnet.appJeffersonAndrade.service;

import br.edu.infnet.appJeffersonAndrade.domain.Motorcycle;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class MotorcycleService {
    private Map<Integer, Motorcycle> mapa = new HashMap<>();
    private  Integer id = 0;

    public void inclusion(Motorcycle motorcycle) {
        motorcycle.setId(++id);
        mapa.put(motorcycle.getId(), motorcycle);
        id = motorcycle.getId();
    }

    public Collection<Motorcycle> listar() {
        return mapa.values();
    }}
