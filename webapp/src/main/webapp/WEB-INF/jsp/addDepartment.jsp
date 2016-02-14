<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/jsp/parts/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/parts/headerBody.jsp"/>
<jsp:include page="/WEB-INF/jsp/parts/searchform.jsp"/>
<jsp:include page="/WEB-INF/jsp/parts/lists.jsp"/>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>Create department</h1>

            <p></p>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <div class="panel-body">
                                <form:form accept-charset="UTF-8" commandname="department" action="/doAddDepartment"
                                           method="post"
                                           class="form-horizontal"
                                           role="form">
                                    <div class="form-group">
                                        <label for="name" class="col-sm-2 control-label">Name</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="name" class="form-control" id="name"
                                                   value="Введите имя">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Boss</label>
                                            <%--departmentBoss--%>
                                        <div class="col-sm-10">
                                            <select value class="form-control" name="departmentBoss">
                                                <c:forEach items="${employees}" var="employees"
                                                           varStatus="status">
                                                    <option value="${status.index}">${employees.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <input class="btn btn-success btn btn-lg btn-success btn-block" name="commit"
                                           type="submit" value="Save">
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>