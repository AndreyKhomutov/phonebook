package com.getjavajob.training.web06.khomutova.service.dto;

import com.getjavajob.training.web06.khomutova.phonebookclasses.BaseEntity;

public class DepartmentDTO extends BaseEntity{
    private String departmentName;
    private int employeeBoss_emloyeeID;

    public int getEmployeeBoss_emloyeeID() {
        return employeeBoss_emloyeeID;
    }

    public void setEmployeeBoss_emloyeeID(int employeeBoss_emloyeeID) {
        this.employeeBoss_emloyeeID = employeeBoss_emloyeeID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

}
