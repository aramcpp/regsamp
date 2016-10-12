package com.synisys.go.Task.presentation.servlet;

import com.synisys.go.Task.business.model.User;
import com.synisys.go.Task.business.model.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Sign-in Servlet
 *
 * provided for sign-in action
 * GET method                       sends sing-in view
 * POST method                      processes sign-in action
 */
public class UserInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = user.getUserInfo();
        PrintWriter out = response.getWriter();

        out.println(userInfo.getAge());
    }
}