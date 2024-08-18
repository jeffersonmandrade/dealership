package br.edu.infnet.appJeffersonAndrade.controller.dto;

import br.edu.infnet.appJeffersonAndrade.domain.Car;

public class CarDTO  extends AutomobileDTO {
    private Integer numberOfDoors;
    private Double trunkSize;
    private boolean hasSunroof;

    public CarDTO(String brand, String fuelType, int year, String color, String model,
                  Integer numberOfDoors, Double trunkSize, boolean hasSunroof) {
        super(brand, fuelType, year, color, model);
        this.numberOfDoors = numberOfDoors;
        this.trunkSize = trunkSize;
        this.hasSunroof = hasSunroof;
    }

    public Car toDomain() {
        return new Car(
                0,
                this.getBrand(),
                this.getFuelType(),
                this.getYear(),
                this.getColor(),
                this.getModel(),
                this.numberOfDoors,
                this.trunkSize,
                this.hasSunroof
        );
    }
}


