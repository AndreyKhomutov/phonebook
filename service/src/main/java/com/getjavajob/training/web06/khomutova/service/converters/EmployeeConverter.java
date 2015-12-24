package com.getjavajob.training.web06.khomutova.service.converters;

import com.getjavajob.training.web06.khomutova.datebaseclasses.DepartmentDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.EmployeeDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.HomeAddressDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.dto.DepartmentDTO;
import com.getjavajob.training.web06.khomutova.datebaseclasses.dto.EmployeeDTO;
import com.getjavajob.training.web06.khomutova.phonebookclasses.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeConverter {
    public Employee fromDTOToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setBirthday(employeeDTO.getBirthday());
        HomeAddressDao homeAddressDao = new HomeAddressDao();
        HomeAddress homeAddress = homeAddressDao.get(employeeDTO.getHomeAddress_idHomeAddress());
        employee.setHomeHomeAddress(homeAddress);
        String[] homePhones = employeeDTO.getHomePhone().split(" ");
        ArrayList<Phone> phonesEmployee = new ArrayList<>();
        for (String phones : homePhones) {
            Phone phone = new Phone();
            phone.setNumber(phones);
            phone.setPhoneType(PhoneType.home);
            phonesEmployee.add(phone);
        }
        String[] jobPhones = employeeDTO.getJobPhone().split(" ");
        for (String phones : jobPhones) {
            Phone phone = new Phone();
            phone.setNumber(phones);
            phone.setPhoneType(PhoneType.job);
            phonesEmployee.add(phone);
        }
        if (employeeDTO.getJobAddress().equals("MainOffice")) {
            employee.setJobAddress(JobAddress.MainOffice);
        } else {
            employee.setJobAddress(JobAddress.BranchInNY);
        }
        employee.setEmail(employeeDTO.getEmail());
        employee.setIcq(employeeDTO.getIcq());
        employee.setSkype(employeeDTO.getSkype());
        DepartmentDao departmentDao = new DepartmentDao();
        DepartmentDTO departmentDTO = departmentDao.get(employeeDTO.getDepartment_departmentID());
        DepartmentConverter departmentConverter = new DepartmentConverter();
        Department department = departmentConverter.fromDTOToDepartment(departmentDTO);
        employee.setDepartment(department);
//        EmployeeDao employeeDao = new EmployeeDao();
//        EmployeeDTO boss = employeeDao.get(employeeDTO.getBossID());
//        EmployeeConverter employeeConverter = new EmployeeConverter();
//        Employee employeeBoss = employeeConverter.fromDTOToEmployee(boss);
//        employee.setEmployeeBoss(employeeBoss);
        employee.setEmployeeBoss(null);
        return employee;
    }

    public EmployeeDTO fromEmployeeToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(employee.getName());
        employeeDTO.setHomeAddress_idHomeAddress(employee.getHomeAddress().getId());
        employeeDTO.setId(employee.getId());
        employeeDTO.setDepartment_departmentID(employee.getDepartment().getId());
        employeeDTO.setIcq(employee.getIcq());
        employeeDTO.setSkype(employee.getSkype());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setJobAddress(employee.getJobAddress().name());
        employeeDTO.setBossID(employee.getEmployeeBoss().getId());
        List<Phone> phones = employee.getPhones();
        StringBuilder homePhones = new StringBuilder();
        StringBuilder jobPhones = new StringBuilder();
        for (Phone phone : phones) {
            if (phone.getPhoneType().equals("home")) {
                homePhones.append(phone.getNumber() + " ");
            } else jobPhones.append(phone.getNumber() + " ");
        }
        employeeDTO.setHomePhone(homePhones.toString());
        employeeDTO.setJobPhone(jobPhones.toString());
        return employeeDTO;
    }
}
