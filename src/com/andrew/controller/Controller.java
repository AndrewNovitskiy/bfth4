package com.andrew.controller;

import com.andrew.action.Action;
import com.andrew.command.Command;
import com.andrew.command.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.andrew.constant.CommonConstant.COMMAND;


public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        String commandName = request.getParameter(COMMAND);
        Command command = CommandFactory.defineCommand(commandName);

        try {
            Action action = command.execute(request, response);
            action.go(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}