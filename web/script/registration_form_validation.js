function formValidation() {

    var result = true;

    var login = document.registration.login.value;
    var pass = document.registration.pass.value;
    var checkpass = document.registration.checkpass.value;
    var name = document.registration.name.value.trim();
    var surname = document.registration.surname.value.trim();
    var telephone = document.registration.telephone.value.trim();
    var email = document.registration.email.value.trim();

    var FILL_FIELD = "Fill This Field",
        PWD_NOT_EQUAL = "Password Not Equal",
		BAD_FIRST_SYMBOL = "Incorrect First Symbol. A-z required",
        BAD_LOGIN = "Use 'A-z, 0-9, _'",
        BAD_LOGIN_LENGTH = "Length of Login must be from 5 to 20",
        BAD_PWD_LENGTH = "Length of Password must be from 6 to 20",
        BAD_PWD = "Password must contain at least one digit, letter in lower & upper case",
        BAD_EMAIL = "Incorrect email",
        BAD_TEL = "Use only digits",
        BAD_TEL_LENGTH = "Length must be from 9 to 15",
        BAD_NAME = "Use 'A-z'",
        BAD_NAME_LENGTH = "Length of this field must be from 2 to 20";


        var errLoginLabel = document.getElementById("error-login"),
            errPassLabel = document.getElementById("error-pass"),
            errCheckPassLabel = document.getElementById("error-checkpass"),
            errNameLabel = document.getElementById("error-name"),
            errSurnameLabel = document.getElementById("error-surname"),
            errTelLabel = document.getElementById("error-telephone"),
            errEmailLabel = document.getElementById("error-email");

        errLoginLabel.innerHTML = "";
        errPassLabel.innerHTML = "";
        errCheckPassLabel.innerHTML = "";
        errNameLabel.innerHTML = "";
        errSurnameLabel.innerHTML = "";
        errTelLabel.innerHTML = "";
        errEmailLabel.innerHTML = "";

        var REG_FIRST_SYMBOL = /^[a-zA-Z]/,
            REG_LOGIN = /^[A-Za-z0-9_]+$/,
            REG_LOGIN_LENGTH = /^.{5,20}$/,

            REG_PWD = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).+$/,
            REG_PWD_LENGTH = /^.{6,20}$/,

            REG_NAME = /^[A-Za-z]+$/,
            REG_NAME_LENGTH = /^.{2,20}$/,

            REG_TEL = /^\d+$/,
            REG_TEL_LENGTH = /^.{9,15}$/,

            REG_EMAIL = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;


        if (!login) {
			errLoginLabel.innerHTML = FILL_FIELD;
			result = false;
		} else {
            if (!REG_FIRST_SYMBOL.test(login)) {
    			errLoginLabel.innerHTML = BAD_FIRST_SYMBOL;
    			result = false;
    		} else {
                if (!REG_LOGIN.test(login)) {
        			errLoginLabel.innerHTML = BAD_LOGIN;
        			result = false;
                } else {
                    if (!REG_LOGIN_LENGTH.test(login)) {
            			errLoginLabel.innerHTML = BAD_LOGIN_LENGTH;
            			result = false;
                    }
                }
            }
        }

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

        if (!name) {
			errNameLabel.innerHTML = FILL_FIELD;
			result = false;
		} else {
            if (!REG_NAME.test(name)) {
                errNameLabel.innerHTML = BAD_NAME;
                result = false;
            } else {
                if (!REG_NAME_LENGTH.test(name)) {
                    errNameLabel.innerHTML = BAD_NAME_LENGTH;
                    result = false;
                }
            }
        }

        if (!surname) {
			errSurnameLabel.innerHTML = FILL_FIELD;
			result = false;
		} else {
            if (!REG_NAME.test(surname)) {
                errSurnameLabel.innerHTML = BAD_NAME;
                result = false;
            } else {
                if (!REG_NAME_LENGTH.test(surname)) {
                    errSurnameLabel.innerHTML = BAD_NAME_LENGTH;
                    result = false;
                }
            }
        }

        if (!telephone) {
			errTelLabel.innerHTML = FILL_FIELD;
			result = false;
		} else {
            if (!REG_TEL.test(telephone)) {
                errTelLabel.innerHTML = BAD_TEL;
                result = false;
            } else {
                if (!REG_TEL_LENGTH.test(telephone)) {
                    errTelLabel.innerHTML = BAD_TEL_LENGTH;
                    result = false;
                }
            }
        }

        if (!email) {
			errEmailLabel.innerHTML = FILL_FIELD;
			result = false;
		} else {
            if (!REG_EMAIL.test(email)) {
                errEmailLabel.innerHTML = BAD_EMAIL;
                result = false;
            }
        }

        return result;

}
