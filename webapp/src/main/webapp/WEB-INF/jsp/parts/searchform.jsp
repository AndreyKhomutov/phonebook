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

<script>
    $(function () {
        function log(message) {
            $("<div>").text(message).prependTo("#log");
            $("#log").scrollTop(0);
        }

        $("#search").autocomplete({
            source: function (request, response) {
                $.ajax({
                    url: '<c:url value="/getEmployees" />',
                    dataType: "json",
                    data: {
                        filter: request.term
                    },

//                    success: function (data) {
//                        response($.map(data, function (employee, i) {
//                            return {value: employee.name, label: employee.name + ' ' + employee.email}
//                        }));
//                    },
                    success: function (data) {
                        s='';
                        s+='<table class="table">';
                        s+='<thead>';
                        s+='<tr>';
                        s+='<th>Name</th>';
                        s+='<th>Email</th>';
                        s+='<th>Skype</th>';
                        s+='</tr>';
                        s+='</thead>';
                        s+='<tbody>';
                        data.forEach(function (e) {
                            s+='<tr>';
                            s += '<td>' + e.name + '</td>'+'<td>'+e.email+'</td>'+'<td>'+e.skype+'</td>';
                            s+='</tr>';
                        });
                        s+='</tbody>';
                        s+='</table>';
                        $('#result').html(s);
                    },
                });
            },
            minLength: 3,
            select: function (event, ui) {
                log(ui.item ?
                "Selected: " + ui.item.label :
                "Nothing selected, input was " + this.value);
            },
            open: function () {
                $(this).removeClass("ui-corner-all").addClass("ui-corner-top");
            },
            close: function () {
                $(this).removeClass("ui-corner-top").addClass("ui-corner-all");
            }
        });
    });
</script>
<div id="result"></div>
</body>
</html>
