package com.getjavajob.training.web06.khomutova.service.converters;


import com.getjavajob.training.web06.khomutova.datebaseclasses.EmployeeDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.dto.DepartmentDTO;
import com.getjavajob.training.web06.khomutova.datebaseclasses.dto.EmployeeDTO;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Department;

public class DepartmentConverter {
    public Department fromDTOToDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getDepartmentName());
        EmployeeConverter employeeConverter = new EmployeeConverter();
        department.setDepartmentBoss(departmentDTO.getEmployeeBoss_emloyeeID());
        return department;
    }

    public DepartmentDTO fromDepartmentToDTO(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentName(department.getName());
        departmentDTO.setId(department.getId());
        departmentDTO.setEmployeeBoss_emloyeeID(department.getDepartmentBoss());
        return departmentDTO;
    }
}
