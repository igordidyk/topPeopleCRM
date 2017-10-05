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
        success: function (coordinator) {

            console.log("successful registration coordinator " + coordinator.firstName + " " + coordinator.lastName);

        },
        error: function () {
            console.log("Error")
        }
    });

});


