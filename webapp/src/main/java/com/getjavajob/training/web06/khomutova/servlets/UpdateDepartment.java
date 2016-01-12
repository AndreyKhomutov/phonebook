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

@WebServlet("/updateDepartmentServlet")
public class UpdateDepartment extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        DepartmentService departmentService = new DepartmentService();
        Department department = new Department();
        int id = Integer.parseInt(request.getParameter("ID"));
        Department oldDepartment = departmentService.get(id);
        department.setId(oldDepartment.getId());
        department.setName(request.getParameter("name"));

        if (request.getParameter("boss") != null) {
            int bossID = Integer.parseInt(request.getParameter("boss")) + 1;
            EmployeeService employeeService = new EmployeeService();
            Employee boss = employeeService.get(bossID);
            department.setDepartmentBoss(boss);
        } else {
            department.setDepartmentBoss(oldDepartment.getDepartmentBoss());
        }

        departmentService.update(department);
        response.sendRedirect("/departments");
    }
}