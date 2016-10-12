package com.synisys.go.Task.presentation.servlets;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.business.model.User;
import com.synisys.go.Task.business.model.impl.UserImpl;
import com.synisys.go.Task.business.model.impl.UserInfoImpl;
import com.synisys.go.Task.business.service.exception.DuplicateUsernameException;
import com.synisys.go.Task.business.service.impl.UserInfoServiceImpl;
import com.synisys.go.Task.business.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by arthur.panosyan on 10/11/2016.
 */
public class SignUpServlet extends HttpServlet {

    private UserServiceImpl userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            userService.save((Entity) session.getAttribute("user"));
            response.sendRedirect("userProfile.jsp");
        } catch (DuplicateUsernameException e) {
            request.setAttribute("duplicateUsernameException", "User already exists.");
            response.sendRedirect("signup.jsp");
        }
    }
}
