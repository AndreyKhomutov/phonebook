package com.getjavajob.training.web06.khomutova.servlets;

import com.getjavajob.training.web06.khomutova.service.service.DepartmentService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteDepartment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentService departmentService = ApplicationContextProvider.getApplicationContext().getBean("DepartmentService", DepartmentService.class);
        departmentService.delete(Integer.parseInt(req.getParameter("ID")));
        resp.sendRedirect("/departments");
    }
}