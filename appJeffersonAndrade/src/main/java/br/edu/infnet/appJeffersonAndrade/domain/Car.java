package br.edu.infnet.appJeffersonAndrade.domain;

public class Car  extends Automobile {

    private  Integer numberOfDoors;
    private  Double  trunkSize;
    private boolean hasSunroof;

    public Car(String brand, String fuelType, int year, String color, String model,Integer numberOfDoors, Double trunkSize, boolean hasSunroof) {
        super(brand, fuelType, year, color, model);
        this.numberOfDoors = numberOfDoors;
        this.trunkSize = trunkSize;
        this.hasSunroof = hasSunroof;
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
