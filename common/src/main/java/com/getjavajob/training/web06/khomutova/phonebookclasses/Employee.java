package com.getjavajob.training.web06.khomutova.phonebookclasses;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employeeID")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "email")
    private String email;

    @Column(name = "icq")
    private String icq;

    @Column(name = "skype")
    private String skype;

    @ManyToOne
    @JoinColumn(name = "departmentID")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "boss")
    private Employee boss;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_has_phones", joinColumns = @JoinColumn(name = "employeeID"),
            inverseJoinColumns = @JoinColumn(name = "phoneID"))
    private List<Phone> phones;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_has_addresses", joinColumns = @JoinColumn(name = "employeeID"),
            inverseJoinColumns = @JoinColumn(name = "addressID"))
    private List<Address> addresses;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
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

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }
}
