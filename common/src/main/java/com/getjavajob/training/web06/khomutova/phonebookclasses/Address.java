package com.getjavajob.training.web06.khomutova.phonebookclasses;

public class Address extends BaseEntity {
    private String city;
    private String street;
    private int apartment;
    private int postal;
    private EntityType addressType;

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
