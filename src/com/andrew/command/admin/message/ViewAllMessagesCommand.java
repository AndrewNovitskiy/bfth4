package com.andrew.command.admin.message;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.MessageDao;
import com.andrew.entity.Admin;
import com.andrew.entity.Message;
import com.andrew.util.SessionChecker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static com.andrew.constant.CommonConstant.ADMIN;
import static com.andrew.constant.JspPathConstant.ADMIN_ALL_MESSAGES_JSP;
import static com.andrew.constant.JspPathConstant.LOG_IN_ADMIN_JSP;

/**
 * Created by Andrew on 02.04.2017.
 */
public class ViewAllMessagesCommand implements Command {

    private MessageDao dao;

    public ViewAllMessagesCommand() {
        dao = new MessageDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        if(SessionChecker.adminInSession(request)) {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute(ADMIN);
        ArrayList<Message> messages = dao.findAllAdminMessages(admin.getAdminId());
        request.setAttribute("messages", messages);
        return new ForwardAction(ADMIN_ALL_MESSAGES_JSP);
        } else {
            return new ForwardAction(LOG_IN_ADMIN_JSP);
        }
    }
}
