package com.getjavajob.training.web06.khomutova.datebaseclasses;

import com.getjavajob.training.web06.khomutova.datebaseclasses.connectClasses.DataSourceHolder;
import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.AddressDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Address;
import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class AddressDaoTest {

    private AddressDao addressDao = new AddressDao();

    @Before
    public void importDataSet() {
        Properties props = new Properties();
        try {
            props.load(this.getClass().getClassLoader()
                    .getResourceAsStream("phonebook.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(props.getProperty("driver"));
        dataSource.setUrl(props.getProperty("url"));
        dataSource.setUsername(props.getProperty("user"));
        dataSource.setPassword(props.getProperty("password"));
        DataSourceHolder.setDataSource(dataSource);
        ClassLoader loader = DepartmentDaoTest.class.getClassLoader();
        File file = new File(loader.getResource("createDataBase").getFile());
        try {
            try {
                Reader reader = new FileReader(file);
                RunScript.execute(dataSource.getConnection(), reader);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAll() {
        List<Address> employees = addressDao.getAll();
        assertEquals(3, employees.size());
    }

    @Test
    public void getById_Exist() {
        Address address = addressDao.get(1);
        assertEquals("SPB", address.getCity());
    }

    @Test
    public void add() {
        Address address = addressDao.get(2);
        address.setCity("Moscow");
        assertEquals(3, addressDao.getAll().size());
        addressDao.add(address);
        assertEquals(4, addressDao.getAll().size());
    }

    @Test
    public void remove() {
        assertEquals(3, addressDao.getAll().size());
        addressDao.delete(2);
        assertEquals(2, addressDao.getAll().size());
    }

    @Test
    public void set() {
        Address address = addressDao.get(1);
        assertEquals("SPB", address.getCity());
        address.setCity("Moscow");
        addressDao.update(address);
        assertEquals("Moscow", addressDao.get(1).getCity());
    }
}
