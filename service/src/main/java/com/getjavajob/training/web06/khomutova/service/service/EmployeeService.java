package com.getjavajob.training.web06.khomutova.service.service;

import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.*;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Address;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Department;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("EmployeeService")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class EmployeeService implements CrudDao<Employee>  {

    private EmployeeDao dao;
    private AddressDao addressDao;
    private PhoneDao phoneDao;

    @Autowired
    public EmployeeService(EmployeeDao dao, AddressDao addressDao, PhoneDao phoneDao) {
        this.dao=dao;
        this.addressDao = addressDao;
        this.phoneDao = phoneDao;
    }

    public List<Employee> getSubordinates(Employee employeeBoss) {
        List<Employee> result = new ArrayList<>();
        List<Employee> allEmployees = dao.getAll();
        for (Employee employee : allEmployees) {
            if (employee.getBoss().getId() == employeeBoss.getId()) {
                result.add(employee);
            }
        }
        return result;
    }

        public List<Address> getAllAddresses() {
        return addressDao.getAll();
    }

    @Transactional
    public List<Phone> getAllPhones() {
        return phoneDao.getAll();
    }

    public ArrayList<Employee> searchEmployee(String parameter) {
        List<Employee> employees = getAll();
        ArrayList<Employee> result = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().toLowerCase().toLowerCase().contains(parameter) ||
                    employees.get(i).getDepartment().getName().toLowerCase().toLowerCase().contains(parameter) ||
                    employees.get(i).getIcq().toLowerCase().toLowerCase().contains(parameter)
                    || employees.get(i).getEmail().toLowerCase().toLowerCase().contains(parameter)
                    || employees.get(i).getSkype().toLowerCase().toLowerCase().contains(parameter))
                result.add(employees.get(i));
        }
        return result;
    }

    @Transactional
    @Override
    public void add(Employee entity) {
        dao.add(entity);
    }

    @Transactional
    @Override
    public void update(Employee entity) {
       dao.update(entity);
    }

    @Transactional
    @Override
    public void delete(int id) {
       dao.delete(id);
    }

    public EmployeeDao getDao() {
        return dao;
    }

    public void setDao(EmployeeDao dao) {
        this.dao = dao;
    }

    @Override
    public Employee get(int id) {
        return dao.get(id);
    }

    @Override
    public List<Employee> getAll() {
        return dao.getAll();
    }

    @Transactional
    public void addPhones(List<Phone> phones){
        for (Phone phone: phones){
            phoneDao.add(phone);
        }
    }
}
