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


</div>
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

                <form accept-charset="UTF-8" action="GreateEmployeeServlet" method="post" class="form-horizontal"
                      role="form">
                  <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Имя</label>

                    <div class="col-sm-10">
                      <input type="text" name="name" class="form-control" id="name" value="Введите имя">
                    </div>
                  </div>

                  <div class="form-group">
                    <label for="date" class="col-sm-2 control-label">Дата рождения</label>

                    <div class="col-sm-10">
                      <input type="date" name="date" class="form-control" id="date" value="Введите дату рождения">
                    </div>
                  </div>

                  <div class="form-group">
                    <label for="ICQ" class="col-sm-2 control-label">ICQ</label>

                    <div class="col-sm-10">
                      <input type="text" name="ICQ" class="form-control" id="ICQ" value="Введите ICQ">
                    </div>
                  </div>

                  <div class="form-group">
                    <label for="skype" class="col-sm-2 control-label">skype</label>

                    <div class="col-sm-10">
                      <input type="text" name="skype" class="form-control" id="skype" value="Введите skype">
                    </div>
                  </div>

                  <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">email</label>

                    <div class="col-sm-10">
                      <input type="email" name="email" class="form-control" id="email" value="Введите email">
                    </div>
                  </div>

                  <div class="form-group">
                    <label for="boss" class="col-sm-2 control-label">BossID</label>

                    <div class="col-sm-10">
                      <input type="number" name="boss" class="form-control" id="boss" value="Введите BossID">
                    </div>
                  </div>

                  <div class="form-group">
                    <label for="departmentID" class="col-sm-2 control-label">Департамент</label>

                    <div class="col-sm-10">
                      <input type="number" name="departmentID" class="form-control" id="departmentID" value="Введите departmentID">
                    </div>
                  </div>

                  <div class="form-group">
                    <label for="addresses" class="col-sm-2 control-label">Адреса</label>

                    <div class="col-sm-10">
                      <input type="text" name="addresses" class="form-control" id="addresses" value="Введите адрес">
                    </div>
                  </div>

                  <div class="form-group">
                    <label for="phones" class="col-sm-2 control-label">Телефоны</label>

                    <div class="col-sm-10">
                      <input type="text" name="phones" class="form-control" id="phones" value="Введите телефон">
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
    <!-- /.container -->
  </div>

</div>
<!-- /.container -->
</body>
</html>