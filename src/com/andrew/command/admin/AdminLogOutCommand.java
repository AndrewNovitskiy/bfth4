package com.andrew.command.admin;

import com.andrew.action.Action;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.andrew.util.AttributeConstant.ADMIN;
import static com.andrew.util.JspPathConstant.INDEX_JSP;

/**
 * Created by Andrew on 04.04.2017.
 */
public class AdminLogOutCommand implements Command {
    private static final Logger log = Logger.getLogger(AdminLogOutCommand.class);

    public Action execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        session.removeAttribute(ADMIN);
        return new RedirectAction(INDEX_JSP);
    }
}
