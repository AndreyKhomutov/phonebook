package com.getjavajob.training.web06.khomutova.datebaseclasses;

import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.DepartmentDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Department;
import com.getjavajob.training.web06.ui.servlets.ApplicationContextProvider;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dao-context.xml", "classpath:dao-context-override.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class DepartmentDaoTest {

    @Autowired

    private DepartmentDao departmentDao;

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
        List<Department> employees = departmentDao.getAll();
        assertEquals(3, employees.size());
    }

    @Test
    public void getById_Exist() {
        Department department = departmentDao.get(1);
        assertEquals("IT", department.getName());
    }

    @Test
    public void add() {
        Department department = new Department();
        department.setName("ITCeo");
        department.setDepartmentBoss(departmentDao.get(1).getDepartmentBoss());
        assertEquals(3, departmentDao.getAll().size());
        departmentDao.add(department);
        assertEquals(4, departmentDao.getAll().size());
    }

    @Test
    public void remove() {
        assertEquals(3, departmentDao.getAll().size());
        departmentDao.delete(2);
        assertEquals(2, departmentDao.getAll().size());
    }

    @Test
    public void set() {
        Department department = departmentDao.get(1);
        assertEquals("IT", department.getName());
        department.setName("ITCeo");
        departmentDao.update(department);
        assertEquals("ITCeo", departmentDao.get(1).getName());
    }
}
