package com.getjavajob.training.web06.khomutova.service.service;

import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.*;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Address;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Phone;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService extends GenericService<Employee> {

    private AddressDao addressDao;
    private PhoneDao phoneDao;

    public EmployeeService(EmployeeDao dao, AddressDao addressDao, PhoneDao phoneDao) {
        super(dao);
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
}
