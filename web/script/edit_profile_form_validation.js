function formValidation() {

    var result = true;

    var name = document.update_profile.name.value.trim();
    var surname = document.update_profile.surname.value.trim();
    var telephone = document.update_profile.telephone.value.trim();
    var email = document.update_profile.email.value.trim();

    var FILL_FIELD = "Fill This Field",
        BAD_EMAIL = "Incorrect email",
        BAD_TEL = "Use only digits",
        BAD_TEL_LENGTH = "Length must be from 9 to 15",
        BAD_NAME = "Use 'A-z'",
        BAD_NAME_LENGTH = "Length of this field must be from 2 to 20";


    var errNameLabel = document.getElementById("error-name"),
        errSurnameLabel = document.getElementById("error-surname"),
        errTelLabel = document.getElementById("error-telephone"),
        errEmailLabel = document.getElementById("error-email");

    errNameLabel.innerHTML = "";
    errSurnameLabel.innerHTML = "";
    errTelLabel.innerHTML = "";
    errEmailLabel.innerHTML = "";

    var REG_NAME = /^[A-Za-z]+$/,
        REG_NAME_LENGTH = /^.{2,20}$/,

        REG_TEL = /^\d+$/,
        REG_TEL_LENGTH = /^.{9,15}$/,

        REG_EMAIL = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;


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
