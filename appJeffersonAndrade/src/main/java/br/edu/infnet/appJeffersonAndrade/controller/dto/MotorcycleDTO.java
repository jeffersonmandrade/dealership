package br.edu.infnet.appJeffersonAndrade.controller.dto;

import br.edu.infnet.appJeffersonAndrade.domain.Motorcycle;

public class MotorcycleDTO extends AutomobileDTO {
    private int engineDisplacement;
    private String startType;
    private String motorcycleType;

    public MotorcycleDTO(String brand, String fuelType, int year, String color, String model,
                         int engineDisplacement, String startType, String motorcycleType) {
        super(brand, fuelType, year, color, model);
        this.engineDisplacement = engineDisplacement;
        this.startType = startType;
        this.motorcycleType = motorcycleType;
    }

    public Motorcycle toDomain() {
        return new Motorcycle(
                0,
                this.getBrand(),
                this.getFuelType(),
                this.getYear(),
                this.getColor(),
                this.getModel(),
                this.engineDisplacement,
                this.startType,
                this.motorcycleType
        );
    }
}
