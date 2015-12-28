package com.getjavajob.training.web06.khomutova.service.service;

import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.DepartmentDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.EmployeeDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.GenericDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Department;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService extends GenericService<Department> {
    private EmployeeDao employeeDao;

    public DepartmentService(GenericDao<Department> dao, EmployeeDao employeeDao) {
        super(dao);
        this.employeeDao = employeeDao;
    }

    public DepartmentService(GenericDao<Department> dao) {
        super(dao);
    }

    public List<Employee> getEmployees(Department department) {
        EmployeeService employeeService = new EmployeeService(employeeDao);
        List<Employee> allEmployees = employeeService.getAll();
        List<Employee> result = new ArrayList<>();
        for (Employee employee : allEmployees) {
            if (employee.getDepartment().getId() == department.getId()) {
                result.add(employee);
            }
        }
        return result;
    }
}
