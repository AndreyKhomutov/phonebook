<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<jsp:include page="/WEB-INF/jsp/parts/header.jsp"/>
<jsp:include page="/WEB-INF/jsp/parts/searchform.jsp"/>
<jsp:include page="/WEB-INF/jsp/parts/lists.jsp"/>
<div>
    <p><a class="btn btn-primary btn-sm RbtnMargin" href="/addDepartment" role="button">Добавить</a></p>
    <table class="table">
        <thead>
        <tr>
            <th>Name</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="department" items="${departments}">
            <tr>
                <td>${department.name}</td>
                <td>
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Действие
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="/showDepartment?ID=${department.id}">Просмотреть</a></li>
                            <li><a href="/updateDepartment?ID=${department.id}">Редактировать</a></li>
                            <% if (session.getAttribute("profileType") != null && session.getAttribute("profileType").equals("admin")) {
                            %>
                            <li><a href="/deleteDepartment?ID=${department.id}">Удалить</a></li>
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
