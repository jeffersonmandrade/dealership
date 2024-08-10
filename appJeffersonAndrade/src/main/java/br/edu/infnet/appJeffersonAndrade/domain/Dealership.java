package br.edu.infnet.appJeffersonAndrade.domain;

import java.util.List;

public class Dealership {

    private String name;
    private String email;
    private String phone;
    private String cnpj;
    private List<Automobile> automobiles;

    public Dealership(String name, String email, String phone, String cnpj) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cnpj = cnpj;
        this.automobiles =  List.of();
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