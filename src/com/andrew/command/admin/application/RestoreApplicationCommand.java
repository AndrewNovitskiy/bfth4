package com.andrew.command.admin.application;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import com.andrew.dao.ApplicationDao;
import com.andrew.util.SessionChecker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.andrew.constant.CommandPathConstant.ADMIN_ALL_APPLICATIONS_COMMAND;
import static com.andrew.constant.JspPathConstant.LOG_IN_ADMIN_JSP;

/**
 * Created by Andrew on 12.04.2017.
 */
public class RestoreApplicationCommand implements Command {

    private ApplicationDao dao;

    public RestoreApplicationCommand() {
        dao = new ApplicationDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(SessionChecker.adminInSession(request)) {
        int applicationId = Integer.parseInt(request.getParameter("id"));
        dao.restoreApplication(applicationId);
        return new RedirectAction(ADMIN_ALL_APPLICATIONS_COMMAND);
        } else {
            return new ForwardAction(LOG_IN_ADMIN_JSP);
        }
    }
}
