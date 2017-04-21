package com.andrew.command.admin.message;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.MessageDao;
import com.andrew.entity.Admin;
import com.andrew.entity.Message;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static com.andrew.constant.AttributeConstant.ADMIN;
import static com.andrew.constant.JspPathConstant.ADMIN_USER_MESSAGES;

/**
 * Created by Andrew on 07.04.2017.
 */
public class TakeMessagesForUserCommand implements Command {

    private static final Logger LOG = Logger.getLogger(TakeMessagesForUserCommand.class);
    private MessageDao dao;

    public TakeMessagesForUserCommand() {
        super();
        dao = new MessageDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer userId = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute(ADMIN);
        ArrayList<Message> messages = dao.takeMessagesForUser(admin.getIdAdmin() ,userId);
        request.setAttribute("name", request.getParameter("name"));
        request.setAttribute("surname", request.getParameter("surname"));
        request.setAttribute("messages", messages);
        return new ForwardAction(ADMIN_USER_MESSAGES);
    }
}
