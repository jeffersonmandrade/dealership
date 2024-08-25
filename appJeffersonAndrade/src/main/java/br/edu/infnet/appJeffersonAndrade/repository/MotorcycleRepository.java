package br.edu.infnet.appJeffersonAndrade.repository;


import br.edu.infnet.appJeffersonAndrade.domain.Car;
import br.edu.infnet.appJeffersonAndrade.domain.Dealership;
import br.edu.infnet.appJeffersonAndrade.domain.Motorcycle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, Integer> {
    List<Motorcycle> findByBrand(String brand);

    List<Motorcycle> findByDealership(Dealership dealership);

    List<Motorcycle> findByModel(String model);

    List<Motorcycle> findByBrandAndModel(String brand, String model);

    List<Motorcycle> findAll(Sort sort);
}

