package com.andrew.command.admin.vacancy;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import com.andrew.dao.VacancyDao;
import com.andrew.util.SessionChecker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.andrew.constant.CommandPathConstant.ADMIN_ALL_VACANCIES_COMMAND;
import static com.andrew.constant.JspPathConstant.LOG_IN_ADMIN_JSP;

/**
 * Created by Andrew on 12.04.2017.
 */
public class RestoreVacancyCommand implements Command {

    private VacancyDao dao;

    public RestoreVacancyCommand() {
        dao = new VacancyDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(SessionChecker.adminInSession(request)) {
            int vacancyId = Integer.parseInt(request.getParameter("id"));
            dao.restoreVacancy(vacancyId);
            return new RedirectAction(ADMIN_ALL_VACANCIES_COMMAND);
        } else {
            return new ForwardAction(LOG_IN_ADMIN_JSP);
        }
    }
}
