package com.arnab;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("Inside Service");
        res.setContentType("text/html");

        PrintWriter out=res.getWriter();
        out.println("<h2><b>Hello Spring</b></h2>");
    }
}
