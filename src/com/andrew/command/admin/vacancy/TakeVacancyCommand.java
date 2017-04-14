package com.andrew.command.admin.vacancy;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.VacancyDao;
import com.andrew.entity.Admin;
import com.andrew.entity.Vacancy;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.util.AttributeConstant.ADMIN;
import static com.andrew.util.JspPathConstant.ADMIN_VACANCY_JSP;
import static com.andrew.util.JspPathConstant.VACANCY_JSP;

/**
 * Created by Andrew on 06.04.2017.
 */
public class TakeVacancyCommand implements Command {

    private static final Logger log = Logger.getLogger(TakeVacancyCommand.class);
    private VacancyDao dao;

    public TakeVacancyCommand() {
        super();
        dao = new VacancyDao();
    }


    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer vacancyId = Integer.parseInt(request.getParameter("id"));
        Vacancy vacancy = dao.takeVacancyById(vacancyId);
        request.setAttribute("vacancy", vacancy);

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute(ADMIN);

        if(admin != null){
            return new ForwardAction(ADMIN_VACANCY_JSP);
        } else {
            return new ForwardAction(VACANCY_JSP);
        }


    }
}
