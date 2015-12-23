package com.getjavajob.training.web06.khomutova.datebaseclasses;

import com.getjavajob.training.web06.khomutova.phonebookclasses.PhoneHasEmployee;
import com.getjavajob.training.web06.khomutova.service.dto.EmployeeDTO;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class PhoneHasEmployeeDaoTest {
    private PhoneHasEmployeeDao phoneHasEmployeeDao =new PhoneHasEmployeeDao();

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
        List<PhoneHasEmployee> dependecies = phoneHasEmployeeDao.getAll();
        assertEquals(3, dependecies.size());
    }

    @Test
    public void getById_Exist() {
        PhoneHasEmployee dependecies = phoneHasEmployeeDao.get(1);
        assertEquals(1, dependecies.getEmployeeID());
    }

   @Test
    public void add() {
       PhoneHasEmployee phoneHasEmployee= phoneHasEmployeeDao.get(1);
       phoneHasEmployee.setPhoneID(4);
       phoneHasEmployee.setEmployeeID(4);
       assertEquals(3, phoneHasEmployeeDao.getAll().size());
       phoneHasEmployeeDao.add(phoneHasEmployee);
       assertEquals(4, phoneHasEmployeeDao.getAll().size());
   }

    @Test
   public void remove() {
        assertEquals(3, phoneHasEmployeeDao.getAll().size());
        phoneHasEmployeeDao.delete(2);
        assertEquals(2, phoneHasEmployeeDao.getAll().size());
    }

   @Test
    public void set() {
       PhoneHasEmployee phoneHasEmployee= phoneHasEmployeeDao.get(1);
       assertEquals(1, phoneHasEmployee.getEmployeeID());
       phoneHasEmployee.setEmployeeID(2);
       phoneHasEmployeeDao.update(phoneHasEmployee);
       assertEquals(2, phoneHasEmployeeDao.get(1).getEmployeeID());
   }
}
