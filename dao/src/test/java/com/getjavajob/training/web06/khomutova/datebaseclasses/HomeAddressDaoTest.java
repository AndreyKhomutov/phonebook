package com.getjavajob.training.web06.khomutova.datebaseclasses;

import com.getjavajob.training.web06.khomutova.phonebookclasses.HomeAddress;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class HomeAddressDaoTest {

    private HomeAddressDao homeAddressDao = new HomeAddressDao();

    @Before
    public void importDataSet() {
        Properties props = new Properties();
        try {
            props.load(this.getClass().getClassLoader()
                    .getResourceAsStream("phonebook.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClassLoader loader = HomeAddressDaoTest.class.getClassLoader();
        File file = new File(loader.getResource("createDataBase").getFile());
        try {
            try {
                Reader reader = new FileReader(file);
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
        List<HomeAddress> employees = homeAddressDao.getAll();
        assertEquals(3, employees.size());
    }

    @Test
    public void getById_Exist() {
        HomeAddress homeAddress = homeAddressDao.get(1);
        assertEquals("SPB", homeAddress.getCity());
    }

    @Test
    public void add() {
        HomeAddress homeAddress = homeAddressDao.get(2);
        homeAddress.setCity("Moscow");
        assertEquals(3, homeAddressDao.getAll().size());
        homeAddressDao.add(homeAddress);
        assertEquals(4, homeAddressDao.getAll().size());
    }

    @Test
    public void remove() {
        assertEquals(3, homeAddressDao.getAll().size());
        homeAddressDao.delete(2);
        assertEquals(2, homeAddressDao.getAll().size());
    }

    @Test
    public void set() {
        HomeAddress homeAddress = homeAddressDao.get(1);
        assertEquals("SPB", homeAddress.getCity());
        homeAddress.setCity("Moscow");
        homeAddressDao.update(homeAddress);
        assertEquals("Moscow", homeAddressDao.get(1).getCity());
    }
}
