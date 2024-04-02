package com.example.BUOI1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "KetQuaServlet", value = "/ket-qua1")
public class KetQuaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //B1: Lấy dữ liệu từ jsp về servlet <=> getParameter
//        String user = request.getParameter("username");
//        String password = request.getParameter("password");
//        request.setAttribute("username", user);
//        request.setAttribute("password", password);
//        request.getRequestDispatcher("/buoi2/ket-qua.jsp").forward(request, response);
    }
}