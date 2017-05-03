package com.andrew.command.user;

import com.andrew.action.Action;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.andrew.constant.AttributeConstant.USER;
import static com.andrew.constant.JspPathConstant.INDEX_JSP;

/**
 * Created by Andrew on 01.04.2017.
 */
public class UserLogOutCommand implements Command {

    public Action execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        session.removeAttribute(USER);
        return new RedirectAction(INDEX_JSP);
    }

}
