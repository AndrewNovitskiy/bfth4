package com.andrew.command.user;

import com.andrew.action.Action;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import com.andrew.dao.ApplicationDao;
import com.andrew.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.util.AttributeConstant.USER;
import static com.andrew.util.CommandPathConstant.APPLICATIONS_COMMAND;

/**
 * Created by Andrew on 16.04.2017.
 */
public class NewApplicationCommand implements Command {


    private static final Logger LOG = Logger.getLogger(NewApplicationCommand.class);
    private ApplicationDao dao;

    public NewApplicationCommand() {
        super();
        dao = new ApplicationDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        Integer vacancyId = Integer.parseInt(request.getParameter("vacancyId"));

        if(dao.applicationExists(user.getIdApplicant(), vacancyId)){
            dao.restoreApplication(user.getIdApplicant(), vacancyId);
        } else {
            dao.newApplication(user.getIdApplicant(), vacancyId);
        }


        return new RedirectAction(APPLICATIONS_COMMAND);
    }
}
