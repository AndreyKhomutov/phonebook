package com.getjavajob.training.web06.khomutova.service.service;

import com.getjavajob.training.web06.khomutova.datebaseclasses.DepartmentDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.dto.DepartmentDTO;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Department;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.getjavajob.training.web06.khomutova.service.converters.DepartmentConverter;

import java.util.List;

public class DepartmentService {
    private DepartmentConverter departmentConverter = new DepartmentConverter();
    private DepartmentDao departmentDao = new DepartmentDao();


    public void addDepartment(Department department) {
        DepartmentDTO departmentDTO = departmentConverter.fromDepartmentToDTO(department);
        departmentDao.add(departmentDTO);
    }

    public Department getDepartment(int departmentID) {
        DepartmentDTO departmentDTO = departmentDao.get(departmentID);
        Department department = departmentConverter.fromDTOToDepartment(departmentDTO);
        return department;
    }

    public void setDepartment(Department department) {
        DepartmentDTO departmentDTO = departmentConverter.fromDepartmentToDTO(department);
        departmentDao.update(departmentDTO);
    }

    public void removeDepartment(int departmentID) {
        departmentDao.delete(departmentID);
    }

    public List<Employee> getDepartmentEmployees(int departmentID) {
        return null;
    }
}
