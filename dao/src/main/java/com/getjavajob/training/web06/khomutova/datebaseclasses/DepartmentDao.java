package com.getjavajob.training.web06.khomutova.datebaseclasses;


import com.getjavajob.training.web06.khomutova.datebaseclasses.dto.DepartmentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDao extends GenericDao<DepartmentDTO> {

    @Override
    protected String getTableName() {
        return "department";
    }

    @Override
    protected String getInsertStatement() {
        return "INSERT INTO " + getTableName() + "(departmentName, employeeBoss_emloyeeID) VALUES ( ?, ?)";
    }

    @Override
    protected String getUpdateByIdStatement() {
        return "UPDATE " + getTableName() + " SET departmentName = ?, employeeBoss_emloyeeID = ? WHERE id =?";
    }

    @Override
    protected DepartmentDTO createInstanceFromResult(ResultSet resultSet) throws SQLException {
        DepartmentDTO department = new DepartmentDTO();
        department.setId(resultSet.getInt("id"));
        department.setDepartmentName(resultSet.getString("departmentName"));
        department.setEmployeeBoss_emloyeeID(resultSet.getInt("employeeBoss_emloyeeID"));
        return department;
    }
}
