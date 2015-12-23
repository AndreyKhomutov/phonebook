package com.getjavajob.training.web06.khomutova.phonebookclasses;

public class Phone extends BaseEntity {
    private String number;
    private PhoneType phoneType;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }
}
