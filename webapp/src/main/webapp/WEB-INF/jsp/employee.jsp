<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <jsp:include page="/WEB-INF/jsp/parts/head.jsp"/>
    <style>
        <%@include file="/resources/css/addPictureButton.css" %>
    </style>
</head>
<html>
<body>
<jsp:include page="/WEB-INF/jsp/parts/headerBody.jsp"/>
<jsp:include page="/WEB-INF/jsp/parts/searchform.jsp"/>
<jsp:include page="/WEB-INF/jsp/parts/lists.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h1 class="panel-title">Name: ${employee.name}
                    </h1>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center">

                            <form method="post" action="/photo" headers="content-type=multipart/*"
                                  enctype="multipart/form-data">
                                <img id="blah" src='data:image/jpeg;base64,${photo}'
                                     class="img-thumbnail img-responsive" style="height:100px "/>
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

                                <input type="hidden" name="deletePhoto" class="form-control" id="deletePhoto"
                                       value="false">
                            </form>
                        </div>
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Department:</td>
                                    <td>${employee.department.name}
                                    </td>
                                </tr>
                                <tr>
                                    <td>Birtday</td>
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
                                    <td>Boss</td>
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
                                <p><a class="btn btn-default" href="/showEmployees" role="button">Back &raquo;</a></p>
                            </tr>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    <%@include file="/resources/js/addPicture.js" %>
</script>
</body>
</html>