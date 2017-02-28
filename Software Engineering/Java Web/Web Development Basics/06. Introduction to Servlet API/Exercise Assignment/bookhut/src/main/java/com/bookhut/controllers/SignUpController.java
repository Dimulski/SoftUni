package com.bookhut.controllers;

import com.bookhut.models.bindingModels.LoginModel;
import com.bookhut.service.UserService;
import com.bookhut.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {

    private UserService userService;

    public SignUpController() {
        this.userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginModel loginModel = null;
        String signUpText = request.getParameter("signup");
        if(signUpText != null){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            loginModel = new LoginModel(username,password);
            this.userService.createUser(loginModel);
            response.sendRedirect("/signin");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/templates/signup.jsp").forward(request, response);
    }
}
