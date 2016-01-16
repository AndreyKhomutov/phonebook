package com.getjavajob.training.web06.khomutova.servlets;

import com.getjavajob.training.web06.khomutova.service.service.EmployeeService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEmployee extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeService employeeService = ApplicationContextProvider.getApplicationContext().getBean("EmployeeService", EmployeeService.class);
        employeeService.delete(Integer.parseInt(req.getParameter("ID")));
        resp.sendRedirect("/employees");
    }
}