$(document).ready(function () {
    var max_fields = 10;
    var wrapper = $(".input_fields_wrap");
    var add_button = $(".add_field_button");
    var x = 1;
    $(add_button).click(function (e) {
        e.preventDefault();
        if (x < max_fields) {
            x++;
            $(wrapper).append('' +
                '<div>' +
                '<table class="table table-hover"><tbody><tr>' +
                '<td><input type="text" pattern="^([0|\\+[0-9]{1,5})?([1-9][0-9]{9})$" name="mytext[]" class="form-control" list="phones" value="+7(999)..."></td>' +
                '<td><select name="Type[]" placeholder="Type"class="form-control"> <option>home</option> <option>job</option> </select></td>' +
                '<td><a href="#" class="remove_field"><span class="glyphicon glyphicon-remove"></span></button></a></td>' +
                '</tr></tbody></table>' +
                '</div>');
        }
    });

    $(wrapper).on("click", ".remove_field", function (e) {
        e.preventDefault();
        $(this).parent('td').parent('tr').parent('tbody').parent('table').parent('div').remove();
        x--;
    })
});

$(document).ready(function () {
    var max_fields2 = 10;
    var wrapper2 = $(".input_fields_wrap2");
    var add_button2 = $(".add_field_button2");
    var x2 = 1;
    $(add_button2).click(function (e2) {
        e2.preventDefault();
        if (x2 < max_fields2) {
            x2++;
            $(wrapper2).append('' +
                '<div>' +
                '<table class="table table-hover"><tbody><tr>' +
                '<td><input type="text" name="mytext2[]" class="form-control" list="addresses"/></td>' +
                '<td><select name="Type2[]" placeholder="Type"class="form-control"> <option>home</option> <option>job</option> </select></td>' +
                '<td><a href="#" class="remove_field2"><span class="glyphicon glyphicon-remove"></span></button></a></td>' +
                '</tr></tbody></table>' +
                '</div>');
        }
    });
    $(wrapper2).on("click", ".remove_field2", function (e2) {
        e2.preventDefault();
        $(this).parent('td').parent('tr').parent('tbody').parent('table').parent('div').remove();
        x2--;
    })
});