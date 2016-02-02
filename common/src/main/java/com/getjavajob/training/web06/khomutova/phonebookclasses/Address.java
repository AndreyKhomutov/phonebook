package com.getjavajob.training.web06.khomutova.phonebookclasses;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addressID")
    private int id;
    private String city;
    private String street;
    private int apartment;
    private int postal;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private EntityType addressType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EntityType getAddressType() {
        return addressType;
    }

    public void setAddressType(EntityType addressType) {
        this.addressType = addressType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public int getPostal() {
        return postal;
    }

    public void setPostal(int postal) {
        this.postal = postal;
    }
}
