<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<div class="jumbotron">
    <form action="doSearch" method="post">
        <div class="container">
            <h2>Поиск по сотрудникам</h2>
            <div class="col-lg-6">
                <div class="input-group">
                    <input type="text" name="search" class="form-control">
      <span class="input-group-btn">
        <input type="submit" value="Search" class="btn btn-default">
      </span>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
