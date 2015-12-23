package com.getjavajob.training.web06.khomutova.datebaseclasses;

import com.getjavajob.training.web06.khomutova.service.dto.EmployeeDTO;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class EmployeeDaoTest {
    private EmployeeDao employeeDao=new EmployeeDao();

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
                Reader reader=new FileReader(file);
                RunScript.execute(ConnectionPool.getConnection(), reader);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAll() {
        List<EmployeeDTO> employees = employeeDao.getAll();
        assertEquals(3, employees.size());
    }

    @Test
    public void getById_Exist() {
        EmployeeDTO employee = employeeDao.get(1);
        assertEquals("Khomutov Andrey", employee.getName());
    }

   @Test
    public void add() {
       EmployeeDTO employeeDTO=employeeDao.get(1);
       employeeDTO.setName("Ivanov Ivan");
       assertEquals(3, employeeDao.getAll().size());
       employeeDao.add(employeeDTO);
       assertEquals(4, employeeDao.getAll().size());
   }

    @Test
   public void remove() {
        assertEquals(3, employeeDao.getAll().size());
        employeeDao.delete(2);
        assertEquals(2, employeeDao.getAll().size());
    }

   @Test
    public void set() {
       EmployeeDTO employeeDTO=employeeDao.get(1);
       assertEquals("Khomutov Andrey", employeeDTO.getName());
       employeeDTO.setName("Petrov Boris");
       employeeDao.update(employeeDTO);
       assertEquals("Petrov Boris", employeeDao.get(1).getName());
   }
}
