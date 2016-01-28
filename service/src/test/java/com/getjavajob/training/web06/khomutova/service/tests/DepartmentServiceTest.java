package com.getjavajob.training.web06.khomutova.service.tests;

import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.DepartmentDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.EmployeeDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Department;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.getjavajob.training.web06.khomutova.service.service.DepartmentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dao-context.xml", "classpath:phonebook-context-override.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DepartmentServiceTest {
    private DepartmentDao imitatorDao = mock(DepartmentDao.class);

    @Autowired
    private DepartmentService departmentService;

    @Before
    public void init() {

        departmentService.setDao(imitatorDao);
    }

    @Test
    public void getAll() {
        List<Department> departments = makeDepartments();
        when(imitatorDao.getAll()).thenReturn(departments);
        List<Department> departmentsResult = departmentService.getAll();
        assertEquals(2, departmentsResult.size());
    }

    @Test
    public void getById() {
        Department department2 = new Department();
        department2.setName("Counting");
        department2.setId(2);
        when(imitatorDao.get(2)).thenReturn(department2);
        assertEquals("Counting", departmentService.get(2).getName());
    }

    @Test
    public void delete() {
        List<Department> departments = makeDepartments();
        List<Department> departmentsAfterDelete = makeDepartments();
        departmentsAfterDelete.remove(1);
        when(imitatorDao.getAll()).thenReturn(departments);
        List<Department> departmentsResult = departmentService.getAll();
        assertEquals(2, departmentsResult.size());
        departmentService.delete(1);
        when(imitatorDao.getAll()).thenReturn(departmentsAfterDelete);
        departmentsResult = departmentService.getAll();
        assertEquals(1, departmentsResult.size());
    }

    @Test
    public void add() {
        List<Department> departments = makeDepartments();
        when(imitatorDao.getAll()).thenReturn(departments);
        List<Department> departmentsResult = departmentService.getAll();
        assertEquals(2, departmentsResult.size());
        departmentsResult.add(departments.get(1));
        departmentsResult = departmentService.getAll();
        assertEquals(3, departmentsResult.size());
    }

    @Test
    public void getEmployees() {
        DepartmentDao departmentImitation = mock(DepartmentDao.class);
        EmployeeDao emloyeeImitation = mock(EmployeeDao.class);
        departmentService.setDao(departmentImitation);
        Department it = new Department();
        it.setId(1);
        it.setName("IT");
        Department counting = new Department();
        counting.setId(2);
        counting.setName("COUTING");
        List<Employee> employees = makeEmployees();
        when(emloyeeImitation.getAll()).thenReturn(employees);
        List<Employee> result = departmentService.getEmployees(it, emloyeeImitation);
        assertEquals(2, result.size());
        List<Employee> result2 = departmentService.getEmployees(counting, emloyeeImitation);
        assertEquals(1, result2.size());
    }

    private List<Employee> makeEmployees() {
        List<Department> departments = makeDepartments();
        Employee employee1 = new Employee();
        employee1.setName("1");
        employee1.setId(1);
        employee1.setDepartment(departments.get(0));
        Employee employee2 = new Employee();
        employee2.setName("2");
        employee2.setId(2);
        employee2.setDepartment(departments.get(1));
        Employee employee3 = new Employee();
        employee3.setName("3");
        employee3.setId(3);
        employee3.setDepartment(departments.get(0));
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        return employees;
    }

    private List<Department> makeDepartments() {
        Department IT = new Department();
        IT.setName("IT");
        IT.setId(1);
        Employee boss1 = new Employee();
        IT.setDepartmentBoss(boss1);
        Department COUNTING = new Department();
        COUNTING.setName("COUNTING");
        COUNTING.setId(2);
        Employee boss2 = new Employee();
        COUNTING.setDepartmentBoss(boss2);
        List<Department> departments = new ArrayList<>();
        departments.add(IT);
        departments.add(COUNTING);
        return departments;
    }
}
