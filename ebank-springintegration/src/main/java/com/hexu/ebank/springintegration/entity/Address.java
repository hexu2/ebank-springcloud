package com.hexu.ebank.springintegration.entity;

import java.io.Serializable;

public class Address implements Serializable {

    private String street;

    private String citiy;

    private String state;


    public Address() {
    }

    public Address(String street, String citiy, String state) {
        this.street = street;
        this.citiy = citiy;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCitiy() {
        return citiy;
    }

    public void setCitiy(String citiy) {
        this.citiy = citiy;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", citiy='" + citiy + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
