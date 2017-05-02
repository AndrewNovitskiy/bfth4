function formValidation() {

    var result = true;

    var pass = document.change_pwd.new_password.value;
    var checkpass = document.change_pwd.confirmation.value;

    var FILL_FIELD = "Fill This Field",
        PWD_NOT_EQUAL = "Password Not Equal",
        BAD_PWD_LENGTH = "Length of Password must be from 6 to 20",
        BAD_PWD = "Password must contain at least one digit, letter in lower & upper case";

    var errPassLabel = document.getElementById("error-pass"),
        errCheckPassLabel = document.getElementById("error-checkpass");

    errPassLabel.innerHTML = "";
    errCheckPassLabel.innerHTML = "";

    var REG_PWD = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).+$/,
        REG_PWD_LENGTH = /^.{6,20}$/;


    if (!pass) {
        errPassLabel.innerHTML = FILL_FIELD;
        result = false;
    } else {
        if (!REG_PWD.test(pass)) {
            errPassLabel.innerHTML = BAD_PWD;
            result = false;
        } else {
            if (!REG_PWD_LENGTH.test(pass)) {
                errPassLabel.innerHTML = BAD_PWD_LENGTH;
                result = false;
            }
        }
    }

    if (!checkpass) {
        errCheckPassLabel.innerHTML = FILL_FIELD;
        result = false;
    } else {
        if (pass !== checkpass) {
            errPassLabel.innerHTML = PWD_NOT_EQUAL;
            errCheckPassLabel.innerHTML = PWD_NOT_EQUAL;
            result = false;
        }
    }

    return result;

}
