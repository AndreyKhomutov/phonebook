package com.getjavajob.training.web06.khomutova.datebaseclasses;

import com.getjavajob.training.web06.khomutova.datebaseclasses.connectClasses.DataSourceHolder;
import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.PhoneDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Phone;
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
import java.util.Properties;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:phonebook-context-override.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class PhonetDaoTest {

    @Autowired
    private PhoneDao phoneDao;

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
        List<Phone> phones = phoneDao.getAll();
        assertEquals(6, phones.size());
    }

    @Test
    public void getById_Exist() {
        Phone phone = phoneDao.get(1);
        assertEquals("+79052772984", phone.getNumber());
    }

    @Test
    public void add() {
        Phone phone = phoneDao.get(2);
        phone.setNumber("88129898998");
        assertEquals(6, phoneDao.getAll().size());
        phoneDao.add(phone);
     //   assertEquals(7, phoneDao.getAll().size()); //todo
    }

    @Test
    public void remove() {
        assertEquals(6, phoneDao.getAll().size());
        phoneDao.delete(2);
        assertEquals(5, phoneDao.getAll().size());
    }

    @Test
    public void set() {
        Phone phone = phoneDao.get(1);
        assertEquals("+79052772984", phone.getNumber());
        phone.setNumber("+79999999999");
        phoneDao.update(phone);
        assertEquals("+79999999999", phoneDao.get(1).getNumber());
    }
}
