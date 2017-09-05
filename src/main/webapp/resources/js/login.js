$(function() {


    $("#click-forgot-password").click(function (e) {
            e.preventDefault();
            $("#modal-forgot-password").modal('show');
        }
    )
    $("#send-forgot-password").click(function (e) {
        e.preventDefault();
        $("#modal-forgot-password").modal('hide');
        $.ajax({
            type: "POST",
            data: {sendEmail: $("#input-email-forgot-password").val()},
            url: "sendPassword",
            success: function (resp) {
                if (resp) {
                    $("#message-success-send-email").fadeIn(500);
                    setTimeout(function () {
                        $("#message-success-send-email").fadeOut(1000)
                    }, 2000);
                } else {
                    $("#message-fail-send-email").fadeIn(500);
                    setTimeout(function () {
                        $("#message-fail-send-email").fadeOut(1000)
                    }, 2000);
                }
            }
        })
    })



    $('a.remove-address-panel').click(function (e) {
        e.preventDefault();
        var addressId = $(this).data('seq');
        var panelId = "#panel-address-" + addressId;
        $(panelId).slideUp();//400mc
        $.ajax({
            type: "POST",
            url: "address/remove/" + addressId
        })
    })

});


function checkParams() {
    var loginError = document.getElementById('loginExists').innerHTML;
    var emailError = document.getElementById('emailExists').innerHTML;

    if(loginError.length == 0 && emailError.length == 0) {
        $('#submit-registration').removeAttr('disabled');
    } else {
        $('#submit-registration').attr('disabled', 'disabled');
    }
}

function onBlurEmailFunction(obj){
    var email = obj.value;
    $.ajax({
        type: "POST",
        data: {email : email},
        url: "registration/findEmail/",
        success: function (msg) {
            $("#emailExists").html(msg);
        }
    })
    checkParams();
};

function onBlurLoginFunction(obj) {
    var login = obj.value;
    $.ajax({
        type: "POST",
        data: {login : login},
        url: "registration/findLogin/",
        success: function (msg) {
            $("#loginExists").text(msg);
        }
    })
    checkParams();
}




