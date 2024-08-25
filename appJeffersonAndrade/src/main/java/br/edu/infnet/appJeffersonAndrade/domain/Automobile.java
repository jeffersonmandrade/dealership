package br.edu.infnet.appJeffersonAndrade.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Automobile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "automobile_seq")
    @SequenceGenerator(name = "automobile_seq", sequenceName = "automobile_seq", allocationSize = 1)
    private int id;
    @NotBlank(message = "Brand is mandatory")
    private String brand;
    @NotBlank(message = "Model is mandatory")
    private String model;
    @NotBlank(message = "Color is mandatory")
    private String color;
    @Min(value = 1886, message = "Year should not be less than 1886")
    @Column(name = "manufacture_year")
    private int year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String fuelType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dealership_id")
    private Dealership dealership;


    public Automobile(Integer id, String brand, String fuelType, int year, String color, String model) {
        this.id = id;
        this.brand = brand;
        this.fuelType = fuelType;
        this.year = year;
        this.color = color;
        this.model = model;
    }

    public Automobile() {
    }

    ;

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
