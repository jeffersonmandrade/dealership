package br.edu.infnet.appJeffersonAndrade.controller.dto;

import br.edu.infnet.appJeffersonAndrade.domain.Dealership;
import br.edu.infnet.appJeffersonAndrade.domain.Automobile;

import java.util.List;
import java.util.stream.Collectors;

public class DealershipDTO {
    private String name;
    private String email;
    private String phone;
    private String cnpj;
    private List<AutomobileDTO> automobiles;

    public DealershipDTO(String name, String email, String phone, String cnpj,
                         List<AutomobileDTO> automobiles) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cnpj = cnpj;
        this.automobiles = automobiles;
    }

    public Dealership toDomain() {
        Dealership dealership = new Dealership();
        dealership.setName(this.name);
        dealership.setEmail(this.email);
        dealership.setPhone(this.phone);
        dealership.setCnpj(this.cnpj);

        List<Automobile> domainAutomobiles = this.automobiles.stream()
                .map(dto -> {
                    if (dto instanceof CarDTO) {
                        return ((CarDTO) dto).toDomain();
                    } else if (dto instanceof MotorcycleDTO) {
                        return ((MotorcycleDTO) dto).toDomain();
                    }
                    return null;
                })
                .collect(Collectors.toList());

        dealership.setAutomobiles(domainAutomobiles);
        return dealership;
    }

    // Getters and setters
}
