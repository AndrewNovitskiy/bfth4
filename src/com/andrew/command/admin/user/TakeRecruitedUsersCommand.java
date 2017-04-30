package com.andrew.command.admin.user;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.ApplicationDao;
import com.andrew.entity.Application;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.andrew.constant.JspPathConstant.ADMIN_RECRUITED_USERS_JSP;

/**
 * Created by Andrew on 26.04.2017.
 */
public class TakeRecruitedUsersCommand implements Command {

    private ApplicationDao dao;

    public TakeRecruitedUsersCommand() {
        super();
        dao = new ApplicationDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Application> applications = dao.takeRecruitedUsers();
        request.setAttribute("applications", applications);
        return new ForwardAction(ADMIN_RECRUITED_USERS_JSP);
    }
}
