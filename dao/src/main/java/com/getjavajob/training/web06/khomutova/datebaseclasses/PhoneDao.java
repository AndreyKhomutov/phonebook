package com.getjavajob.training.web06.khomutova.datebaseclasses;

import com.getjavajob.training.web06.khomutova.datebaseclasses.dto.PhoneDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneDao extends GenericDao<PhoneDTO> {

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
    protected PhoneDTO createInstanceFromResult(ResultSet resultSet) throws SQLException {
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setId(resultSet.getInt("id"));
        phoneDTO.setNumber(resultSet.getString("number"));
        phoneDTO.setPhoneType(resultSet.getString("type"));
        return phoneDTO;
    }
}
