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
import java.io.IOException;
import java.util.ArrayList;

import static com.andrew.constant.JspPathConstant.ADMIN_DELETED_VACANCIES_JSP;

/**
 * Created by Andrew on 12.04.2017.
 */
public class TakeDeletedVacanciesCommand implements Command {

    private static final Logger log = Logger.getLogger(TakeDeletedVacanciesCommand.class);
    private VacancyDao dao;

    public TakeDeletedVacanciesCommand() {
        super();
        dao = new VacancyDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Vacancy> vacancies = dao.takeDeletedVacancies();
        request.setAttribute("vacancies", vacancies);
        return new ForwardAction(ADMIN_DELETED_VACANCIES_JSP);
    }
}
