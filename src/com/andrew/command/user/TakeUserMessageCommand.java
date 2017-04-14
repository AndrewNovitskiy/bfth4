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

import static com.andrew.util.AttributeConstant.USER;
import static com.andrew.util.JspPathConstant.INDEX_JSP;
import static com.andrew.util.JspPathConstant.MESSAGE_JSP;

/**
 * Created by Andrew on 14.04.2017.
 */
public class TakeUserMessageCommand implements Command {

    private static final Logger LOG = Logger.getLogger(TakeUserMessageCommand.class);
    private MessageDao dao;

    public TakeUserMessageCommand() {
        super();
        dao = new MessageDao();
    }


    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer messageId = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        try {
            User user = (User) session.getAttribute(USER);
            if (dao.checkUserMessage(messageId, user.getIdApplicant())) {
                Message message = dao.takeUserMessage(messageId);
                request.setAttribute("message", message);
                return new ForwardAction(MESSAGE_JSP);
            } else {
                return new ForwardAction(INDEX_JSP);
            }
        } catch (NullPointerException e){
            return new ForwardAction(INDEX_JSP);
        }
    }
}
