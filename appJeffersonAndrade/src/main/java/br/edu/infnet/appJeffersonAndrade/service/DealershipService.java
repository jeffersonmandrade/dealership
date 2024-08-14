package br.edu.infnet.appJeffersonAndrade.service;

import br.edu.infnet.appJeffersonAndrade.domain.Car;
import br.edu.infnet.appJeffersonAndrade.domain.Dealership;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class DealershipService {
    private Map<Integer, Dealership>  mapa = new HashMap<>();
    private  Integer id = 0;

    public void incluir(Dealership dealership) {
        dealership.setId(++id);
        mapa.put(dealership.getId(), dealership);
        id = dealership.getId();
    }

    public Collection<Dealership> listar() {
        return mapa.values();
    }
}
