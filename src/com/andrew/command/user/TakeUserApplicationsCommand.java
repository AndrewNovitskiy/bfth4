package com.andrew.command.user;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.ApplicationDao;
import com.andrew.entity.Application;
import com.andrew.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static com.andrew.constant.AttributeConstant.USER;
import static com.andrew.constant.JspPathConstant.USER_APPLICATIONS_JSP;

/**
 * Created by Andrew on 15.04.2017.
 */
public class TakeUserApplicationsCommand implements Command {

    private ApplicationDao dao;

    public TakeUserApplicationsCommand() {
        super();
        dao = new ApplicationDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);

        ArrayList<Application> applications = dao.takeApplicationsOfUser(user.getApplicantId());

        request.setAttribute("applications", applications);
        return new ForwardAction(USER_APPLICATIONS_JSP);
    }
}
