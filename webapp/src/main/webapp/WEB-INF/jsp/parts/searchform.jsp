<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
<body>
<div class="jumbotron">
    <form action="doSearch" method="post">
        <div class="container">
            <h2>Поиск по сотрудникам</h2>
            <div class="col-lg-6">
                <div class="input-group">
                    <input type="text" name="search" class="form-control" id="search">
      <span class="input-group-btn">
        <input type="submit" value="Search" class="btn btn-default">
      </span>
                </div>
            </div>
        </div>
    </form>
</div>
<script><%@include file="/resources/js/search.js"%></script>
<div id="result"></div>
</body>
</html>
