<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>

<jsp:include page="/WEB-INF/jsp/parts/header.jsp"/>
<jsp:include page="/WEB-INF/jsp/parts/searchform.jsp"/>
<jsp:include page="/WEB-INF/jsp/parts/lists.jsp"/>

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
                                <form accept-charset="UTF-8" action="/doAddEmployee" method="post"
                                      class="form-horizontal"
                                      role="form">
                                    <div class="form-group">
                                        <label for="name" class="col-sm-2 control-label">Имя</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="name" class="form-control" id="name"
                                                   value="Введите имя">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="date" class="col-sm-2 control-label">Дата рождения</label>
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
                                        <label class="col-sm-2 control-label">Департамент</label>
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
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Адреса</label>
                                        <div class="col-sm-10">
                                            <select value multiple class="form-control" name="addresses[]">
                                                <c:forEach items="${addresses}" var="addresses" varStatus="status">
                                                    <option value="${status.index}">${addresses.city} ${addresses.addressType}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Телефоны</label>
                                        <div class="col-sm-10" id="tab_logic_2">
                                            <select value multiple class="form-control" name="phones[]" id='select0'>
                                                <c:forEach items="${phones}" var="phones" varStatus="status">
                                                    <option value="${status.index}">${phones.number} ${phones.entityType}</option>
                                                </c:forEach>
                                                <div id='select1'></div>
                                            </select>
                                        </div>
                                    </div>

                                     <div class="form-group">
                                        <label class="col-sm-2 control-label">Добавить</label>
                                            <div class="col-sm-10">
                                                <table class="table table-hover" id="tab_logic">
                                                    <tbody>
                                                    <tr id='addr0'>
                                                        <td>
                                                            <input type="text" name='Number0'  placeholder='Number' class="form-control"/>
                                                        </td>
                                                        <td>
                                                            <select name='Type0' placeholder='Type' class="form-control">
                                                                <option>home</option>
                                                                <option>job</option>
                                                            </select>
                                                        </td>
                                                    </tr>
                                                    <tr id='addr1'></tr>
                                                    </tbody>
                                                </table>
                                                <a id="add_row" class="btn btn-default pull-left ">Добавить</a>
                                                <a id='delete_row' class="pull-right btn btn-default">Удалить</a>
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
<script>
    $(document).ready(function(){
        var i=1;
        $("#add_row").click(function(){
            $('#addr'+i).html("<td><input name='Number"+i+"' type='text' placeholder='Name' class='form-control input-md'  /> </td>" +
                    "<td><select  name='Type"+i+"' placeholder='Type'  class='form-control'><option>home</option><option>job</option></select></td>");
            $('#tab_logic').append('<tr id="addr'+(i+1)+'"></tr>');
           i++;
        });
        $("#delete_row").click(function(){
            if(i>1){
                $("#addr"+(i-1)).html('');
                i--;
            }
        });
    });
</script>
</body>
</html>