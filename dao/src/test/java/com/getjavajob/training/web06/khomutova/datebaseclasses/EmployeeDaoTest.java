package com.getjavajob.training.web06.khomutova.datebaseclasses;

import com.getjavajob.training.web06.khomutova.datebaseclasses.connectClasses.ConnectionPool;
import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.EmployeeDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class EmployeeDaoTest {
    private EmployeeDao employeeDao = new EmployeeDao();

    @Before
    public void importDataSet() {
        Properties props = new Properties();
        try {
            props.load(this.getClass().getClassLoader()
                    .getResourceAsStream("phonebook.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClassLoader loader = DepartmentDaoTest.class.getClassLoader();
        File file = new File(loader.getResource("createDataBase").getFile());
        try {
            try {
                Reader reader = new FileReader(file);
                RunScript.execute(ConnectionPool.POOL.getConnection(), reader);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAll() {
        List<Employee> employees = employeeDao.getAll();
        assertEquals(2, employees.size());
    }

    @Test
    public void getById_Exist() {
        Employee employee = employeeDao.get(1);
        assertEquals("Khomutov Andrey", employee.getName());
    }

    @Test
    public void add() {
        Employee employee = employeeDao.get(1);
        employee.setName("Ivanov Ivan");
        assertEquals(2, employeeDao.getAll().size());
        employeeDao.add(employee);
        assertEquals(3, employeeDao.getAll().size());
    }

    @Test
    public void remove() {
        assertEquals(2, employeeDao.getAll().size());
        employeeDao.delete(2);
        assertEquals(1, employeeDao.getAll().size());
    }

    @Test
    public void set() {
        Employee employee = employeeDao.get(1);
        assertEquals("Khomutov Andrey", employee.getName());
        employee.setName("Petrov Boris");
        employeeDao.update(employee);
        assertEquals("Petrov Boris", employeeDao.get(1).getName());
    }
}
