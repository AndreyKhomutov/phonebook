package com.getjavajob.training.web06.khomutova.datebaseclasses;

import com.getjavajob.training.web06.khomutova.phonebookclasses.HomeAddress;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeAddressDao extends GenericDao<HomeAddress> {

    @Override
    protected String getTableName() {
        return "homeaddress";
    }

    @Override
    protected String getInsertStatement() {
        return "INSERT INTO " + getTableName() + "(city, street, apartment, postal) VALUES (?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateByIdStatement() {
        return "UPDATE " + getTableName() + " SET city = ?,  street = ?, apartment = ?, postal = ? WHERE id =?";
    }

    @Override
    protected HomeAddress createInstanceFromResult(ResultSet resultSet) throws SQLException {
        HomeAddress homeAddress = new HomeAddress();
        homeAddress.setId(resultSet.getInt("id"));
        homeAddress.setCity(resultSet.getString("city"));
        homeAddress.setStreet(resultSet.getString("street"));
        homeAddress.setApartment(resultSet.getInt("apartment"));
        homeAddress.setPostal(resultSet.getInt("postal"));
        return homeAddress;
    }
}
