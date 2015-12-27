package com.getjavajob.training.web06.khomutova.datebaseclasses;

import com.getjavajob.training.web06.khomutova.datebaseclasses.connectClasses.ConnectionPool;
import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.DepartmentDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Department;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

//import com.getjavajob.training.web06.khomutova.datebaseclasses.dto.DepartmentDTO;

public class DepartmentDaoTest {

    private DepartmentDao departmentDao = new DepartmentDao();

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
        Department department = departmentDao.get(2);
        department.setName("ITCeo");
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
