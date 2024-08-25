package br.edu.infnet.appJeffersonAndrade.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "dealership")
public class Dealership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "The name cannot be blank.")
    @Size(max = 100, message = "The name cannot exceed 100 characters.")
    private String name;

    @NotBlank(message = "The email cannot be blank.")
    @Email(message = "The email should be valid.")
    private String email;

    @NotBlank(message = "The phone number cannot be blank.")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "The phone number should be valid and contain 10 to 15 digits.")
    private String phone;

    @NotBlank(message = "The CNPJ cannot be blank.")
    @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", message = "The CNPJ must be in the format XX.XXX.XXX/XXXX-XX.")
    private String cnpj;

    @OneToMany(mappedBy = "dealership", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Automobile> automobiles;

    public Dealership() {
        this.automobiles = new ArrayList<Automobile>();
    }

    public Dealership(List<Automobile> automobiles, String phone, String name, String cnpj, String email) {
        this.automobiles = automobiles;
        this.phone = phone;
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Automobile> getAutomobiles() {
        return automobiles;
    }

    public void setAutomobiles(List<Automobile> automobiles) {
        this.automobiles = automobiles;
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", CNPJ='" + cnpj + '\'' +
                ", automobiles=" + automobiles +
                '}';
    }
}