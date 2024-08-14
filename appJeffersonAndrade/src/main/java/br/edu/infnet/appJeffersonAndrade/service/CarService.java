package br.edu.infnet.appJeffersonAndrade.service;

import br.edu.infnet.appJeffersonAndrade.domain.Car;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CarService {
    private Map<Integer, Car>  mapa = new HashMap<>();
    private  Integer id = 0;

    public void incluir(Car car) {
        car.setId(++id);
        mapa.put(car.getId(), car);
        id = car.getId();
    }

    public Collection<Car> listar() {
        return mapa.values();
    }
}
