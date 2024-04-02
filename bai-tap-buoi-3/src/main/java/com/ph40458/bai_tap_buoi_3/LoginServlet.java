package com.ph40458.bai_tap_buoi_3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {"/login", "/home"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String password = request.getParameter("password");
        if ("".equals(user)) {
            request.setAttribute("msgUser", "Không bỏ trống username !");
        }
        if ("".equals(password)) {
            request.setAttribute("msgPass", "Không bỏ trống password !");
        }
        if ("HangNT169".equals(user) && "123456".equals(password)) {
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Username hoặc password không trùng khớp, vui lòng nhập lại !");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}