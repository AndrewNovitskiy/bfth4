package com.andrew.command.user;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;
import com.andrew.dao.MessageDao;
import com.andrew.entity.Message;
import com.andrew.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static com.andrew.constant.AttributeConstant.USER;
import static com.andrew.constant.JspPathConstant.USER_MESSAGES_JSP;

/**
 * Created by Andrew on 14.04.2017.
 */
public class TakeUserMessagesCommand implements Command {

    private static final Logger LOG = Logger.getLogger(TakeUserMessagesCommand.class);
    private MessageDao dao;

    public TakeUserMessagesCommand() {
        super();
        dao = new MessageDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        ArrayList<Message> messages = dao.takeUserMessages(user.getIdApplicant());
        request.setAttribute("messages", messages);
        return new ForwardAction(USER_MESSAGES_JSP);
    }
}
