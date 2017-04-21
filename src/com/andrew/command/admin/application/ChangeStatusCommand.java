package com.andrew.command.admin.application;

import com.andrew.action.Action;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import com.andrew.dao.ApplicationDao;
import com.andrew.dao.MessageDao;
import com.andrew.entity.Admin;
import com.andrew.util.MessagePreparator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.constant.AttributeConstant.ADMIN;
import static com.andrew.constant.CommandPathConstant.ADMIN_ALL_APPLICATIONS_COMMAND;
import static com.andrew.constant.MessageConstant.MESSAGE_STATUS_CHANGED_TITLE;

/**
 * Created by Andrew on 15.04.2017.
 */
public class ChangeStatusCommand implements Command {

    private static final Logger LOG = Logger.getLogger(ChangeStatusCommand.class);
    private ApplicationDao applicationDao;
    private MessageDao messageDao;

    public ChangeStatusCommand() {
        super();
        applicationDao = new ApplicationDao();
        messageDao = new MessageDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int statusId = Integer.parseInt(request.getParameter("app_status"));
        int applicationId = Integer.parseInt(request.getParameter("id"));

        int applicantId = Integer.parseInt(request.getParameter("applicant_id"));
        String applicantName = request.getParameter("applicant_name");
        String vacancyPosition = request.getParameter("vacancy_position");


        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute(ADMIN);


        applicationDao.changeStatus(applicationId, statusId);

        messageDao.putMessage(admin.getIdAdmin(), applicantId, MESSAGE_STATUS_CHANGED_TITLE,
                MessagePreparator.prepareStatusChangedMessage(applicantName, vacancyPosition,
                        applicationDao.getStatusValue(statusId)));


        return new RedirectAction(ADMIN_ALL_APPLICATIONS_COMMAND);
    }
}
