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
import java.io.IOException;

import static com.andrew.constant.JspPathConstant.ADMIN_EDIT_VACANCY_JSP;
import static com.andrew.constant.JspPathConstant.LOG_IN_ADMIN_JSP;

/**
 * Created by Andrew on 09.04.2017.
 */
public class EditVacancyCommand implements Command {

    private VacancyDao dao;

    public EditVacancyCommand() {
        dao = new VacancyDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(SessionChecker.adminInSession(request)) {
            Vacancy vacancy = dao.findVacancyById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("vacancy", vacancy);
            return new ForwardAction(ADMIN_EDIT_VACANCY_JSP);
        } else {
            return new ForwardAction(LOG_IN_ADMIN_JSP);
        }
    }
}
