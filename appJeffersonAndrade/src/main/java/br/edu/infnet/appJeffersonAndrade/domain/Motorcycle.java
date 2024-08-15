package br.edu.infnet.appJeffersonAndrade.domain;


public class Motorcycle extends Automobile {

    private int id;
    private String motorcycleType;
    private int engineDisplacement;
    private String startType;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotorcycleType() {
        return motorcycleType;
    }

    public Motorcycle(String brand, String fuelType, int year, String color, String model,int engineDisplacement, String startType, String motorcycleType) {
        super(brand, fuelType, year, color, model);
        this.engineDisplacement = engineDisplacement;
        this.startType = startType;
        this.motorcycleType = motorcycleType;
    }

    public  Motorcycle(){

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
