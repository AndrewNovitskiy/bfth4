package com.andrew.command.user;

import com.andrew.action.Action;
import com.andrew.action.RedirectAction;
import com.andrew.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LanguageChangeCommand implements Command {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String language = request.getParameter("language");
        HttpSession session = request.getSession();
        session.setAttribute("language", language);
        return new RedirectAction(request.getHeader("referer"));
    }
}
