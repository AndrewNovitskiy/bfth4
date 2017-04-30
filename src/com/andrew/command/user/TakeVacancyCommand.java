package com.andrew.command.user;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.ApplicationDao;
import com.andrew.dao.VacancyDao;
import com.andrew.entity.User;
import com.andrew.entity.Vacancy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.constant.AttributeConstant.USER;
import static com.andrew.constant.JspPathConstant.VACANCY_JSP;

/**
 * Created by Andrew on 16.04.2017.
 */
public class TakeVacancyCommand implements Command {

    private VacancyDao vacancyDao;
    private ApplicationDao applicationDao;

    public TakeVacancyCommand() {
        vacancyDao = new VacancyDao();
        applicationDao = new ApplicationDao();
    }


    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer vacancyId = Integer.parseInt(request.getParameter("id"));
        Vacancy vacancy = vacancyDao.takeVacancyById(vacancyId);
        request.setAttribute("vacancy", vacancy);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);

        if(user != null){
            if(applicationDao.applicationExistsAndIsActive(user.getApplicantId(), vacancyId)){
                request.setAttribute("app_exists", true);
            } else {
                request.setAttribute("app_exists", false);
            }
        }

        return new ForwardAction(VACANCY_JSP);

    }
}
