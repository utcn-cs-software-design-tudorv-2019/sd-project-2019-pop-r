package com.eventsweb.eventsweb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BillingAddress implements Serializable {
    //private static final long serialVersionUID = -2609977211443134135L;
    @Id
    @GeneratedValue
    private int billingAddressId;
    private String streetName;
    private String apartmentNumber;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    @OneToOne
    private Client client;

    public BillingAddress() {
    }

    public int getBillingAddressId() {
        return this.billingAddressId;
    }

    public void setBillingAddressId(int billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getApartmentNumber() {
        return this.apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Client getClient() {
        return this.client;
    }

    public void setCustomer(Client client) {
        this.client = client;
    }

    public String toString() {
        return "BillingAddress{streetName='" + this.streetName + '\'' + ", apartmentNumber='" + this.apartmentNumber + '\'' + ", city='" + this.city + '\'' + ", state='" + this.state + '\'' + ", country='" + this.country + '\'' + ", zipCode='" + this.zipCode + '\'' + '}';
    }
}