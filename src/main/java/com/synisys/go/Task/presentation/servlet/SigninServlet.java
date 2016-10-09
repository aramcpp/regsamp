package com.synisys.go.Task.presentation.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Sign-in Servlet
 *
 * provided for sign-in action
 * GET method                       sends sing-in view
 * POST method                      processes sign-in action
 */
public class SigninServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        user.findFirst((User user) -> {
//            return user.getName() == "banan"
//        });
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("signin.jsp").include(request, response);
    }
}
