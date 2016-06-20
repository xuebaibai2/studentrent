$(function () {
    $(".alert").each(function () {
        if ($(this).contents("p").html() === "") {
            $(this).hide();
        } else {
            $(this).show();
        }
    });
    pw_validate();
});

function pw_validate() {
    $("#password").keyup(checkPasswordMatch);
    $("#c_password").keyup(checkPasswordMatch);
    $("#create_form").submit(formSubmit);
}

function formSubmit() {
    return $("#password").val() == $("#c_password").val()
}

function checkPasswordMatch() {
    if ($("#password").val() != $("#c_password").val()){
        $(".c_p_m").show();
        $("#c_password_msg:last").text("Passwords do not match.");
    }else{
        $(".c_p_m").hide();
    }
}



