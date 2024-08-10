package br.edu.infnet.appJeffersonAndrade.domain;


public class Motorcycle extends Automobile {


    private String motorcycleType;
    private int engineDisplacement;
    private String startType;

    public String getMotorcycleType() {
        return motorcycleType;
    }

    public Motorcycle(int engineDisplacement, String startType, String motorcycleType) {
        this.engineDisplacement = engineDisplacement;
        this.startType = startType;
        this.motorcycleType = motorcycleType;
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
