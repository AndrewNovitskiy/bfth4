package com.andrew.command.admin;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import com.andrew.dao.AdminDao;
import com.andrew.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.constant.AttributeConstant.*;
import static com.andrew.constant.JspPathConstant.ADMIN_CONTROL_PANEL_JSP;
import static com.andrew.constant.JspPathConstant.LOG_IN_ADMIN_JSP;

/**
 * Created by Andrew on 02.04.2017.
 */
public class AdminAutorisationCommand implements Command {

    private AdminDao dao;

    public AdminAutorisationCommand() {
        super();
        dao = new AdminDao();
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

        if (dao.checkAdmin(login, password)) {
            Admin admin = dao.takeAdmin(login, password);
            session.setAttribute(ADMIN, admin);
            return new RedirectAction(ADMIN_CONTROL_PANEL_JSP);

        } else {
            request.setAttribute(FAIL, true);
            return new ForwardAction(LOG_IN_ADMIN_JSP);

        }

    }
}
