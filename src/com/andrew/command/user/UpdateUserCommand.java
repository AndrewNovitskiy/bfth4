package com.andrew.command.user;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import com.andrew.dao.UserDao;
import com.andrew.entity.User;
import com.andrew.validator.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.constant.CommonConstant.USER;
import static com.andrew.constant.CommonConstant.VALIDATION_FAIL;
import static com.andrew.constant.CommandPathConstant.PROFILE_COMMAND;
import static com.andrew.constant.JspPathConstant.EDIT_PROFILE_JSP;

/**
 * Created by Andrew on 14.04.2017.
 */
public class UpdateUserCommand implements Command {

    private UserDao dao;

    public UpdateUserCommand() {
        dao = new UserDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String resume = request.getParameter("resume");

        if (Validator.validateUserData(name, surname, telephone, email)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(USER);

            dao.updateUser(user.getApplicantId(), name, surname, telephone, email, resume);
            User updatedUser = dao.findUserById(user.getApplicantId());

            session.removeAttribute(USER);
            session.setAttribute(USER, updatedUser);
            return new RedirectAction(PROFILE_COMMAND);
        } else {
            request.setAttribute(VALIDATION_FAIL, true);
            return new ForwardAction(EDIT_PROFILE_JSP);
        }

    }
}
