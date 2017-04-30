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

import static com.andrew.constant.JspPathConstant.ADMIN_EDIT_VACANCY_JSP;

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
        Vacancy vacancy = dao.takeVacancyById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("vacancy", vacancy);
        return new ForwardAction(ADMIN_EDIT_VACANCY_JSP);
    }
}
