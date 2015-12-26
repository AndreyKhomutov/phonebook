package com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses;

import com.getjavajob.training.web06.khomutova.phonebookclasses.Phone;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneDao extends GenericDao<Phone> {

    @Override
    protected String getTableName() {
        return "phone";
    }

    @Override
    protected String getInsertStatement() {
        return "INSERT INTO " + getTableName() + "(number, type) VALUES (?, ?)";
    }

    @Override
    protected String getUpdateByIdStatement() {
        return "UPDATE " + getTableName() + " SET number = ?,  type = ? WHERE id =?";
    }

    @Override
    protected Phone createInstanceFromResult(ResultSet resultSet) throws SQLException {
        Phone phoneDTO = new Phone();
        phoneDTO.setId(resultSet.getInt("id"));
        phoneDTO.setNumber(resultSet.getString("number"));
        phoneDTO.setEntityType(getType(resultSet.getString("type")));
        return phoneDTO;
    }
}
