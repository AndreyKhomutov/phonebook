package com.getjavajob.training.web06.khomutova.service.tests;

import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.getjavajob.training.web06.khomutova.service.service.EmployeeService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmployeeServiceTest {

    @Test
    public void getAllEmployees() {
        EmployeeService employeeService = new EmployeeService();
        List<Employee> employees = employeeService.getAllEmployees();
        assertEquals(3, employees.size());
    }

    @Test
    public void addEmployee() {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = employeeService.getEmployee(1);
        List<Employee> employees = employeeService.getAllEmployees();
        assertEquals(3, employees.size());
        employeeService.addEmployee(employee);
        employees = employeeService.getAllEmployees();
        assertEquals(4, employees.size());
        employeeService.removeEmployee(3);
        employees = employeeService.getAllEmployees();
        assertEquals(2, employees.size());
    }
}
