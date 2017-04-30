package com.andrew.command;

import com.andrew.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrew on 01.04.2017.
 */
public interface Command  {
    Action execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException;
}