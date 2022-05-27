package com.revature.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // TODO: 5/27/2022 need to get username and password from db
        if (username.equals("admin") && password.equals("123")) {
            req.getRequestDispatcher("navbar.html").include(req, resp);
            out.print("<div class=\"container\"><br>you are successfully logged in");
            out.print("<br>Welcome " + username + "</div>");
            HttpSession session = req.getSession();
            session.setAttribute("username", username);

        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
            requestDispatcher.include(req, resp);
            out.println("<div class=\"container\">Sorry, invalid details...</div>");
        }
        out.close();
    }
}
