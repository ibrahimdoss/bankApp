package com.App.model;

public class Customer {

    private String id;
    private String name;
    private String address;
    private City city;
    private String email;
    private String phone;
    private Integer birthdate;

    public Customer() {
    }

    public Customer(String id, String name, String address, City city, String email, String phone, Integer birthdate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.birthdate = birthdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Integer birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city=" + city +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
