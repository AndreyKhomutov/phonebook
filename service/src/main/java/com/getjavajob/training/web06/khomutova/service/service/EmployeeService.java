package com.getjavajob.training.web06.khomutova.service.service;

import com.getjavajob.training.web06.khomutova.datebaseclasses.EmployeeDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.dto.EmployeeDTO;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.getjavajob.training.web06.khomutova.service.converters.EmployeeConverter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        List<Employee> employees=employeeService.getAllEmployees();
        System.out.println(employees.size());
    }

    private EmployeeConverter employeeConverter = new EmployeeConverter();
    private EmployeeDao employeeDao = new EmployeeDao();


    public void addEmployee(Employee employee) {
        EmployeeDTO employeeDTO = employeeConverter.fromEmployeeToDTO(employee);
        employeeDao.add(employeeDTO);
    }

    public List<Employee> getAllEmployees() {
        EmployeeDao employeeDao = new EmployeeDao();
        EmployeeConverter converter = new EmployeeConverter();
        ArrayList<Employee> employees = new ArrayList<>();
        List<EmployeeDTO> employeesDTO = employeeDao.getAll();
        for (EmployeeDTO employeeDTO : employeesDTO) {
            Employee employee = converter.fromDTOToEmployee(employeeDTO);
            employees.add(employee);
        }
        return employees;
    }

    public Employee getEmployee(int employeeID) {
        EmployeeDTO employeeDTO = employeeDao.get(employeeID);
        Employee employee = employeeConverter.fromDTOToEmployee(employeeDTO);
        return employee;
    }

    public void setEmployee(Employee employee) {
        EmployeeDTO employeeDTO = employeeConverter.fromEmployeeToDTO(employee);
        employeeDao.update(employeeDTO);
    }

    public void removeEmployee(int employeeID) {
        employeeDao.delete(employeeID);
    }

    public List<Employee> getSubordinates(int employeeID) {
        return null;
    }
}
