package com.andrew.command.admin.user;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.UserDao;
import com.andrew.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import static com.andrew.constant.JspPathConstant.ADMIN_ALL_USERS_JSP;

/**
 * Created by Andrew on 01.04.2017.
 */
public class TakeAllUsersCommand implements Command {

    private UserDao dao;

    public TakeAllUsersCommand() {
        super();
        dao = new UserDao();
    }

    public Action execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        ArrayList<User> users = dao.takeAllUsers();
        request.setAttribute("users", users);
        return new ForwardAction(ADMIN_ALL_USERS_JSP);
    }
}
