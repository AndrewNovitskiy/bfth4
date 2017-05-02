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

import static com.andrew.constant.AttributeConstant.USER;
import static com.andrew.constant.AttributeConstant.VALIDATION_FAIL;
import static com.andrew.constant.CommandPathConstant.PROFILE_COMMAND;
import static com.andrew.constant.JspPathConstant.CHANGE_PASSWORD_JSP;

/**
 * Created by Andrew on 02.05.2017.
 */
public class ChangePasswordCommand implements Command {

    private UserDao dao;

    public ChangePasswordCommand() {
        dao = new UserDao();
    }


    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String newPassword = request.getParameter("new_password");
        String duplicate = request.getParameter("confirmation");



        if (Validator.validateNewPassword(newPassword, duplicate)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(USER);

            dao.changeUserPassword(user.getApplicantId(), newPassword);
            User updatedUser = dao.takeUserById(user.getApplicantId());

            session.removeAttribute(USER);

            session.setAttribute(USER, updatedUser);

            return new RedirectAction(PROFILE_COMMAND);
        } else {
            request.setAttribute(VALIDATION_FAIL, true);
            return new ForwardAction(CHANGE_PASSWORD_JSP);
        }


    }
}
