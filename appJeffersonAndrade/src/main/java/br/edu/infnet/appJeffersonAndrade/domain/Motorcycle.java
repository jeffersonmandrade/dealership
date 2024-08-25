package br.edu.infnet.appJeffersonAndrade.domain;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Motorcycle extends Automobile {


    @NotBlank(message = "The motorcycle type cannot be blank.")
    private String motorcycleType;
    @Min(value = 50, message = "The engine displacement must be at least 50 cc.")
    private int engineDisplacement;
    @NotBlank(message = "The start type cannot be blank.")
    private String startType;

    public String getMotorcycleType() {
        return motorcycleType;
    }

    public Motorcycle(int id, String brand, String fuelType, int year, String color, String model, int engineDisplacement, String startType, String motorcycleType) {
        super(id, brand, fuelType, year, color, model);
        this.engineDisplacement = engineDisplacement;
        this.startType = startType;
        this.motorcycleType = motorcycleType;
    }

    public Motorcycle() {

    }

    public void setMotorcycleType(String motorcycleType) {
        this.motorcycleType = motorcycleType;
    }

    public int getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(int engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public String getStartType() {
        return startType;
    }

    public void setStartType(String startType) {
        this.startType = startType;
    }

    @Override
    public String toString() {
        return String.format("%s;motorcycleType = %s; engine_displacement = %d;start_type =%s",
                super.toString(),
                motorcycleType,
                engineDisplacement,
                startType);
    }
}
