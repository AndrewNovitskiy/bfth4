package com.andrew.command.user;

import com.andrew.action.Action;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import com.andrew.dao.ApplicationDao;
import com.andrew.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.constant.AttributeConstant.USER;
import static com.andrew.constant.CommandPathConstant.APPLICATIONS_COMMAND;

/**
 * Created by Andrew on 16.04.2017.
 */
public class UserDeleteApplicationCommand implements Command {

    private ApplicationDao dao;

    public UserDeleteApplicationCommand() {
        dao = new ApplicationDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        Integer vacancyId = Integer.parseInt(request.getParameter("vacancyId"));

        dao.deleteApplication(user.getApplicantId(), vacancyId);
        return new RedirectAction(APPLICATIONS_COMMAND);
    }
}
