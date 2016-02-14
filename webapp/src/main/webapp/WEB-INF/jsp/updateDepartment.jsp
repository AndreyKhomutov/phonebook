<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/jsp/parts/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/parts/headerBody.jsp"/>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h3>Редактировать департамент ${department.name}
            </h3>

            <p></p>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <div class="panel-body">
                                <form accept-charset="UTF-8" action="doUpdateDepartment" method="post"
                                      class="form-horizontal"
                                      role="form">
                                    <div class="form-group">
                                        <label for="name" class="col-sm-2 control-label">ID</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="ID" class="form-control" id="ID"
                                                   value=${department.id}>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="name" class="col-sm-2 control-label">Имя</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="name" class="form-control" id="name"
                                                   value=${department.name}>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Руководитель</label>

                                        <div class="col-sm-10">
                                            <select value class="form-control" name="boss">
                                                <c:forEach items="${employees}" var="employees"
                                                           varStatus="status">
                                                    <option value="${status.index}">${employees.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <input class="btn btn-success btn btn-lg btn-success btn-block" name="commit"
                                           type="submit" value="Сохранить">
                                </form>
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