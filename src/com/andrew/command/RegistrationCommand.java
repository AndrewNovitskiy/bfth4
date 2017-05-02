package com.andrew.command;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.dao.UserDao;
import com.andrew.entity.User;
import com.andrew.validator.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.constant.AttributeConstant.*;
import static com.andrew.constant.JspPathConstant.REGISTRATION_JSP;
import static com.andrew.constant.JspPathConstant.USER_PROFILE_JSP;

public class RegistrationCommand implements Command {

    private UserDao dao;

    public RegistrationCommand(){
        dao = new UserDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        if (session.getAttribute(USER) != null){
            session.removeAttribute(USER);
        }
        if (session.getAttribute(ADMIN) != null){
            session.removeAttribute(ADMIN);
        }

        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        String passwordDuplicate = request.getParameter("checkpass");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");

        if (Validator.validateRegistrationData(login, password, passwordDuplicate, name, surname, telephone, email)) {
            if (dao.checkLogin(login)) {
                dao.addUser(login, password, name, surname, telephone, email);
                User user = dao.takeUser(login, password);
                session.setAttribute(USER, user);
                return new ForwardAction(USER_PROFILE_JSP);
            } else {
                request.setAttribute(LOGIN_FAIL, true);
                return new ForwardAction(REGISTRATION_JSP);
            }
        } else {
            request.setAttribute(VALIDATION_FAIL, true);
            return new ForwardAction(REGISTRATION_JSP);
        }



    }
}
