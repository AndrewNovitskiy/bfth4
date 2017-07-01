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
import java.io.IOException;
import java.util.ArrayList;

import static com.andrew.constant.JspPathConstant.ADMIN_ALL_DELETED_VACANCY_APPLICATIONS_JSP;
import static com.andrew.constant.JspPathConstant.LOG_IN_ADMIN_JSP;

/**
 * Created by Andrew on 15.04.2017.
 */
public class ViewDeletedApplicationsOfVacancyCommand implements Command {

    private ApplicationDao dao;

    public ViewDeletedApplicationsOfVacancyCommand() {
        dao = new ApplicationDao();
    }
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(SessionChecker.adminInSession(request)) {
            Integer vacancyId = Integer.parseInt(request.getParameter("id"));

            ArrayList<Application> applications = dao.findDeletedApplicationsOfVacancy(vacancyId);

            request.setAttribute("position", request.getParameter("position"));
            request.setAttribute("applications", applications);
            return new ForwardAction(ADMIN_ALL_DELETED_VACANCY_APPLICATIONS_JSP);
        } else {
            return new ForwardAction(LOG_IN_ADMIN_JSP);
        }
    }
}
