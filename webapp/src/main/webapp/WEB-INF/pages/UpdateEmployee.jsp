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


<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span
                    class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>

            </button>
            <a class="navbar-brand" href="#" contenteditable="false">E-academie</a>

        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#" class="">История</a>

                </li>
                <li><a href="#about" class="">Семинары рядом</a>

                </li>
                <li><a href="#contact" class="">Записаться</a>

                </li>
                <li><a href="#contact" class="">Оплата</a>

                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Валентина Константинова(Мастер) <span
                            class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Профиль</a></li>
                        <li><a href="#">Техподдержка</a></li>

                        <li class="divider"></li>
                        <li><a href="#">Выйти</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>Редактировать профиль</h1>

            <p></p>
        </div>


        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h2 class="panel-title">Профиль мастера </h2>

                            <div class="panel-body">

                                <form accept-charset="UTF-8" action="#" method="post" class="form-horizontal"
                                      role="form">


                                    <div class="form-group">
                                        <label for="inputEmail3" class="col-sm-2 control-label">Фамилия</label>

                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" id="inputEmail3"
                                                   value="Константинова">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="inputEmail3" class="col-sm-2 control-label">Имя</label>

                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" id="inputEmail3" value="Валентина">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="inputEmail3" class="col-sm-2 control-label">Отчество</label>

                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" id="inputEmail3"
                                                   value="Станиславовна">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="inputEmail3" class="col-sm-2 control-label">Email</label>

                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" id="inputEmail3"
                                                   value="valener@gmail.com">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Телефон</label>

                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" id="inputEmail3"
                                                   value="+7 903 655 23 72">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Дата рождения</label>

                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" id="inputEmail3"
                                                   value="12.08.1987">
                                        </div>
                                    </div>

                                    <hr>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Номер карты</label>

                                        <div class="col-sm-5">
                                            <input type="text" class="form-control" id="inputEmail3" value="002323">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">ПИН</label>

                                        <div class=" col-sm-5">
                                            <div class="input-group">
                                                <input type="text" class="form-control" value="****">
                                <span class="input-group-btn">
        							<button class="btn btn-default" type="button"><i
                                            class="glyphicon glyphicon-arrow-left"></i> Сгенерировать
                                    </button>
                                  </span></div>
                                        </div>

                                    </div>

                                    <hr>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="user_brand_id">Салон</label>

                                        <div class="col-sm-10">
                                            <select class="col-sm-10 form-control" id="user_brand_id"
                                                    name="user[brand_id]">
                                                <option value="1" class="">Ромашака (Москва, ул. Красностуденческая, д.
                                                    123. корп. 4)
                                                </option>

                                            </select>
                                            <span class="help-block">Начните вводить название или адрес салона чтобы найти его.</span>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label"></label>

                                        <div class="col-sm-10">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox"> Получать email уведомления
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox"> Получать SMS уведомления
                                                </label>
                                            </div>
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