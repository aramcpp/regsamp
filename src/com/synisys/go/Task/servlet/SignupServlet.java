package com.synisys.go.Task.servlet;

import com.synisys.go.Task.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Sign-up Servlet
 *
 * provided for sign-up action
 * GET method                       sends sing-up view
 * POST method                      processes sign-up action
 */
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserModel user = new UserModel("dsfasdf", "asdfasdf");

        user.save();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("signup.jsp").include(request, response);
    }
}
