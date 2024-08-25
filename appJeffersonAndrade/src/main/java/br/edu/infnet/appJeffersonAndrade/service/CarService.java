package br.edu.infnet.appJeffersonAndrade.service;

import br.edu.infnet.appJeffersonAndrade.domain.Car;

import br.edu.infnet.appJeffersonAndrade.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public void create(Car car) {

        carRepository.save(car);
        System.out.println(car);
    }

    public Collection<Car> getAll() {
        return carRepository.findAll();
    }
    public Car geById(Integer id) {
        return carRepository.findById(id).get();
    }

    public void deleteById(Integer id) {
        carRepository.deleteById(id);
    }
}
