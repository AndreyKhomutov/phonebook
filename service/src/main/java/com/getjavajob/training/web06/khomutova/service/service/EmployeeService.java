package com.getjavajob.training.web06.khomutova.service.service;

import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.GenericDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService extends GenericService<Employee> {

    public EmployeeService(GenericDao<Employee> dao) {
        super(dao);
    }

    public List<Employee> getSubordinates(Employee employeeBoss) {
        List<Employee> result = new ArrayList<>();
        List<Employee> allEmployees = dao.getAll();
        for (Employee employee : allEmployees) {
            if (employee.getBoss().getId() == employeeBoss.getId()) {
                result.add(employee);
            }
        }
        return result;
    }
}
