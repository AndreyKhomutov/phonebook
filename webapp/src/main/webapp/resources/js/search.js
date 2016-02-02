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

                success: function (data) {
                    response($.map(data, function (employee, i) {
                        return {value: employee.name, label: employee.name + ' ' + employee.email}
                    }));
                },
                success: function (data) {
                    s = '';
                    s += '<table class="table">';
                    s += '<thead>';
                    s += '<tr>';
                    s += '<th>Name</th>';
                    s += '<th>Email</th>';
                    s += '<th>Skype</th>';
                    s += '</tr>';
                    s += '</thead>';
                    s += '<tbody>';
                    data.forEach(function (e) {
                        s += '<tr>';
                        s += '<td>' + e.name + '</td>' + '<td>' + e.email + '</td>' + '<td>' + e.skype + '</td>';
                        s += '</tr>';
                    });
                    s += '</tbody>';
                    s += '</table>';
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