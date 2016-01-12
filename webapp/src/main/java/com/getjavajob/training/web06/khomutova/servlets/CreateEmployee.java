package com.getjavajob.training.web06.khomutova.servlets;

import com.getjavajob.training.web06.khomutova.phonebookclasses.Address;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Phone;
import com.getjavajob.training.web06.khomutova.service.service.DepartmentService;
import com.getjavajob.training.web06.khomutova.service.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CreateEmployee")
public class CreateEmployee extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setName(request.getParameter("name"));
        String date = request.getParameter("date");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            employee.setBirthday(dateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setIcq(request.getParameter("ICQ"));
        employee.setSkype(request.getParameter("skype"));
        employee.setEmail(request.getParameter("email"));
        EmployeeService employeeService = new EmployeeService();
        int bossID = Integer.parseInt(request.getParameter("boss")) + 1;
        Employee boss = employeeService.get(bossID);
        employee.setBoss(boss);

        DepartmentService departmentService = new DepartmentService();
        employee.setDepartment(departmentService.getAll().get(Integer.parseInt(request.getParameter("department"))));

        employee.setAddresses(makeAddress(request.getParameterValues("addresses[]")));
        employee.setPhones(makePhones(request.getParameterValues("phones[]")));
        employeeService.add(employee);

        response.sendRedirect("/employees");
    }

    private ArrayList<Phone> makePhones(String[] parameterValues) {
        EmployeeService employeeService = new EmployeeService();
        List<Phone> phoneList = employeeService.getAllPhones();
        ArrayList<Phone> result = new ArrayList<>();
        for (String string : parameterValues) {
            int phoneID = Integer.parseInt(string);
            result.add(phoneList.get(phoneID));
        }
        return result;
    }

    private ArrayList<Address> makeAddress(String[] addreses) {
        EmployeeService employeeService = new EmployeeService();
        List<Address> addressList = employeeService.getAllAddresses();
        ArrayList<Address> result = new ArrayList<>();
        for (String string : addreses) {
            int addressID = Integer.parseInt(string);
            result.add(addressList.get(addressID));
        }
        return result;
    }

}