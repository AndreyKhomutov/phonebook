package com.getjavajob.training.web06.khomutova;

import com.getjavajob.training.web06.khomutova.datebaseclasses.EmployeeDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//public class HelloWorldServlet extends HttpServlet {

//    private String name;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        this.name = config.getInitParameter("name");
//    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        EmployeeDao employeeDao=new EmployeeDao();
//        StringBuilder sb = new StringBuilder("<html><body>");
//        sb.append("<table class=\"table\">");
//        List<Employee> employees=employeeDao.getAll();
//        for (Employee employee : employees) {
//       			sb.append("<tr><td>");
//            		sb.append(employee.getName()+"Yo");
//            			sb.append("</td><td>");
//           		sb.append(employee.getEmail());
//           			sb.append("</td></tr>");
//            	}
//        		sb.append("</table></body></html>");
//        response.getOutputStream().write(sb.toString().getBytes());
//    }
//}
