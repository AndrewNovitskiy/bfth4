package com.andrew.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrew on 01.04.2017.
 */
public class ForwardAction extends Action {

    public ForwardAction(String path){
        super(path);
    }

    @Override
    public void go(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(path).forward(request, response);
    }
}
