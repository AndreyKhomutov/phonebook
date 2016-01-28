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
                    <h1 class="panel-title">Имя: ${department.name}
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
                                    <td>${department.name}
                                    </td>
                                </tr>
                                <tr>
                                    <td>Начальник</td>
                                    <td>${boss.name}
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <tr>
                                <p><a class="btn btn-default" href="/showDepartments" role="button">Назад &raquo;</a>
                                </p>
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