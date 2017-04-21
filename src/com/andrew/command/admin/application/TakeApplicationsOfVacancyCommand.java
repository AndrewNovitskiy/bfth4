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

import static com.andrew.constant.JspPathConstant.ADMIN_ALL_VACANCY_APPLICATIONS_JSP;

/**
 * Created by Andrew on 07.04.2017.
 */
public class TakeApplicationsOfVacancyCommand implements Command {

    private static final Logger LOG = Logger.getLogger(TakeApplicationsOfVacancyCommand.class);
    private ApplicationDao dao;

    public TakeApplicationsOfVacancyCommand() {
        super();
        dao = new ApplicationDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer vacancyId = Integer.parseInt(request.getParameter("id"));
        ArrayList<Application> applications = dao.takeApplicationsOfVacancy(vacancyId);
        request.setAttribute("position", request.getParameter("position"));
        request.setAttribute("applications", applications);
        return new ForwardAction(ADMIN_ALL_VACANCY_APPLICATIONS_JSP);
    }
}
