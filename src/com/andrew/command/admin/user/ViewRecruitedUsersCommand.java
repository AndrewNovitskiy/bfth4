package com.andrew.command.admin.user;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.ApplicationDao;
import com.andrew.entity.Application;
import com.andrew.util.SessionChecker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.andrew.constant.JspPathConstant.ADMIN_RECRUITED_USERS_JSP;
import static com.andrew.constant.JspPathConstant.LOG_IN_ADMIN_JSP;

/**
 * Created by Andrew on 26.04.2017.
 */
public class ViewRecruitedUsersCommand implements Command {

    private ApplicationDao dao;

    public ViewRecruitedUsersCommand() {
        dao = new ApplicationDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(SessionChecker.adminInSession(request)) {
        ArrayList<Application> applications = dao.findRecruitedUsers();
        request.setAttribute("applications", applications);
        return new ForwardAction(ADMIN_RECRUITED_USERS_JSP);
        } else {
            return new ForwardAction(LOG_IN_ADMIN_JSP);
        }
    }
}
