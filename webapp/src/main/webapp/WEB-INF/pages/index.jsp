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
            <% if (session.getAttribute("user") == null && session.getAttribute("profileType") == null) {
            %>
            <form action="LoginServlet" method="post" class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" name="user" placeholder="Имя пользователя" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" name="pwd" placeholder="Пароль" class="form-control">
                </div>
                <button type="submit" value="Login" class="btn btn-success">Войти</button>
                <label>
                    <input type="checkbox" name="remember_me" id="remember_me">
                    Remember me on this computer
                </label>
            </form>
            <%
            } else {
                String user = (String) session.getAttribute("user");

            %>
            <form action="LogoutServlet" method="post" class="navbar-form navbar-right">
                <div class="form-group">
                    <h4><p class="text-success"> Welcome <%=user%> !</h4>
                    </p>
                </div>
                <div class="form-group">
                    <input type="submit" value="Logout" class="btn btn-success">
                </div>
            </form>
            <% }
            %>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <h2>Поиск по сотрудникам и департементам</h2>

        <div class="col-lg-6">
            <div class="input-group">
                <input type="text" class="form-control">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">Искать</button>
      </span>
            </div>
        </div>
    </div>
</div>

<div class="container">
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
    </div>
    <hr>
</div>
</body>

</html>
