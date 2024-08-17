package br.edu.infnet.appJeffersonAndrade.service;

import br.edu.infnet.appJeffersonAndrade.domain.Car;

import br.edu.infnet.appJeffersonAndrade.domain.Motorcycle;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CarService {
    private Map<Integer, Car>  mapa = new HashMap<>();
    private  Integer id = 0;

    public void create(Car car) {
        car.setId(++id);
        mapa.put(car.getId(), car);
        id = car.getId();
    }

    public Collection<Car> getAll() {
        return mapa.values();
    }
    public Car geById(Integer id) {
        return mapa.get(id);
    }

    public void deleteById(Integer id) {
        mapa.remove(id);
    }
}
