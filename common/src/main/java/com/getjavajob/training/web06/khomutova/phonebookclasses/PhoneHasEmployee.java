package com.getjavajob.training.web06.khomutova.phonebookclasses;

public class PhoneHasEmployee extends BaseEntity{
private int phoneID;
private int employeeID;

    public int getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(int phoneID) {
        this.phoneID = phoneID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
