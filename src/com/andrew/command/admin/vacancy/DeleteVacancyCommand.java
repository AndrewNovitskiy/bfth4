package com.andrew.command.admin.vacancy;

import com.andrew.action.Action;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import com.andrew.dao.ApplicationDao;
import com.andrew.dao.VacancyDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.andrew.util.CommandPathConstant.ADMIN_ALL_VACANCIES_COMMAND;

/**
 * Created by Andrew on 12.04.2017.
 */
public class DeleteVacancyCommand implements Command {

    private static final Logger log = Logger.getLogger(DeleteVacancyCommand.class);
    private VacancyDao vacancyDao;
    private ApplicationDao applicationDao;

    public DeleteVacancyCommand() {
        super();
        vacancyDao = new VacancyDao();
        applicationDao = new ApplicationDao();
    }
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int vacancyId = Integer.parseInt(request.getParameter("id"));
        vacancyDao.deleteVacancy(vacancyId);
        applicationDao.deleteApplicationsOfVacancy(vacancyId);
        return new RedirectAction(ADMIN_ALL_VACANCIES_COMMAND);
    }
}
