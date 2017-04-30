package com.andrew.command.user;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.UserDao;
import com.andrew.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.constant.JspPathConstant.USER_PROFILE_JSP;

/**
 * Created by Andrew on 10.04.2017.
 */
public class ProfileCommand implements Command {

    private UserDao dao;

    public ProfileCommand() {
        super();
        dao = new UserDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String resume =  dao.takeResume(user.getApplicantId());
        request.setAttribute("resume", resume);
        return new ForwardAction(USER_PROFILE_JSP);
    }
}
