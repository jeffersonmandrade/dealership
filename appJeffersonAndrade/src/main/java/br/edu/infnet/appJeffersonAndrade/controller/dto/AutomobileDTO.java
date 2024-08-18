package br.edu.infnet.appJeffersonAndrade.controller.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CarDTO.class, name = "car"),
        @JsonSubTypes.Type(value = MotorcycleDTO.class, name = "motorcycle")
})
public abstract class AutomobileDTO {
    private String brand;
    private String fuelType;
    private int year;
    private String color;
    private String model;

    protected AutomobileDTO() {
    }

    public AutomobileDTO(String brand, String fuelType, int year, String color, String model) {
        this.brand = brand;
        this.fuelType = fuelType;
        this.year = year;
        this.color = color;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}