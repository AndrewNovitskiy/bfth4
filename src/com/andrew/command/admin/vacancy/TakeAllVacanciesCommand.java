package com.andrew.command.admin.vacancy;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.VacancyDao;
import com.andrew.entity.Vacancy;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import static com.andrew.util.JspPathConstant.ADMIN_ALL_VACANCIES_JSP;

/**
 * Created by Andrew on 02.04.2017.
 */
public class TakeAllVacanciesCommand implements Command {
    private static final Logger log = Logger.getLogger(TakeAllVacanciesCommand.class);
    private VacancyDao dao;

    public TakeAllVacanciesCommand() {
        super();
        dao = new VacancyDao();
    }

    public Action execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        ArrayList<Vacancy> vacancies = dao.takeAllVacancies();
        request.setAttribute("vacancies", vacancies);
        return new ForwardAction(ADMIN_ALL_VACANCIES_JSP);
    }
}
