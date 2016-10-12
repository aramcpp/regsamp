package com.synisys.go.Task.presentation.servlet;

import com.synisys.go.Task.business.model.User;
import com.synisys.go.Task.business.model.impl.UserImpl;
import com.synisys.go.Task.business.service.EntityService;
import com.synisys.go.Task.business.service.impl.UserInfoServiceImpl;
import com.synisys.go.Task.business.service.impl.UserServiceImpl;

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
    private UserServiceImpl userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        try{
           // user = userService.loadUserByUserNamePassword(userName, password);
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("userProfile.jsp").forward(request,response);
        }catch (Exception e){

            //handle invalid user name password
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("signin.jsp").forward(request, response);
    }
}
