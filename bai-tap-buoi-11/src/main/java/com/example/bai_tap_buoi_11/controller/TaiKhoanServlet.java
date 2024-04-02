package com.example.bai_tap_buoi_11.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "TaiKhoanServlet", value = {
        "/login"
})
public class TaiKhoanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        if (!"HangNT169".equals(user) || !"12345".equals(pass)) {
            request.setAttribute("msgError", "Sai username hoặc password, vui lòng nhập lại !");
        }
        if ("HangNT169".equals(user) && "12345".equals(pass)) {
            request.getRequestDispatcher("/giang-vien.jsp").forward(request, response);
        } else {
            if ("".equals(user)) {
                request.setAttribute("msgUser", "Không được bỏ trống username !");
            }
            if ("".equals(pass)) {
                request.setAttribute("msgPass", "Không được bỏ trống password !");
            }
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}