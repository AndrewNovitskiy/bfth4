package com.andrew.command.user;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import com.andrew.dao.MessageDao;
import com.andrew.entity.Message;
import com.andrew.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.constant.AttributeConstant.USER;
import static com.andrew.constant.CommandPathConstant.MESSAGES_COMMAND;
import static com.andrew.constant.JspPathConstant.MESSAGE_JSP;

/**
 * Created by Andrew on 14.04.2017.
 */
public class TakeUserMessageCommand implements Command {

    private MessageDao dao;

    public TakeUserMessageCommand() {
        dao = new MessageDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer messageId = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        try {
            User user = (User) session.getAttribute(USER);
            if (dao.checkUserMessage(messageId, user.getApplicantId())) {
                Message message = dao.takeUserMessage(messageId);
                request.setAttribute("message", message);
                return new ForwardAction(MESSAGE_JSP);
            } else {
                return new RedirectAction(MESSAGES_COMMAND);
            }
        } catch (NullPointerException e){
            return new RedirectAction(MESSAGES_COMMAND);
        }
    }
}
