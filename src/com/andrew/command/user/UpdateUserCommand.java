package com.andrew.command.user;

import com.andrew.action.Action;
import com.andrew.action.ForwardAction;
import com.andrew.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.andrew.util.JspPathConstant.ADMIN_EDIT_VACANCY_JSP;

/**
 * Created by Andrew on 14.04.2017.
 */
public class UpdateUserCommand implements Command {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        return new ForwardAction(ADMIN_EDIT_VACANCY_JSP);
    }
}
