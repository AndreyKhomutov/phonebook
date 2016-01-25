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
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h1 class="panel-title">Имя: ${employee.name}
                    </h1>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center">

                            <form method="post" action="/photo" headers = "content-type=multipart/*" enctype="multipart/form-data">

                                <img id="blah" src='data:image/jpeg;base64,${photo}' class="img-circle img-responsive"/>

                                <span class="btn btn-success btn-file">
                                  <i class="icon-plus"></i> <span>Choose picture</span>
                                   <input type="file" name="image" id="imgInp"/>
                                 </span>

                                <button type="submit" id="buttonSave" data-role="button"
                                        class="btn btn-default btn-sm">
                                    <span class="glyphicon glyphicon-ok"></span></button>

                                <button type="button" id="buttonDelete" data-role="button"
                                        class="btn btn-default btn-sm">
                                    <span class="glyphicon glyphicon-remove"></span></button>

                                <input type="hidden" name="ID" class="form-control" id="ID"
                                value=${employee.id}>
                                </form>
                        </div>
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Департамент:</td>
                                    <td>${employee.department.name}
                                    </td>
                                </tr>
                                <tr>
                                    <td>Дата рождения</td>
                                    <td>${employee.birthday}
                                    </td>
                                </tr>
                                <tr>
                                    <td>ICQ</td>
                                    <td>${employee.icq}
                                    </td>
                                </tr>
                                <tr>
                                    <td>EMAIL</td>
                                    <td>${employee.email}
                                    </td>
                                </tr>
                                <tr>
                                    <td>SKYPE</td>
                                    <td>${employee.skype}
                                    </td>
                                </tr>
                                <tr>
                                    <td>Начальник</td>
                                    <td>${employee.boss.name}
                                    </td>
                                </tr>
                                <c:forEach var="phone" items="${employee.phones}">
                                    <tr>
                                        <td>Phone Number</td>
                                        <td>${phone.number} ${phone.entityType}
                                        </td>
                                    </tr>
                                </c:forEach>
                                <c:forEach var="adress" items="${employee.addresses}">
                                    <tr>
                                        <td>Address</td>
                                        <td>
                                                ${adress.city} ${adress.street} ${adress.addressType}
                                        </td>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <tr>
                                <p><a class="btn btn-default" href="/showEmployees" role="button">Назад &raquo;</a></p>
                            </tr>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $("#buttonDelete").click(function () {
                $('#blah').attr('src', "/resources/avatar.jpg");
                $('#imgInp').change(function(){
                    readURL("/resources/avatar.jpg");
                });
            }
    );

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#blah').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
    $("#imgInp").change(function () {
        readURL(this);
    });
</script>

<style>
    body {
        padding-top: 50px;
    }

    .btn-file {
        position: relative;
        overflow: hidden;
        margin-right: 4px;
    }

    .btn-file input {
        position: absolute;
        top: 0;
        right: 0;
        margin: 0;
        opacity: 0;
        filter: alpha(opacity=0);
        transform: translate(-300px, 0) scale(4);
        font-size: 23px;
        direction: ltr;
        cursor: pointer;
    }

    * + html .btn-file {
        padding: 2px 15px;
        margin: 1px 0 0 0;
    }
</style>
</body>
</html>