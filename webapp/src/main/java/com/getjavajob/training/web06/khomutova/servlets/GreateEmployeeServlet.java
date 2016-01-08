package com.getjavajob.training.web06.khomutova.servlets;

import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.AddressDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.DepartmentDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.EmployeeDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.PhoneDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Address;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Phone;
import com.getjavajob.training.web06.khomutova.service.service.DepartmentService;
import com.getjavajob.training.web06.khomutova.service.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet("/GreateEmployeeServlet")
public class GreateEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        Employee employee=new Employee();
        employee.setName(request.getParameter("name"));
        String date=request.getParameter("date");
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            employee.setBirthday(dateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setIcq(request.getParameter("ICQ"));
        employee.setSkype(request.getParameter("skype"));
        employee.setEmail(request.getParameter("email"));

        EmployeeService employeeService=new EmployeeService();
        employeeService.setDao(new EmployeeDao());
        Employee boss=employeeService.get(Integer.parseInt(request.getParameter("boss")));
        employee.setBoss(boss);
        System.out.println(employee.getBoss().getName());

        employee.setAddresses(makeAddress(request.getParameter("addresses")));
        employee.setPhones(getPhones(request.getParameter("phones")));

        DepartmentService departmentService=new DepartmentService();
        departmentService.setDao(new DepartmentDao());
        employee.setDepartment(departmentService.get(Integer.parseInt(request.getParameter("departmentID"))));


//        System.out.println(employee.getName());
//        System.out.println(employee.getBirthday().toString());
//        System.out.println(employee.getPhones().size());
//        System.out.println(employee.getAddresses().size());
//        System.out.println(employee.getIcq());
//        System.out.println(employee.getEmail());
//        System.out.println(employee.getSkype());
//        System.out.println(employee.getBoss().getName());
//        System.out.println(employee.getBoss().getId());
//        System.out.println(employee.getDepartment().getName());
//        System.out.println(employee.getDepartment().getId());

        employeeService.add(employee);

        response.sendRedirect("/employees");
    }

    private ArrayList<Address> makeAddress(String id) {
        AddressDao addressDao = new AddressDao();
        ArrayList<Address> addresses = new ArrayList<>();
        String[] addressesDAO = id.split(" ");
        for (String addressID : addressesDAO) {
            Address address = addressDao.get(Integer.parseInt(addressID));
            addresses.add(address);
        }
        return addresses;
    }

     private ArrayList<Phone> getPhones(String phonesDAO) {
        String[] phonesString = phonesDAO.split(" ");
        ArrayList<Phone> phones = new ArrayList<>();
        PhoneDao phoneDao = new PhoneDao();
        for (String phone : phonesString) {
            Phone phone1 = phoneDao.get(Integer.parseInt(phone));
            phones.add(phone1);
        }
        return phones;
    }
}