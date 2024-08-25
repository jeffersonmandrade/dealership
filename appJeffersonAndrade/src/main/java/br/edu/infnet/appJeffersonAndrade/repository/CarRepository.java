package br.edu.infnet.appJeffersonAndrade.repository;


import br.edu.infnet.appJeffersonAndrade.domain.Car;
import br.edu.infnet.appJeffersonAndrade.domain.Dealership;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByBrand(String brand);

    List<Car> findByDealership(Dealership dealership);

    List<Car> findByModel(String model);

    List<Car> findByBrandAndModel(String brand, String model);

    List<Car> findAll(Sort sort);

}

