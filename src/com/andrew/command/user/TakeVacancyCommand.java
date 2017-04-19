package com.andrew.command.user;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.ApplicationDao;
import com.andrew.dao.VacancyDao;
import com.andrew.entity.User;
import com.andrew.entity.Vacancy;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.util.AttributeConstant.USER;
import static com.andrew.util.JspPathConstant.VACANCY_JSP;

/**
 * Created by Andrew on 16.04.2017.
 */
public class TakeVacancyCommand implements Command {
    private static final Logger log = Logger.getLogger(TakeVacancyCommand.class);
    private VacancyDao vacancyDao;
    private ApplicationDao applicationDao;

    public TakeVacancyCommand() {
        super();
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
            if(applicationDao.applicationExistsAndIsActive(user.getIdApplicant(), vacancyId)){
                request.setAttribute("app_exists", true);
            } else {
                request.setAttribute("app_exists", false);
            }
        }


        return new ForwardAction(VACANCY_JSP);



    }
}