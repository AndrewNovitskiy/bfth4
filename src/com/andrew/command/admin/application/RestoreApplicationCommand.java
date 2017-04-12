package com.andrew.command.admin.application;

import com.andrew.action.Action;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import com.andrew.dao.ApplicationDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.andrew.util.CommandPathConstant.ADMIN_ALL_APPLICATIONS_COMMAND;

/**
 * Created by Andrew on 12.04.2017.
 */
public class RestoreApplicationCommand implements Command {

    private static final Logger LOG = Logger.getLogger(RestoreApplicationCommand.class);
    private ApplicationDao dao;

    public RestoreApplicationCommand() {
        super();
        dao = new ApplicationDao();
    }
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int applicationId = Integer.parseInt(request.getParameter("id"));
        dao.restoreApplication(applicationId);
        return new RedirectAction(ADMIN_ALL_APPLICATIONS_COMMAND);
    }
}
