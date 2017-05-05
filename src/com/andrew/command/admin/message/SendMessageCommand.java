package com.andrew.command.admin.message;

import com.andrew.action.Action;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import com.andrew.dao.MessageDao;
import com.andrew.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.constant.CommonConstant.ADMIN;
import static com.andrew.constant.CommandPathConstant.ADMIN_ALL_MESSAGES_COMMAND;

/**
 * Created by Andrew on 09.04.2017.
 */
public class SendMessageCommand implements Command {

    private MessageDao dao;

    public SendMessageCommand() {
        dao = new MessageDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer recipientId = Integer.parseInt(request.getParameter("recipient"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute(ADMIN);

        dao.putMessage(admin.getAdminId(), recipientId, title, content);
        return new RedirectAction(ADMIN_ALL_MESSAGES_COMMAND);
    }
}
