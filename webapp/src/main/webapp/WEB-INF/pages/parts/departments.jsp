<%@ page import="com.getjavajob.training.web06.khomutova.service.service.DepartmentService" %>
<%@ page import="com.getjavajob.training.web06.khomutova.phonebookclasses.Department" %>
<%@ page import="java.util.List" %>
<%@ page import="com.getjavajob.training.web06.khomutova.servlets.ApplicationContextProvider" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<jsp:include page="/WEB-INF/pages/parts/header.jsp"/>
<jsp:include page="/WEB-INF/pages/parts/searchform.jsp"/>
<jsp:include page="/WEB-INF/pages/parts/lists.jsp"/>
<div>
    <p><a class="btn btn-primary btn-sm RbtnMargin" href="/addDepartment" role="button">Добавить</a></p>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th></th>
        </tr>
        </thead>
        <tbody>


        <%--<jsp:useBean id="departments" class="com.getjavajob.training.web06.khomutova.service.service.DepartmentService"--%>
                     <%--scope="application"/>--%>
        <%--<c:forEach var="department" items="${departments.all}">--%>

        <%
            DepartmentService departmentService = ApplicationContextProvider.getApplicationContext().getBean("DepartmentService", DepartmentService.class);

            List<Department> departmentList=departmentService.getAll();
            for (Department department:departmentList) {
        %>

            <tr>
                <td><%=department.getId()%></td>
                <td><%=department.getName()%></td>
                <td>
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Действие
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu" role="menu">
                            <li>
                                <a href="/DeleteDepartmentServlet?ID=${department.id}">Удалить</a>
                            </li>
                            <li><a href="/department?ID=${department.id}">Просмотреть</a></li>
                            <li><a href="/updateDepartment?ID=${department.id}">Редактировать</a></li>
                            <% if (session.getAttribute("profileType") != null && session.getAttribute("profileType").equals("admin")) {
                            %>
                            <li><a href="/DeleteDepartmentServlet?ID=${department.id}">Удалить</a></li>
                            <%
                                }
                            %>
                        </ul>
                    </div>
                </td>
            </tr>
        <% }%>
        </tbody>
    </table>
</div>
</body>
</html>
