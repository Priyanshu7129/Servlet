package com.firstServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Username validation: Must start with a capital letter and have at least 3 characters
        if (!username.matches("^[A-Z][a-zA-Z]{2,}$")) {
            response.getWriter().println("Invalid username! It must start with a capital letter and be at least 3 characters long.");
            return;
        }


        if (!password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?!.*[@#$%^&+=].*[@#$%^&+=]).{8,}$")) {
            response.getWriter().println("Invalid password! It must have at least 8 characters, 1 uppercase letter, 1 number, and exactly 1 special character.");
            return;
        }

        // If both username and password are valid, login is successful
        response.sendRedirect("loginSuccess.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Use the login form to submit credentials.");
    }
}
