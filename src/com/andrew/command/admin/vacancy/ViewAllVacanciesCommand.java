package com.andrew.command.admin.vacancy;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.VacancyDao;
import com.andrew.entity.Vacancy;
import com.andrew.util.SessionChecker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import static com.andrew.constant.JspPathConstant.ADMIN_ALL_VACANCIES_JSP;
import static com.andrew.constant.JspPathConstant.LOG_IN_ADMIN_JSP;

/**
 * Created by Andrew on 02.04.2017.
 */
public class ViewAllVacanciesCommand implements Command {

    private VacancyDao dao;

    public ViewAllVacanciesCommand() {
        dao = new VacancyDao();
    }

    public Action execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        if(SessionChecker.adminInSession(request)) {
            ArrayList<Vacancy> vacancies = dao.findAllVacancies();
            request.setAttribute("vacancies", vacancies);
            return new ForwardAction(ADMIN_ALL_VACANCIES_JSP);
        } else {
            return new ForwardAction(LOG_IN_ADMIN_JSP);
        }
    }
}
