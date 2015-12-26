package com.getjavajob.training.web06.khomutova.phonebookclasses;

public class Department extends BaseEntity {
    private String name;
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
