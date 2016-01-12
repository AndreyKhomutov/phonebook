package com.getjavajob.training.web06.khomutova.service.service;

import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.DepartmentDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.EmployeeDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Department;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService extends GenericService<Department> {
    public DepartmentService() {
        setDao(new DepartmentDao());
    }

    public List<Employee> getEmployees(Department department, EmployeeDao employeeDao) {
        EmployeeService employeeService = new EmployeeService();
        employeeService.setDao(employeeDao);
        List<Employee> allEmployees = employeeService.getAll();
        List<Employee> result = new ArrayList<>();
        for (Employee employee : allEmployees) {
            if (employee.getDepartment().getId() == department.getId()) {
                result.add(employee);
            }
        }
        return result;
    }

    public ArrayList<Department> searchDepartment(String parameter) {
        if (dao == null) {
            setDao(new DepartmentDao());
        }
        List<Department> departments = getAll();
        ArrayList<Department> result = new ArrayList<>();
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getName().toLowerCase().toLowerCase().contains(parameter)){
                result.add(departments.get(i));
            }
        }
        return result;
    }
}
