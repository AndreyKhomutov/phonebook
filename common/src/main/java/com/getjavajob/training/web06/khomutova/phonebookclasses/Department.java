package com.getjavajob.training.web06.khomutova.phonebookclasses;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "departmentID")
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column (name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "employeeID")
    private Employee departmentBoss;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getDepartmentBoss() {
        return departmentBoss;
    }

    public void setDepartmentBoss(Employee departmentBoss) {
        this.departmentBoss = departmentBoss;
    }
}
