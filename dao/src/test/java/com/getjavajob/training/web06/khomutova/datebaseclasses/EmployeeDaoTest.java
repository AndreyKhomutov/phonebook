package com.getjavajob.training.web06.khomutova.datebaseclasses;

import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.EmployeeDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
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
public class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

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
        List<Employee> employees = employeeDao.getAll();
        assertEquals(2, employees.size());
    }

    @Test
    public void getById_Exist() {
        Employee employee = employeeDao.get(1);
        assertEquals("Andrey", employee.getName());
    }

    @Test
    public void add() {
        Employee employee1 = employeeDao.get(1);
        Employee employee = new Employee();
        employee.setName("Ivanov Ivan");
        employee.setBirthday(employee1.getBirthday());
        employee.setPhoto(employee1.getPhoto());
        employee.setDepartment(employee1.getDepartment());
        employee.setBoss(employee1.getBoss());
        employee.setEmail("fsf@mail.ru");
        employee.setIcq("65456454");
        employee.setSkype("ovan");
        employee.setAddresses(employee1.getAddresses());
        employee.setPhones(employee1.getPhones());
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
        assertEquals("Andrey", employee.getName());
        employee.setName("Petrov Boris");
        employeeDao.update(employee);
        assertEquals("Petrov Boris", employeeDao.get(1).getName());
    }
}
