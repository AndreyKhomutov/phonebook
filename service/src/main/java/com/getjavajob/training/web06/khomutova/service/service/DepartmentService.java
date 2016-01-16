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

@Service ("DepartmentService")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DepartmentService extends GenericService<Department> {

    private EmployeeDao employeeDao;
    private AddressDao addressDao;
    private PhoneDao phoneDao;

   @Autowired
    public DepartmentService(DepartmentDao dao, EmployeeDao employeeDao, AddressDao addressDao, PhoneDao phoneDao) {
        super(dao);
        this.employeeDao = employeeDao;
        this.addressDao = addressDao;
        this.phoneDao = phoneDao;
    }


    public List<Employee> getEmployees(Department department, EmployeeDao employeeDao) {//todo employeeDAO
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

    public ArrayList<Department> searchDepartment(String parameter) {
        List<Department> departments = getAll();
        System.out.println(departments.size());
        ArrayList<Department> result = new ArrayList<>();
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getName().toLowerCase().toLowerCase().contains(parameter)){
                result.add(departments.get(i));
            }
        }
        return result;
    }
}
