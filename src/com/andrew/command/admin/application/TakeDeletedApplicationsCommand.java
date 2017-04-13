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
import java.io.IOException;
import java.util.ArrayList;

import static com.andrew.util.JspPathConstant.ADMIN_ALL_APPLICATIONS_JSP;
import static com.andrew.util.JspPathConstant.ADMIN_DELETED_APPLICATIONS_JSP;

/**
 * Created by Andrew on 12.04.2017.
 */
public class TakeDeletedApplicationsCommand implements Command {

    private static final Logger LOG = Logger.getLogger(TakeDeletedApplicationsCommand.class);
    private ApplicationDao dao;

    public TakeDeletedApplicationsCommand() {
        super();
        dao = new ApplicationDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Application> applications = dao.takeDeletedApplications();
        request.setAttribute("applications", applications);
        return new ForwardAction(ADMIN_DELETED_APPLICATIONS_JSP);
    }
}