<%@ page import="com.getjavajob.training.web06.khomutova.phonebookclasses.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.getjavajob.training.web06.khomutova.phonebookclasses.Department" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<jsp:include page="/WEB-INF/pages/parts/header.jsp"/>
<jsp:include page="/WEB-INF/pages/parts/searchform.jsp"/>
<jsp:include page="/WEB-INF/pages/parts/lists.jsp"/>
<div>
    <h2>Результаты поиска <%=request.getParameter("search")%>
    </h2>

    <p><a class="btn btn-primary btn-sm RbtnMargin" href="/addEmployee" role="button">Добавить</a></p>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="employees" class="com.getjavajob.training.web06.khomutova.service.service.EmployeeService"
                     scope="application"/>

        <jsp:useBean id="departments" class="com.getjavajob.training.web06.khomutova.service.service.DepartmentService"
                     scope="application"/>

        <%
            List<Employee> employeeSearch = employees.searchEmployee(request.getParameter("search"));
            for (Employee employee : employeeSearch) {
        %>
        <tr>
            <td><%=employee.getId()%>
            </td>
            <td><%=employee.getName()%>
            </td>
            <td>
                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Действие
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu" role="menu">
                        <li>
                            <a href="/DeleteEmployee?ID=<%=employee.getId()%>">Удалить</a>
                        </li>


                        <li><a href="/employee?ID=<%=employee.getId()%>">Просмотреть</a></li>
                        <li><a href="/updateEmployee?ID=<%=employee.getId()%>">Редактировать</a></li>
                        <% if (session.getAttribute("profileType") != null && session.getAttribute("profileType").equals("admin")) {
                        %>
                        <li><a href="/DeleteEmployee?ID=<%=employee.getId()%>">Удалить</a></li>
                        <%
                            }
                        %>
                    </ul>
                </div>
            </td>
        </tr>
        <%}%>


        <%
            List<Department> departmentSearch = departments.searchDepartment(request.getParameter("search"));
            for (Department department : departmentSearch) {
        %>
        <tr>
            <td><%=department.getId()%>
            </td>
            <td><%=department.getName()%>
            </td>
            <td>
                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Действие
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu" role="menu">
                        <li>
                            <a href="/DeleteDepartment?ID=<%=department.getId()%>">Удалить</a>
                        </li>


                        <li><a href="/department?ID=<%=department.getId()%>">Просмотреть</a></li>
                        <li><a href="/updateDepartment?ID=<%=department.getId()%>">Редактировать</a></li>
                        <% if (session.getAttribute("profileType") != null && session.getAttribute("profileType").equals("admin")) {
                        %>
                        <li><a href="/DeleteDepartment?ID=<%=department.getId()%>">Удалить</a></li>
                        <%
                            }
                        %>
                    </ul>
                </div>
            </td>
        </tr>
        <%}%>

        </tbody>
    </table>
</div>
</body>
</html>
