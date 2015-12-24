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
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">PhoneBook</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <form class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" placeholder="Имя пользователя" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Пароль" class="form-control">
                </div>
                <button type="submit" class="btn btn-success">Войти</button>
            </form>
        </div>
        <!--/.navbar-collapse -->
    </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>Телефонная книга</h1>

        <p>В телефонной книге представлены список сотрудников и список департаментов.</p>

        <p><a class="btn btn-primary btn-lg" href="employees" role="button">Подробнее &raquo;</a></p>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-4">
            <h2>Сотрудники</h2>

            <p>Список сотрудников </p>

            <p><a class="btn btn-default" href="/employees" role="button">Посмотреть &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>Департаменты</h2>

            <p>Список департаментов </p>

            <p><a class="btn btn-default" href="/departments" role="button">Посмотреть &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>Поиск</h2>

            <p>Здесь можно поискать сотрудников или департамент по различным параметрам</p>

            <p><a class="btn btn-default" href="/search" role="button">Посмотреть &raquo;</a></p>
        </div>
    </div>

    <hr>


</div>
<!-- /container -->

<div class="container">
    <h2>Список сотрудников</h2>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Email</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="dao" class="com.getjavajob.training.web06.khomutova.datebaseclasses.EmployeeDao"
                     scope="application"/>
        <c:forEach var="employee" items="${dao.getAll()}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.email}</td>
                <td>
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Действие
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Просмотреть</a></li>
                            <li><a href="#">Редактировать</a></li>
                            <li><a href="#">Удалить</a></li>
                                <%--<li class="divider"></li>--%>
                                <%--<li><a href="#">Отдельная ссылка</a></li>--%>
                        </ul>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <footer>
        <p>&copy; getjavajob.ru</p>
    </footer>
</div>
</body>
</html>