package com.andrew.command.user;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.UserDao;
import com.andrew.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.util.AttributeConstant.ADMIN;
import static com.andrew.util.AttributeConstant.FAIL;
import static com.andrew.util.AttributeConstant.USER;
import static com.andrew.util.JspPathConstant.USER_PROFILE_JSP;
import static com.andrew.util.JspPathConstant.REGISTRATION_JSP;

public class RegistrationCommand implements Command {

    private static final Logger log = Logger.getLogger(RegistrationCommand.class);
    private UserDao dao;

    public RegistrationCommand(){
        super();
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
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");

        if (dao.checkLogin(login)) {
            dao.addUser(login, password, name, surname, telephone, email);
            User user = dao.takeUser(login, password);

            session.setAttribute(USER, user);
            return new ForwardAction(USER_PROFILE_JSP);
        } else {
            request.setAttribute(FAIL, true);
            return new ForwardAction(REGISTRATION_JSP);
        }
    }
}
