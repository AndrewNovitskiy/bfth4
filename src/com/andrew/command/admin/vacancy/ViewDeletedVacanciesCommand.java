package com.andrew.command.admin.vacancy;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.VacancyDao;
import com.andrew.entity.Vacancy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.andrew.constant.JspPathConstant.ADMIN_DELETED_VACANCIES_JSP;

/**
 * Created by Andrew on 12.04.2017.
 */
public class ViewDeletedVacanciesCommand implements Command {

    private VacancyDao dao;

    public ViewDeletedVacanciesCommand() {
        dao = new VacancyDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Vacancy> vacancies = dao.findDeletedVacancies();
        request.setAttribute("vacancies", vacancies);
        return new ForwardAction(ADMIN_DELETED_VACANCIES_JSP);
    }
}
