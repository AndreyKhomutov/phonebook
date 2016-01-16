package com.getjavajob.training.web06.khomutova.servlets;

import com.getjavajob.training.web06.khomutova.phonebookclasses.Address;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Phone;
import com.getjavajob.training.web06.khomutova.service.service.DepartmentService;
import com.getjavajob.training.web06.khomutova.service.service.EmployeeService;
import org.springframework.context.ApplicationContext;

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

@WebServlet("/updateEmployeeServlet")
public class UpdateEmployee extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        EmployeeService employeeService = ApplicationContextProvider.getApplicationContext().getBean("EmployeeService", EmployeeService.class);
        Employee employee = new Employee();
        int id = Integer.parseInt(request.getParameter("ID"));
        Employee oldGay = employeeService.get(id);
        employee.setId(oldGay.getId());
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

        if (request.getParameter("boss") != null) {
            int bossID = Integer.parseInt(request.getParameter("boss")) + 1;
            Employee boss = employeeService.get(bossID);
            employee.setBoss(boss);
        } else {
            employee.setBoss(oldGay.getBoss());
        }

        if (request.getParameter("department") != null) {
            DepartmentService departmentService = ApplicationContextProvider.getApplicationContext().getBean("DepartmentService", DepartmentService.class);
            employee.setDepartment(departmentService.getAll().get(Integer.parseInt(request.getParameter("department"))));
        } else {
            employee.setDepartment(oldGay.getDepartment());
        }

        if (request.getParameterValues("addresses[]") != null) {
            employee.setAddresses(makeAddress(request.getParameterValues("addresses[]")));
        } else {
            employee.setAddresses((ArrayList<Address>) oldGay.getAddresses());
        }

        if (request.getParameterValues("phones[]") != null) {
            employee.setPhones(makePhones(request.getParameterValues("phones[]")));
        } else {
            employee.setPhones((ArrayList<Phone>) oldGay.getPhones());
        }

        employeeService.update(employee);
        response.sendRedirect("/employees");
    }

    private ArrayList<Phone> makePhones(String[] parameterValues) {
        EmployeeService employeeService = ApplicationContextProvider.getApplicationContext().getBean("EmployeeService", EmployeeService.class);
        List<Phone> phoneList = employeeService.getAllPhones();
        ArrayList<Phone> result = new ArrayList<>();
        for (String string : parameterValues) {
            int phoneID = Integer.parseInt(string);
            result.add(phoneList.get(phoneID));
        }
        return result;
    }

    private ArrayList<Address> makeAddress(String[] addreses) {
        EmployeeService employeeService = ApplicationContextProvider.getApplicationContext().getBean("EmployeeService", EmployeeService.class);
        List<Address> addressList = employeeService.getAllAddresses();
        ArrayList<Address> result = new ArrayList<>();
        for (String string : addreses) {
            int addressID = Integer.parseInt(string);
            result.add(addressList.get(addressID));
        }
        return result;
    }

}