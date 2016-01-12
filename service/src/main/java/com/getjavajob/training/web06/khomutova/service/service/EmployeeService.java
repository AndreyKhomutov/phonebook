package com.getjavajob.training.web06.khomutova.service.service;

import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.AddressDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.EmployeeDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.PhoneDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Address;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Phone;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService extends GenericService<Employee> {
    public EmployeeService() {
        setDao(new EmployeeDao());
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
        AddressDao addressDao = new AddressDao();
        return addressDao.getAll();
    }

    public List<Phone> getAllPhones() {
        PhoneDao phoneDao = new PhoneDao();
        return phoneDao.getAll();
    }

    public ArrayList<Employee> searchEmployee(String parameter) {
        if (dao == null) {
            setDao(new EmployeeDao());
        }
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
