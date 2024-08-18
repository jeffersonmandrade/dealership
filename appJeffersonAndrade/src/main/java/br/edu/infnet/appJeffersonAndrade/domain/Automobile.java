package br.edu.infnet.appJeffersonAndrade.domain;

public abstract class Automobile {

    private int id;
    private String brand;
    private String model;
    private String color;
    private int year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String fuelType;

    public Automobile(Integer id ,String brand, String fuelType, int year, String color, String model) {
        this.id = id;
        this.brand = brand;
        this.fuelType = fuelType;
        this.year = year;
        this.color = color;
        this.model = model;
    }
    public Automobile(){};

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
