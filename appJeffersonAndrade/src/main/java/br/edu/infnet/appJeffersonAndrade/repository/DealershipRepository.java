package br.edu.infnet.appJeffersonAndrade.repository;


import br.edu.infnet.appJeffersonAndrade.domain.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealershipRepository extends JpaRepository<Dealership, Integer> {
    List<Dealership> findAllByOrderByIdAsc();

    List<Dealership> findByName(String name);

}

