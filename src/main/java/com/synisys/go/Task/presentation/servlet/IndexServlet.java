package com.synisys.go.Task.presentation.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Index Servlet
 *
 * GET method                           returns index page or user profile, depending on users authorisation status
 */
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * TODO
         * add sessions!!
         */

        request.getRequestDispatcher("index.jsp").include(request, response);
    }
}
