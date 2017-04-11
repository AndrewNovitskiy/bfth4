package com.andrew.command.admin.application;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.ApplicationDao;
import com.andrew.entity.Application;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import static com.andrew.util.JspPathConstant.ADMIN_ALL_APPLICATIONS_JSP;

/**
 * Created by Andrew on 03.04.2017.
 */
public class TakeAllApplicationsCommand implements Command {
    private static final Logger LOG = Logger.getLogger(TakeAllApplicationsCommand.class);
    private ApplicationDao dao;

    public TakeAllApplicationsCommand() {
        super();
        dao = new ApplicationDao();
    }

    public Action execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        ArrayList<Application> applications = dao.takeAllApplications();
        request.setAttribute("applications", applications);
        return new ForwardAction(ADMIN_ALL_APPLICATIONS_JSP);
    }
}
