package com.getjavajob.training.web06.khomutova.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/Login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Properties properties = new Properties();
        properties.load(Login.class.getClassLoader().getResourceAsStream("users.properties"));
        String userID = properties.getProperty("login1");
        String adminID = properties.getProperty("login2");
        String password = properties.getProperty("password");
        String userName1 = properties.getProperty("name1");
        String userName2 = properties.getProperty("name2");
        String profilType1 = properties.getProperty("profileType1");
        String profilType2 = properties.getProperty("profileType2");
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        boolean rememberMe = false;
        if (request.getParameter("remember_me") != null && request.getParameter("remember_me").equals("on")) {
            rememberMe = true;
        }

        if (userID.equals(user) || adminID.equals(user) && password.equals(pwd)) {
            System.out.println("Bingo1");
            HttpSession session = request.getSession();
            if (userID.equals(user)) {
                session.setAttribute("user", userName1);
                session.setAttribute("profileType", profilType1);
            } else {
                session.setAttribute("user", userName2);
                session.setAttribute("profileType", profilType2);
            }

            session.setMaxInactiveInterval(1 * 60);
            if (rememberMe) {
                Cookie userName = new Cookie("user", "AndreyUSER");
                userName.setMaxAge(3 * 60);
                response.addCookie(userName);
                Cookie userType;
                if (userID.equals(user)) {
                    userType = new Cookie("profileType", "user");
                } else userType = new Cookie("profileType", "admin");
                userType.setMaxAge(3 * 60);
                response.addCookie(userType);
            }
            response.sendRedirect("/");
        } else {
            response.sendRedirect("/");
        }
    }
}