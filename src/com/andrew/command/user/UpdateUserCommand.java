package com.andrew.command.user;

import com.andrew.action.Action;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import com.andrew.dao.UserDao;
import com.andrew.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.util.AttributeConstant.USER;
import static com.andrew.util.CommandPathConstant.PROFILE_COMMAND;

/**
 * Created by Andrew on 14.04.2017.
 */
public class UpdateUserCommand implements Command {

    private UserDao dao;

    public UpdateUserCommand() {
        super();
        dao = new UserDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String resume = request.getParameter("resume");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);

        dao.updateUser(user.getIdApplicant(), name, surname, telephone, email, resume);
        User updatedUser = dao.takeUserById(user.getIdApplicant());

        session.removeAttribute(USER);

        session.setAttribute(USER, updatedUser);

        return new RedirectAction(PROFILE_COMMAND);
    }
}