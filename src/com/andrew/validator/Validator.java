package com.andrew.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final Pattern REGEX_FIRST_SYMBOL = Pattern.compile("^[a-zA-Z]");
    private static final Pattern REGEX_LOGIN = Pattern.compile("^[A-Za-z0-9_]+$");
    private static final Pattern REGEX_LOGIN_LENGTH = Pattern.compile("^.{5,20}$");
    private static final Pattern REGEX_PWD = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    private static final Pattern REGEX_PWD_LENGTH = Pattern.compile("^.{6,20}$");
    private static final Pattern REGEX_NAME = Pattern.compile("^[A-ZА-Яa-zа-я]+$");
    private static final Pattern REGEX_NAME_LENGTH = Pattern.compile("^.{2,20}$");
    private static final Pattern REGEX_TEL = Pattern.compile("^\\d+$");
    private static final Pattern REGEX_TEL_LENGTH = Pattern.compile("^.{9,15}$");
    private static final Pattern REGEX_EMAIL = Pattern.compile("^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$");


    public static boolean validateTheRegistrationData(String login, String password, String passwordDuplicate, String name, String surname, String telephone, String email) {
        if (validateLogin(login)) {
            if (validatePassword(password)) {
                if (password.equals(passwordDuplicate)) {
                    if (validateName(name.trim())) {
                        if (validateName(surname.trim())) {
                            if (validateTelephone(telephone.trim())) {
                                if (validateEmail(email.trim())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean validateTheUserData(String name, String surname, String telephone, String email) {
        if (validateName(name.trim())) {
            if (validateName(surname.trim())) {
                if (validateTelephone(telephone.trim())) {
                    if (validateEmail(email.trim())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean validateLogin(String login) {
        Matcher matcher = REGEX_FIRST_SYMBOL.matcher(login);
        if (matcher.find()) {
            matcher = REGEX_LOGIN.matcher(login);
            if (matcher.find()) {
                matcher = REGEX_LOGIN_LENGTH.matcher(login);
                if (matcher.find()) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean validatePassword(String password) {
        Matcher matcher = REGEX_PWD.matcher(password);
        if (matcher.find()) {
            matcher = REGEX_PWD_LENGTH.matcher(password);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }


    private static boolean validateName(String name) {
        Matcher matcher = REGEX_NAME.matcher(name);
        if (matcher.find()) {
            matcher = REGEX_NAME_LENGTH.matcher(name);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }


    private static boolean validateTelephone(String telephone) {
        Matcher matcher = REGEX_TEL.matcher(telephone);
        if (matcher.find()) {
            matcher = REGEX_TEL_LENGTH.matcher(telephone);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }


    private static boolean validateEmail(String email) {
        Matcher matcher = REGEX_EMAIL.matcher(email);
        if (matcher.find()) {
            return true;
        }
        return false;
    }


}
