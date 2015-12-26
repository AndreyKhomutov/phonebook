package com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses;

import com.getjavajob.training.web06.khomutova.phonebookclasses.Address;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDao extends GenericDao<Address> {

    @Override
    protected String getTableName() {
        return "address";
    }

    @Override
    protected String getInsertStatement() {
        return "INSERT INTO " + getTableName() + "(city, street, apartment, postal, type) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateByIdStatement() {
        return "UPDATE " + getTableName() + " SET city = ?, street = ?, apartment = ?, postal = ?, type = ? WHERE id =?";
    }

    @Override
    protected Address createInstanceFromResult(ResultSet resultSet) throws SQLException {
        Address address = new Address();
        address.setId(resultSet.getInt("id"));
        address.setCity(resultSet.getString("city"));
        address.setStreet(resultSet.getString("street"));
        address.setApartment(resultSet.getInt("apartment"));
        address.setPostal(resultSet.getInt("postal"));
        address.setAddressType(getType(resultSet.getString("type")));
        return address;
    }
}
