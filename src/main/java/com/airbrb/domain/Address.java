package com.airbrb.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int id;
    private String street;
    private String city;
    private String state;
    private int postcode;

    private String country;

    @Override
    public String toString(){
        return "Address{" +
                "id=" + id+ '\'' +
                ", street=" +street+ '\'' +
                ", city=" +city+ '\'' +
                ", state=" +state+ '\'' +
                ", postcode=" +postcode+ '\'' +
                ", country=" +country+ '\''+'}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
