package com.andrew.command.user;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.MessageDao;
import com.andrew.entity.Message;
import com.andrew.entity.User;
import com.andrew.util.SessionChecker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static com.andrew.constant.CommonConstant.USER;
import static com.andrew.constant.JspPathConstant.LOG_IN_JSP;
import static com.andrew.constant.JspPathConstant.USER_MESSAGES_JSP;

/**
 * Created by Andrew on 14.04.2017.
 */
public class UserViewMessagesCommand implements Command {

    private MessageDao dao;

    public UserViewMessagesCommand() {
        dao = new MessageDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(SessionChecker.userInSession(request)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(USER);

            ArrayList<Message> messages = dao.findUserMessages(user.getApplicantId());
            request.setAttribute("messages", messages);
            return new ForwardAction(USER_MESSAGES_JSP);
        } else {
            return new ForwardAction(LOG_IN_JSP);
        }
    }
}
