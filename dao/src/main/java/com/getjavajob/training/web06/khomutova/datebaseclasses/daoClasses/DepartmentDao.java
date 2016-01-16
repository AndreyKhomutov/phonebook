package com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses;


import com.getjavajob.training.web06.khomutova.phonebookclasses.Department;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class DepartmentDao extends GenericDao<Department> {

    @Autowired
    public DepartmentDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected String getTableName() {
        return "department";
    }

    @Override
    protected String getInsertStatement() {
        return "INSERT INTO " + getTableName() + "(name, boss) VALUES ( ?, ?)";
    }

    @Override
    protected String getUpdateByIdStatement() {
        return "UPDATE " + getTableName() + " SET name = ?, boss = ? WHERE id =?";
    }

    @Override
    protected Department createInstanceFromResult(ResultSet resultSet) throws SQLException {
        Department department = new Department();
        department.setId(resultSet.getInt("id"));
        department.setName(resultSet.getString("name"));
        department.setDepartmentBoss(makeBoss(resultSet.getInt("boss")));
        return department;
    }

    private Employee makeBoss(int id) {
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }
}
