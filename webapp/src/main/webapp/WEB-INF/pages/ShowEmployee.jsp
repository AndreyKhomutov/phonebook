<%@ page import="com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.EmployeeDao" %>
<%@ page import="com.getjavajob.training.web06.khomutova.phonebookclasses.Address" %>
<%@ page import="com.getjavajob.training.web06.khomutova.phonebookclasses.Employee" %>
<%@ page import="com.getjavajob.training.web06.khomutova.phonebookclasses.Phone" %>
<%@ page import="com.getjavajob.training.web06.khomutova.service.service.EmployeeService" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js"></script>
</head>
<% EmployeeService employeeService = new EmployeeService();
    employeeService.setDao(new EmployeeDao());
    int id = Integer.parseInt(request.getParameter("ID"));
    Employee employee = employeeService.get(id);
%>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h1 class="panel-title">Имя:  <%= employee.getName() %>
                    </h1>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"><img alt="User Pic"
                                                                            src="http://uploadpie.com/Izix8"
                                                                            class="img-circle img-responsive"></div>
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Департамент:</td>
                                    <td><%=employee.getDepartment().getName() %>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Дата рождения</td>
                                    <td><%=employee.getBirthday().toString() %>
                                    </td>
                                </tr>
                                <tr>
                                    <td>ICQ</td>
                                    <td><%=employee.getIcq() %>
                                    </td>
                                </tr>
                                <tr>
                                    <td>EMAIL</td>
                                    <td><%=employee.getEmail() %>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Начальник</td>
                                    <td><%=employeeService.get(employee.getBoss().getId()).getName()%>
                                    </td>
                                </tr>
                                <%
                                    List<Phone> phones = employee.getPhones();
                                    for (Phone phone : phones) {
                                %>
                                <tr>
                                    <td>Phone Number</td>
                                    <td><%=phone.getNumber()%> <%=phone.getEntityType() %>
                                    </td>
                                </tr>
                                <%} %>
                                <%
                                    List<Address> addresses = employee.getAddresses();
                                    for (Address address : addresses) {
                                %>
                                <tr>
                                    <td>Address</td>
                                    <td><%=address.getCity() + " " + address.getStreet() + " " + address.getAddressType()%>
                                    </td>
                                </tr>
                                <%} %>
                                </tbody>
                            </table>
                            <tr>
                                <p><a class="btn btn-default" href="/employees" role="button">Назад &raquo;</a></p>
                            </tr>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>