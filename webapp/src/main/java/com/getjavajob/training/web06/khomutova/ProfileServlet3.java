package com.getjavajob.training.web06.khomutova;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("link1.html").include(request, response);

        Cookie ck[] = request.getCookies();
        if (ck != null) {
            String name = ck[0].getValue();
            if (!name.equals("") || name != null) {
                out.print("<b>Welcome to Profile</b>");
                out.print("<br>Welcome, " + name);
            }
        } else {
            out.print("Please login first");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
    }
}  