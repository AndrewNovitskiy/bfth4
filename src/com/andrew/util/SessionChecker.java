package com.andrew.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.andrew.constant.CommonConstant.ADMIN;
import static com.andrew.constant.CommonConstant.USER;


public class SessionChecker {

    public static boolean adminInSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute(ADMIN) != null;
    }

    public static boolean userInSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute(USER) != null;
    }
    
}
