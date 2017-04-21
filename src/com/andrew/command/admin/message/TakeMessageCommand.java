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

import static com.andrew.constant.AttributeConstant.ADMIN;
import static com.andrew.constant.JspPathConstant.INDEX_JSP;
import static com.andrew.constant.JspPathConstant.ADMIN_MESSAGE_JSP;

/**
 * Created by Andrew on 06.04.2017.
 */
public class TakeMessageCommand implements Command {

    private static final Logger LOG = Logger.getLogger(TakeMessageCommand.class);
    private MessageDao dao;

    public TakeMessageCommand() {
        super();
        dao = new MessageDao();
    }

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer messageId = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        try {
            Admin admin = (Admin) session.getAttribute(ADMIN);
            if (dao.checkMessage(messageId, admin.getIdAdmin())) {
                Message message = dao.takeMessageById(messageId);
                request.setAttribute("message", message);
                return new ForwardAction(ADMIN_MESSAGE_JSP);
            } else {
                return new ForwardAction(INDEX_JSP);
            }
        } catch (NullPointerException e){
            return new ForwardAction(INDEX_JSP);
        }

    }
}
