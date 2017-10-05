console.log("connect");
$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function (e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});


$("#saveCoordinator").click(function () {

    // $("#registrationCoordinators").reset();
    // $('input').empty();

    let firstName = $('#coordinatorFirstName').val();
    let lastName = $('#coordinatorLastName').val();
    let email = $('#coordinatorEmail').val();
    let telephone = $('#coordinatorTelephone').val();
    let username = $('#coordinatorUsername').val();
    let password = $('#coordinatorPassword').val();


    let coordinator = {
        firstName: firstName,
        lastName: lastName,
        email: email,
        telephone: telephone,
        username: username,
        password: password
    };


    $('input').val('');
    console.log($('input'));
    console.log(coordinator);
    $.ajax({

        url: '/admin/coordinators/createCoordinator',
        type: 'post',
        data: JSON.stringify(coordinator),
        contentType: 'application/json',
        success: function (coordinatorResponse) {
            console.log();
            let $tr = $("<tr/>");



            for (let property in coordinator) {
            console.log(property);
                let $td = $("<td/>", {text: coordinator[property]});
                $($tr).append($td);
            }
            $("#coordinators").append($tr);
            console.log("successful registration coordinator " + coordinatorResponse.firstName + " " + coordinatorResponse.lastName);

        },
        error: function () {
            console.log("Error")
        }
    });

});


$("#coordinators a").click(function () {


    let idOfCoordinator = $(this).attr("id");
    let splitArrary = idOfCoordinator.split("-");
    let id = splitArrary[1];
    console.log(idOfCoordinator);
    // console.log($(this).parent().parent().remove());
    $.ajax({
        url: `/admin/coordinators/remove-${id}`,
        type: 'get',
        success: function () {
            console.log(" successful remove coordinator ");
        },
        error: function () {
            console.log("error output data");
        }
    });

});
