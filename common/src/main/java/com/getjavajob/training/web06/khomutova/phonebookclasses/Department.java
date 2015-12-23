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

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (!(obj instanceof HomeAddress)) return false;
        Department department =(Department) obj;
        return getId()== department.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
