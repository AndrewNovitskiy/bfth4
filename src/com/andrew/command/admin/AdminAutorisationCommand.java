package com.andrew.command.admin;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import com.andrew.dao.AdminDao;
import com.andrew.entity.Admin;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.util.AttributeConstant.ADMIN;
import static com.andrew.util.AttributeConstant.FAIL;
import static com.andrew.util.AttributeConstant.USER;
import static com.andrew.util.JspPathConstant.ADMIN_CONTROL_PANEL_JSP;
import static com.andrew.util.JspPathConstant.LOG_IN_ADMIN_JSP;

/**
 * Created by Andrew on 02.04.2017.
 */
public class AdminAutorisationCommand implements Command {

    private static final Logger log = Logger.getLogger(AdminAutorisationCommand.class);
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
