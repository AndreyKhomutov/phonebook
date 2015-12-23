package com.getjavajob.training.web06.khomutova.phonebookclasses;

import java.util.Date;
import java.util.List;

public class Employee extends BaseEntity {

    private String name;
    private Date birthday;
    private List<Phone> phones;
    private HomeAddress homeHomeAddress;
    private JobAddress jobAddress;
    private String email;
    private String icq;
    private String skype;
    private Department department;
    private Employee employeeBoss;

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

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public HomeAddress getHomeHomeAddress() {
        return homeHomeAddress;
    }

    public void setHomeHomeAddress(HomeAddress homeHomeAddress) {
        this.homeHomeAddress = homeHomeAddress;
    }

    public JobAddress getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(JobAddress jobAddress) {
        this.jobAddress = jobAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployeeBoss() {
        return employeeBoss;
    }

    public void setEmployeeBoss(Employee employeeBoss) {
        this.employeeBoss = employeeBoss;
    }
}
