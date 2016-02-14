<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/jsp/parts/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/parts/searchform.jsp"/>
<jsp:include page="/WEB-INF/jsp/parts/lists.jsp"/>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>Create employee</h1>

            <p></p>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <div class="panel-body">
                                <form accept-charset="UTF-8" action="/doAddEmployee" method="post"
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
                                        <label for="date" class="col-sm-2 control-label">Birthday</label>

                                        <div class="col-sm-10">
                                            <input type="date" name="date" class="form-control" id="date"
                                                   value="Введите дату рождения">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="ICQ" class="col-sm-2 control-label">ICQ</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="ICQ" class="form-control" id="ICQ"
                                                   value="Введите ICQ">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="skype" class="col-sm-2 control-label">skype</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="skype" class="form-control" id="skype"
                                                   value="Введите skype">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="email" class="col-sm-2 control-label">email</label>

                                        <div class="col-sm-10">
                                            <input type="email" name="email" class="form-control" id="email"
                                                   value="Введите email">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Department</label>

                                        <div class="col-sm-10">
                                            <select value class="form-control" name="department">
                                                <c:forEach items="${departments}" var="departments"
                                                           varStatus="status">
                                                    <option value="${status.index}">${departments.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Boss</label>

                                        <div class="col-sm-10">
                                            <select value class="form-control" name="boss">
                                                <c:forEach items="${employees}" var="employees"
                                                           varStatus="status">
                                                    <option value="${status.index}">${employees.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Phones</label>

                                        <div class="col-sm-10">
                                            <div class="input_fields_wrap">
                                                <table class="table table-hover" id="tab_logic">
                                                    <tbody>
                                                    <tr>
                                                        <td>
                                                            <input type="text"
                                                                   pattern="^([0|\+[0-9]{1,5})?([1-9][0-9]{9})$"
                                                                   name="mytext[]" class="form-control"
                                                                   list="phones" value="телефон +7(999)...">
                                                        </td>
                                                        <td>
                                                            <select name='Type[]' placeholder='Type'
                                                                    class="form-control">
                                                                <option>home</option>
                                                                <option>job</option>
                                                            </select>
                                                        </td>
                                                        <td>
                                                            <button class="add_field_button">Add phone</button>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Addresses</label>

                                        <div class="col-sm-10">
                                            <div class="input_fields_wrap2">
                                                <table class="table table-hover" id="tab_logic2">
                                                    <tbody>
                                                    <tr>
                                                        <td>
                                                            <input type="text"
                                                                   name="mytext2[]" class="form-control"
                                                                   list="addresses"
                                                                   value="Format:178000 SPB Volgogradskaya 10">
                                                        </td>
                                                        <td>
                                                            <select name='Type2[]' placeholder='Type'
                                                                    class="form-control">
                                                                <option>home</option>
                                                                <option>job</option>
                                                            </select>
                                                        </td>
                                                        <td>
                                                            <button class="add_field_button2">Add address</button>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>

                                    <datalist id="phones">
                                        <c:forEach items="${phones}" var="phones"
                                                   varStatus="status">
                                            <option value="${phones.number}">${phones.entityType}</option>
                                        </c:forEach>
                                    </datalist>

                                    <datalist id="addresses">
                                        <c:forEach items="${addresses}" var="addresses"
                                                   varStatus="status">
                                            <option value="${addresses.postal} ${addresses.city} ${addresses.street} ${addresses.apartment}">${addresses.addressType}</option>
                                        </c:forEach>
                                    </datalist>

                                    <input class="btn btn-success btn btn-lg btn-success btn-block" name="commit"
                                           type="submit" value="Save">
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
<script>
    <%@include file="/resources/js/addEmployee.js" %>
</script>
</body>
</html>