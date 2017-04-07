package com.andrew.command.admin;

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

import static com.andrew.util.JspPathConstant.ADMIN_ALL_USER_APPLICATIONS_JSP;

/**
 * Created by Andrew on 07.04.2017.
 */
public class TakeApplicationsOfUserCommand implements Command {

    private static final Logger LOG = Logger.getLogger(TakeApplicationsOfUserCommand.class);
    private ApplicationDao dao;

    public TakeApplicationsOfUserCommand() {
        super();
        dao = new ApplicationDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer userId = Integer.parseInt(request.getParameter("id"));
        ArrayList<Application> applications = dao.takeApplicationsOfUser(userId);
        request.setAttribute("name", request.getParameter("name"));
        request.setAttribute("surname", request.getParameter("surname"));
        request.setAttribute("applications", applications);
        return new ForwardAction(ADMIN_ALL_USER_APPLICATIONS_JSP);
    }
}
