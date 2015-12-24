package com.getjavajob.training.web06.khomutova.phonebookclasses;

public class Department extends BaseEntity {
    private String name;
    private int departmentBoss;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentBoss() {
        return departmentBoss;
    }

    public void setDepartmentBoss(int departmentBoss) {
        this.departmentBoss = departmentBoss;
    }
}
