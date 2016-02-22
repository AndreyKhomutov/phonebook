<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <jsp:include page="/WEB-INF/jsp/parts/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/parts/headerBody.jsp"/>
<jsp:include page="/WEB-INF/jsp/parts/searchform.jsp"/>
<jsp:include page="/WEB-INF/jsp/parts/lists.jsp"/>
<div>
    <p><a class="btn btn-primary btn-sm RbtnMargin" href="/addEmployee" role="button">Add</a></p>
    <p><a class="btn btn-primary pull-right btn-lg RbtnMargin" href="/toXmlEmployee" role="button">toXML</a></p>
    <table class="table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Skype</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.name}</td>
                <td>${employee.email}</td>
                <td>${employee.skype}</td>
                <td>
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Choose
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="/showEmployee?ID=${employee.id}">Show</a></li>
                            <li><a href="/updateEmployee?ID=${employee.id}">Update</a></li>
                            <% if (session.getAttribute("profileType") != null && session.getAttribute("profileType").equals("admin")) {
                            %>
                            <li><a href="/deleteEmployee?ID=${employee.id}">Delete</a></li>
                            <%
                                }
                            %>
                        </ul>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
