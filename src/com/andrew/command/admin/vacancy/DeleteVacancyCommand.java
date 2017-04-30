package com.andrew.command.admin.vacancy;

import com.andrew.action.Action;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import com.andrew.dao.ApplicationDao;
import com.andrew.dao.MessageDao;
import com.andrew.dao.VacancyDao;
import com.andrew.entity.Admin;
import com.andrew.util.MessagePreparator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static com.andrew.constant.AttributeConstant.ADMIN;
import static com.andrew.constant.CommandPathConstant.ADMIN_ALL_VACANCIES_COMMAND;
import static com.andrew.constant.MessageConstant.MESSAGE_VACANCY_DELETED_TITLE;

/**
 * Created by Andrew on 12.04.2017.
 */
public class DeleteVacancyCommand implements Command {

    private VacancyDao vacancyDao;
    private ApplicationDao applicationDao;
    private MessageDao messageDao;

    public DeleteVacancyCommand() {
        super();
        vacancyDao = new VacancyDao();
        applicationDao = new ApplicationDao();
        messageDao = new MessageDao();
    }
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int vacancyId = Integer.parseInt(request.getParameter("id"));
        String vacancyPosition = request.getParameter("vacancy_position");

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute(ADMIN);

        vacancyDao.deleteVacancy(vacancyId);

        ArrayList<Integer> idUsers = applicationDao.getIdUsersByVacancyId(vacancyId);

        for (Integer applicantId : idUsers){
            messageDao.putMessage(admin.getIdAdmin(), applicantId, MESSAGE_VACANCY_DELETED_TITLE,
                    MessagePreparator.prepareVacancyDeletedMessage(vacancyPosition));
        }

        applicationDao.deleteApplicationsOfVacancy(vacancyId);

        return new RedirectAction(ADMIN_ALL_VACANCIES_COMMAND);
    }
}
