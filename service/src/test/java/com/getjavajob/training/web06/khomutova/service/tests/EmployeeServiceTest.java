package com.getjavajob.training.web06.khomutova.service.tests;

import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.EmployeeDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.getjavajob.training.web06.khomutova.service.service.EmployeeService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {
    private EmployeeDao imitatorDao = mock(EmployeeDao.class);
    private EmployeeService employeeService = new EmployeeService(imitatorDao);


    @Test
    public void getAll() {
        List<Employee> employees = makeEmployees();
        when(imitatorDao.getAll()).thenReturn(employees);
        List<Employee> employeesResult = employeeService.getAll();
        assertEquals(3, employeesResult.size());
    }

    @Test
    public void getById() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Employee1");
        when(imitatorDao.get(1)).thenReturn(employee);
        assertEquals("Employee1", employeeService.get(1).getName());
    }

    @Test
    public void delete() {
        List<Employee> employees = makeEmployees();
        when(imitatorDao.getAll()).thenReturn(employees);
        List<Employee> allEmployee = employeeService.getAll();
        assertEquals(3, allEmployee.size());
        employeeService.delete(1);
        employees.remove(1);
        allEmployee = employeeService.getAll();
        assertEquals(2, allEmployee.size());
    }

    @Test
    public void add() {
        List<Employee> employees = makeEmployees();
        when(imitatorDao.getAll()).thenReturn(employees);
        List<Employee> allEmployee = employeeService.getAll();
        assertEquals(3, allEmployee.size());
        employeeService.add(employees.get(1));
        employees.add(employees.get(1));
        allEmployee = employeeService.getAll();
        assertEquals(4, allEmployee.size());
    }

    @Test
    public void getSubordinates() {
        List<Employee> employees = makeEmployees();
        when(imitatorDao.getAll()).thenReturn(employees);
        Employee boss = employeeService.getAll().get(0);
        List<Employee> result = employeeService.getSubordinates(boss);
        assertEquals(2, result.size());
    }

    private List<Employee> makeEmployees() {
        Employee firstBoss = new Employee();
        Employee employee1 = new Employee();
        employee1.setName("1");
        employee1.setId(1);
        employee1.setBoss(firstBoss);
        Employee employee2 = new Employee();
        employee2.setName("2");
        employee2.setId(2);
        employee2.setBoss(employee1);
        Employee employee3 = new Employee();
        employee3.setName("3");
        employee3.setId(3);
        employee3.setBoss(employee1);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        return employees;
    }
}
