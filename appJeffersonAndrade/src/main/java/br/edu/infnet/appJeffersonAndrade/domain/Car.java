package br.edu.infnet.appJeffersonAndrade.domain;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Enabled;

@Entity
public class Car extends Automobile {

    @Min(value = 1, message = "The number of doors must be at least 1.")
    private Integer numberOfDoors;
    @Min(value = 0, message = "The trunk size cannot be negative.")
    private Double trunkSize;
    @NotBlank(message = "The sunroof status must be specified.")
    private Boolean hasSunroof;

    public Car(int id, String brand, String fuelType, int year, String color, String model, Integer numberOfDoors, Double trunkSize, boolean hasSunroof) {
        super(id, brand, fuelType, year, color, model);
        this.numberOfDoors = numberOfDoors;
        this.trunkSize = trunkSize;
        this.hasSunroof = hasSunroof;
    }

    public Car() {
    }


    public Double getTrunkSize() {
        return trunkSize;
    }

    public void setTrunkSize(Double trunkSize) {
        this.trunkSize = trunkSize;
    }

    public boolean isHasSunroof() {
        return hasSunroof;
    }

    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return String.format("%s;number_Of_Doors = %s;trunk_size = %s;has_Sunroof = %s",
                super.toString(),
                numberOfDoors,
                trunkSize,
                hasSunroof);
    }


}
