package com.getjavajob.training.web06.khomutova.service;

import com.getjavajob.training.web06.khomutova.phonebookclasses.*;
import com.getjavajob.training.web06.khomutova.service.dto.EmployeeDTO;

import java.util.List;

public class EmployeeService {

    public Employee makeEmpoyee(EmployeeDTO employeeDTO){
        validateValues(employeeDTO);
        Employee employee=new Employee();
        employee.setName(employeeDTO.getName());
        employee.setBirthday(employeeDTO.getBirthday());
        StringBuilder phones=new StringBuilder();
        phones.append(employeeDTO.getHomePhone());
        phones.append(employeeDTO.getJobPhone());
        List<Phone> employeePhones=makePhoneList(phones);
        employee.setPhones(employeePhones);
        int homeAddressID=employeeDTO.getHomeAddress_idHomeAddress();
        HomeAddress homeAddress=makeHomeAddress(homeAddressID);
        employee.setHomeHomeAddress(homeAddress);
        employee.setIcq(employeeDTO.getIcq());
        employee.setSkype(employeeDTO.getSkype());
        int departamentID=employeeDTO.getDepartment_departmentID();
        Department department=makeDepartament(departamentID);
        employee.setDepartment(department);
        String jobAddressString=employeeDTO.getJobAddress();
        JobAddress jobAddress=makeJobAddress(jobAddressString);
        employee.setJobAddress(jobAddress);
        int employeeBossId=employeeDTO.getBossID();
        Employee boss=getEmployee(employeeBossId);
        employee.setEmployeeBoss(boss);
        return employee;
    }

    private Employee getEmployee(int employeeBossId) {
        return null;
    }

    private JobAddress makeJobAddress(String jobAddressString) {
        return null;
    }

    private Department makeDepartament(int departamentID) {
        return null;
    }

    private void validateValues(EmployeeDTO employeeDTO) {

    }

    private HomeAddress makeHomeAddress(int homeAddresID) {
        return null;
    }

    private List<Phone> makePhoneList(StringBuilder phones) {
        return null;
    }
}
