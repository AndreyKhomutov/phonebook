package com.getjavajob.training.web06.khomutova.service.dto;

import com.getjavajob.training.web06.khomutova.phonebookclasses.BaseEntity;

public class PhoneDTO extends BaseEntity{
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    private String phoneType;
}
