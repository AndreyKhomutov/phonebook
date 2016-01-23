package com.getjavajob.training.web06.khomutova.datebaseclasses;

import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.AddressDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Address;
import com.getjavajob.training.web06.khomutova.servlets.ApplicationContextProvider;
import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:phonebook-context-override.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class AddressDaoTest {

    @Autowired
    private AddressDao addressDao;

    @Before
    public void importDataSet() {
        BasicDataSource dataSource = ApplicationContextProvider.getApplicationContext().getBean("dataSource", BasicDataSource.class);
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
     //   assertEquals(4, addressDao.getAll().size()); //todo
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
