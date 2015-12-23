package com.getjavajob.training.web06.khomutova.service.dto;

import com.getjavajob.training.web06.khomutova.phonebookclasses.BaseEntity;

import java.util.Date;

public class EmployeeDTO extends BaseEntity {
    private String name;
    private Date birthday;
    private String homePhone;
    private String icq;
    private String skype;
    private String jobPhone;
    private String jobAddress;
    private String email;
    private int bossID;
    private int department_departmentID;
    private int homeAddress_idHomeAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getIcq() {
        return icq;
    }

    public void setIcq(String icq) {
        this.icq = icq;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getJobPhone() {
        return jobPhone;
    }

    public void setJobPhone(String jobPhone) {
        this.jobPhone = jobPhone;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBossID() {
        return bossID;
    }

    public void setBossID(int bossID) {
        this.bossID = bossID;
    }

    public int getDepartment_departmentID() {
        return department_departmentID;
    }

    public void setDepartment_departmentID(int department_departmentID) {
        this.department_departmentID = department_departmentID;
    }

    public int getHomeAddress_idHomeAddress() {
        return homeAddress_idHomeAddress;
    }

    public void setHomeAddress_idHomeAddress(int homeAddress_idHomeAddress) {
        this.homeAddress_idHomeAddress = homeAddress_idHomeAddress;
    }
}

