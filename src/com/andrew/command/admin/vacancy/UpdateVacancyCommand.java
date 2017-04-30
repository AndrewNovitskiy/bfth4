package com.andrew.command.admin.vacancy;

import com.andrew.action.Action;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import com.andrew.dao.VacancyDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.andrew.constant.CommandPathConstant.ADMIN_ALL_VACANCIES_COMMAND;

/**
 * Created by Andrew on 09.04.2017.
 */
public class UpdateVacancyCommand implements Command {

    private VacancyDao dao;

    public UpdateVacancyCommand() {
        dao = new VacancyDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int vacancyId = Integer.parseInt(request.getParameter("id"));
        String position = request.getParameter("position");
        int experience = Integer.parseInt(request.getParameter("experience"));
        int salary = Integer.parseInt(request.getParameter("salary"));
        String info = request.getParameter("info");
        dao.updateVacancy(vacancyId, position, experience, salary, info);
        return new RedirectAction(ADMIN_ALL_VACANCIES_COMMAND);
    }
}
