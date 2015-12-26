package com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses;


import com.getjavajob.training.web06.khomutova.phonebookclasses.Address;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Department;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Phone;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao extends GenericDao<Employee> {

    @Override
    protected String getTableName() {
        return "employee";
    }

    @Override
    protected String getInsertStatement() {
        return "INSERT INTO " + getTableName() + "(name, birthday, phones, icq, email, boss, skype, department, addresses) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateByIdStatement() {
        return "UPDATE " + getTableName() + " SET name = ?,  birthday = ?, phones = ?, icq = ?, email = ?,  boss = ?, skype = ?, department = ?, addresses = ? WHERE id =?";
    }

    @Override
    protected Employee createInstanceFromResult(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setName(resultSet.getString("name"));
        employee.setBirthday(resultSet.getDate("birthday"));
        employee.setPhones(getPhones(resultSet.getString("phones")));
        employee.setIcq(resultSet.getString("icq"));
        employee.setSkype(resultSet.getString("skype"));
        employee.setEmail(resultSet.getString("email"));
        employee.setBoss(makeBoss(resultSet.getInt("boss")));
        employee.setDepartment(makeDepartment(resultSet.getInt("department")));
        employee.setAddresses(makeAddress(resultSet.getString("addresses")));
        return employee;
    }

    private ArrayList<Phone> getPhones(String phonesDAO){
        String[] phonesString=phonesDAO.split(" ");
        ArrayList<Phone> phones=new ArrayList<>();
        PhoneDao phoneDao=new PhoneDao();
        for (String phone: phonesString){
            Phone phone1=phoneDao.get(Integer.parseInt(phone));
            phones.add(phone1);
        }
        return phones;
    }

    private Employee makeBoss(int id){
        Employee employee=new Employee();
        employee.setId(id);
        return employee;
    }

    private Department makeDepartment(int id){
        DepartmentDao departmentDao=new DepartmentDao();
        Department department=new Department();
        department.setId(id);
        department.setName(departmentDao.get(id).getName());
        return department;
    }

    private ArrayList<Address> makeAddress(String id){
        AddressDao addressDao=new AddressDao();
        ArrayList<Address> addresses=new ArrayList<>();
        String[] addressesDAO=id.split(" ");
        for (String addressID: addressesDAO) {
            Address address=addressDao.get(Integer.parseInt(addressID));
            addresses.add(address);
        }
        return addresses;
    }
}
