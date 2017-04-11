package com.andrew.command.user;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import com.andrew.dao.UserDao;
import com.andrew.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.util.AttributeConstant.*;
import static com.andrew.util.CommandPathConstant.VACANCIES_COMMAND;
import static com.andrew.util.JspPathConstant.LOG_IN_JSP;

/**
 * Created by Andrew on 02.04.2017.
 */
public class AutorisationCommand implements Command {

    private static final Logger log = Logger.getLogger(AutorisationCommand.class);
    private UserDao dao;

    public AutorisationCommand() {
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
        String password = request.getParameter("password");

        if (dao.checkUser(login, password)) {
            User user = dao.takeUser(login, password);
            session.setAttribute(USER, user);
            return new RedirectAction(VACANCIES_COMMAND);

        } else {
            request.setAttribute(FAIL, true);
            return new ForwardAction(LOG_IN_JSP);
        }
    }
}
