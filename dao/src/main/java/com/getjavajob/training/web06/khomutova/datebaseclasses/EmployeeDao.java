package com.getjavajob.training.web06.khomutova.datebaseclasses;

import com.getjavajob.training.web06.khomutova.service.dto.EmployeeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao extends GenericDao<EmployeeDTO> {

    @Override
    protected String getTableName() {
        return "employee";
    }

    @Override
    protected String getInsertStatement() {
        return "INSERT INTO " + getTableName() + "(name, birthday, homePhone, homeAddress_idHomeAddress, icq, skype, jobPhone,\n" +
                "    jobAddress, email, department_departmentID, bossID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateByIdStatement() {
        return "UPDATE " + getTableName() + " SET name = ?,  birthday = ?, homePhone = ?, icq = ?, skype = ?,  jobPhone = ?, jobAddress = ?, email = ?, bossID = ?, department_departmentID = ?, homeAddress_idHomeAddress = ? WHERE id =?";
    }

    @Override
    protected EmployeeDTO createInstanceFromResult(ResultSet resultSet) throws SQLException {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setBirthday(resultSet.getDate("birthday"));
        employee.setHomePhone(resultSet.getString("homePhone"));
        employee.setIcq(resultSet.getString("icq"));
        employee.setSkype(resultSet.getString("skype"));
        employee.setJobPhone(resultSet.getString("jobPhone"));
        employee.setJobAddress(resultSet.getString("jobAddress"));
        employee.setEmail(resultSet.getString("email"));
        employee.setBossID(resultSet.getInt("bossID"));
        employee.setDepartment_departmentID(resultSet.getInt("department_departmentID"));
        employee.setHomeAddress_idHomeAddress(resultSet.getInt("homeAddress_idHomeAddress"));
        return employee;
    }
}
