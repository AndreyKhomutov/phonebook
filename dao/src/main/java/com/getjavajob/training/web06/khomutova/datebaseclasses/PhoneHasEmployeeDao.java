package com.getjavajob.training.web06.khomutova.datebaseclasses;

import com.getjavajob.training.web06.khomutova.phonebookclasses.PhoneHasEmployee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneHasEmployeeDao extends GenericDao<PhoneHasEmployee> {

    protected String getTableName() {
        return "phone_has_employee";
    }

    protected String getInsertStatement() {
        return "INSERT INTO " + getTableName() + "(phoneID, employeeID) VALUES ( ?, ?)";
    }

    protected String getUpdateByIdStatement() {
        return "UPDATE " + getTableName() + " SET phoneID = ?, employeeID = ? WHERE id =?";
    }

    @Override
    protected PhoneHasEmployee createInstanceFromResult(ResultSet resultSet) throws SQLException {
        PhoneHasEmployee phoneHasEmployee = new PhoneHasEmployee();
        phoneHasEmployee.setId(resultSet.getInt("id"));
        phoneHasEmployee.setEmployeeID(resultSet.getInt("employeeID"));
        phoneHasEmployee.setPhoneID(resultSet.getInt("phoneID"));
        return phoneHasEmployee;
    }
}
