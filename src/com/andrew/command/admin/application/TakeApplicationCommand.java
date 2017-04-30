package com.andrew.command.admin.application;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.ApplicationDao;
import com.andrew.entity.Application;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.andrew.constant.JspPathConstant.ADMIN_APPLICATION_JSP;

/**
 * Created by Andrew on 07.04.2017.
 */
public class TakeApplicationCommand implements Command {

    private ApplicationDao dao;

    public TakeApplicationCommand() {
        super();
        dao = new ApplicationDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer applicationId = Integer.parseInt(request.getParameter("id"));
        Application application = dao.takeApplicationByIdForAdmin(applicationId);
        request.setAttribute("application", application);
        return new ForwardAction(ADMIN_APPLICATION_JSP);
    }
}
