package com.andrew.command.admin.message;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.MessageDao;
import com.andrew.entity.Admin;
import com.andrew.entity.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static com.andrew.constant.AttributeConstant.ADMIN;
import static com.andrew.constant.JspPathConstant.ADMIN_ALL_MESSAGES_JSP;

/**
 * Created by Andrew on 02.04.2017.
 */
public class TakeAllMessagesCommand implements Command {

    private MessageDao dao;

    public TakeAllMessagesCommand() {
        dao = new MessageDao();
    }

    public Action execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute(ADMIN);
        ArrayList<Message> messages = dao.takeAllAdminMessages(admin.getIdAdmin());
        request.setAttribute("messages", messages);
        return new ForwardAction(ADMIN_ALL_MESSAGES_JSP);
    }
}
