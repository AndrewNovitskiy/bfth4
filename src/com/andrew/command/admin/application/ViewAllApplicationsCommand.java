package com.andrew.command.admin.application;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.ApplicationDao;
import com.andrew.entity.Application;
import com.andrew.util.SessionChecker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import static com.andrew.constant.JspPathConstant.ADMIN_ALL_APPLICATIONS_JSP;
import static com.andrew.constant.JspPathConstant.LOG_IN_ADMIN_JSP;

/**
 * Created by Andrew on 03.04.2017.
 */
public class ViewAllApplicationsCommand implements Command {

    private ApplicationDao dao;

    public ViewAllApplicationsCommand() {
        dao = new ApplicationDao();
    }

    public Action execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        if(SessionChecker.adminInSession(request)) {
            ArrayList<Application> applications = dao.findAllApplications();
            request.setAttribute("applications", applications);
            return new ForwardAction(ADMIN_ALL_APPLICATIONS_JSP);
        } else {
            return new ForwardAction(LOG_IN_ADMIN_JSP);
        }
    }
}
