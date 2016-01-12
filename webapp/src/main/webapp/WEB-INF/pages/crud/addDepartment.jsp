<%@ page import="com.getjavajob.training.web06.khomutova.phonebookclasses.Address" %>
<%@ page import="com.getjavajob.training.web06.khomutova.phonebookclasses.Employee" %>
<%@ page import="com.getjavajob.training.web06.khomutova.phonebookclasses.Phone" %>
<%@ page import="com.getjavajob.training.web06.khomutova.service.service.EmployeeService" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>

<jsp:include page="/WEB-INF/pages/parts/header.jsp"/>
<jsp:include page="/WEB-INF/pages/parts/searchform.jsp"/>
<jsp:include page="/WEB-INF/pages/parts/lists.jsp"/>

<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>Создать сотрудника</h1>

            <p></p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <div class="panel-body">

                                <form accept-charset="UTF-8" action="CreateDepartment" method="post"
                                      class="form-horizontal"
                                      role="form">
                                    <div class="form-group">
                                        <label for="name" class="col-sm-2 control-label">Имя</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="name" class="form-control" id="name"
                                                   value="Введите имя">
                                        </div>
                                    </div>

                                    <% EmployeeService employeeService = new EmployeeService();
                                        List<Address> addresses = employeeService.getAllAddresses();
                                        request.setAttribute("addresses", addresses);
                                        List<Phone> phones = employeeService.getAllPhones();
                                        request.setAttribute("phones", phones);
                                        List<Employee> employees = employeeService.getAll();
                                        request.setAttribute("employees", employees);

                                    %>
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