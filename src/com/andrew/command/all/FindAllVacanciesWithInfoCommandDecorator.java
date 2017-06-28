package com.andrew.command.all;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.command.CommandFactory;
import com.andrew.dao.VacancyDao;
import com.andrew.entity.Vacancy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import static com.andrew.constant.JspPathConstant.VACANCIES_JSP;

public class FindAllVacanciesWithInfoCommandDecorator implements CommandFactory {

    public Command getCommand(){
        return new FindAllVacanciesWithInfoCommand();
    }

    public class FindAllVacanciesWithInfoCommand implements Command {

        private VacancyDao dao;

        public FindAllVacanciesWithInfoCommand() {
            dao = new VacancyDao();
        }

        @Override
        public Action execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
            ArrayList<Vacancy> vacancies = dao.findAllVacanciesWithInfo();
            request.setAttribute("vacancies", vacancies);
            return new ForwardAction(VACANCIES_JSP);
        }
    }


}
