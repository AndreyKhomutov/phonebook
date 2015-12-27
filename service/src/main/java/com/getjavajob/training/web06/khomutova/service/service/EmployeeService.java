package com.getjavajob.training.web06.khomutova.service.service;

import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.EmployeeDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;

public class EmployeeService {
    public void addEmployee(Employee employee) {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.add(employee);
    }
}
