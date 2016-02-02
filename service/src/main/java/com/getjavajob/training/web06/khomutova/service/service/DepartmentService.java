package com.getjavajob.training.web06.khomutova.service.service;

import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.*;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Department;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("DepartmentService")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DepartmentService implements CrudDao<Department> {

    private DepartmentDao dao;
    private AddressDao addressDao;
    private PhoneDao phoneDao;
    private EmployeeDao employeeDao;

    @Autowired
    public DepartmentService(DepartmentDao departmentDao, EmployeeDao employeeDao, AddressDao addressDao, PhoneDao phoneDao) {
        this.dao = departmentDao;
        this.employeeDao = employeeDao;
        this.addressDao = addressDao;
        this.phoneDao = phoneDao;
    }

    public DepartmentDao getDao() {
        return dao;
    }

    public void setDao(DepartmentDao dao) {
        this.dao = dao;
    }

    public List<Employee> getEmployees(Department department) {
        EmployeeService employeeService = new EmployeeService(employeeDao, addressDao, phoneDao);
        List<Employee> allEmployees = employeeService.getAll();
        List<Employee> result = new ArrayList<>();
        for (Employee employee : allEmployees) {
            if (employee.getDepartment().getId() == department.getId()) {
                result.add(employee);
            }
        }
        return result;
    }

    @Transactional
    @Override
    public void add(Department entity) {
        dao.add(entity);
    }

    @Transactional
    @Override
    public void update(Department entity) {
        dao.update(entity);
    }

    @Transactional
    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public Department get(int id) {
        return dao.get(id);
    }

    @Override
    public List<Department> getAll() {
        return dao.getAll();
    }
}
