package com.getjavajob.training.web06.khomutova.datebaseclasses;

import com.getjavajob.training.web06.khomutova.datebaseclasses.dto.DepartmentDTO;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

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
        List<DepartmentDTO> employees = departmentDao.getAll();
        assertEquals(3, employees.size());
    }

    @Test
    public void getById_Exist() {
        DepartmentDTO departmentDTO = departmentDao.get(1);
        assertEquals("IT", departmentDTO.getDepartmentName());
    }

    @Test
    public void add() {
        DepartmentDTO departmentDTO = departmentDao.get(2);
        departmentDTO.setDepartmentName("ITCeo");
        assertEquals(3, departmentDao.getAll().size());
        departmentDao.add(departmentDTO);
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
        DepartmentDTO departmentDTO = departmentDao.get(1);
        assertEquals("IT", departmentDTO.getDepartmentName());
        departmentDTO.setDepartmentName("ITCeo");
        departmentDao.update(departmentDTO);
        assertEquals("ITCeo", departmentDao.get(1).getDepartmentName());
    }
}
