package com.andrew.command.admin;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.andrew.util.JspPathConstant.ADMIN_NEW_MESSAGE_JSP;

/**
 * Created by Andrew on 09.04.2017.
 */
public class WriteANewMessageCommand implements Command {


    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("id", Integer.parseInt(request.getParameter("id")));
        request.setAttribute("name", request.getParameter("name"));
        request.setAttribute("surname", request.getParameter("surname"));
        return new ForwardAction(ADMIN_NEW_MESSAGE_JSP);
    }
}
