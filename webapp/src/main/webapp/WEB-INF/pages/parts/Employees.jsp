<%@ page import="com.getjavajob.training.web06.khomutova.service.service.EmployeeService" %>
<%@ page import="com.getjavajob.training.web06.khomutova.servlets.ApplicationContextProvider" %>
<%@ page import="com.getjavajob.training.web06.khomutova.phonebookclasses.Employee" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<jsp:include page="/WEB-INF/pages/parts/header.jsp"/>
<jsp:include page="/WEB-INF/pages/parts/searchform.jsp"/>
<jsp:include page="/WEB-INF/pages/parts/lists.jsp"/>
<div>
    <p><a class="btn btn-primary btn-sm RbtnMargin" href="/addEmployee" role="button">Добавить</a></p>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Email</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%
            EmployeeService employeeService = ApplicationContextProvider.getApplicationContext().getBean("EmployeeService", EmployeeService.class);
            List<Employee> employees=employeeService.getAll();
            for (Employee employee:employees) {
        %>
            <tr>
                <td><%=employee.getId()%></td>
                <td><%=employee.getName()%></td>
                <td><%=employee.getName()%></td>
                <td>
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Действие
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu" role="menu">
                            <li>
                                <a href="/DeleteEmployeeServlet?ID=<%=employee.getId()%>">Удалить</a>
                            </li>
                            <li><a href="/employee?ID=<%=employee.getId()%>">Просмотреть</a></li>
                            <li><a href="/updateEmployee?ID=<%=employee.getId()%>">Редактировать</a></li>
                            <% if (session.getAttribute("profileType") != null && session.getAttribute("profileType").equals("admin")) {
                            %>
                            <li><a href="#">Удалить</a></li>
                            <%
                                }
                            %>
                        </ul>
                    </div>
                </td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
