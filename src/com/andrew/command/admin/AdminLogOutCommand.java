package com.andrew.command.admin;

import com.andrew.action.Action;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.andrew.constant.AttributeConstant.ADMIN;
import static com.andrew.constant.JspPathConstant.INDEX_JSP;

/**
 * Created by Andrew on 04.04.2017.
 */
public class AdminLogOutCommand implements Command {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        session.removeAttribute(ADMIN);
        return new RedirectAction(INDEX_JSP);
    }
}
