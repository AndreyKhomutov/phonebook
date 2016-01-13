package com.getjavajob.training.web06.khomutova.servlets;

import com.getjavajob.training.web06.khomutova.phonebookclasses.Department;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import com.getjavajob.training.web06.khomutova.service.service.DepartmentService;
import com.getjavajob.training.web06.khomutova.service.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CreateDepartment")
public class CreateDepartment extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        Department department = new Department();
        department.setName(request.getParameter("name"));

        EmployeeService employeeService = new EmployeeService();
        int bossID = Integer.parseInt(request.getParameter("boss")) + 1;
        Employee boss = employeeService.get(bossID);
        department.setDepartmentBoss(boss);

        DepartmentService departmentService = new DepartmentService();
        departmentService.add(department);

        response.sendRedirect("/departments");
    }
}