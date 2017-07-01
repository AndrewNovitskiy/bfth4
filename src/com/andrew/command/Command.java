package com.andrew.command;

import com.andrew.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public interface Command  {
    Action execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException;
}