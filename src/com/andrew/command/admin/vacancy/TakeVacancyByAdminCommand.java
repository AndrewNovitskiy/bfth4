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

import static com.andrew.constant.JspPathConstant.ADMIN_VACANCY_JSP;

/**
 * Created by Andrew on 06.04.2017.
 */
public class TakeVacancyByAdminCommand implements Command {

    private VacancyDao dao;

    public TakeVacancyByAdminCommand() {
        dao = new VacancyDao();
    }


    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer vacancyId = Integer.parseInt(request.getParameter("id"));
        Vacancy vacancy = dao.takeVacancyById(vacancyId);
        request.setAttribute("vacancy", vacancy);

        return new ForwardAction(ADMIN_VACANCY_JSP);
    }
}
