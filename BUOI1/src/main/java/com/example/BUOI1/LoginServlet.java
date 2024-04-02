package com.example.BUOI1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {"/login", "/ket-qua"})
public class LoginServlet extends HttpServlet {
    // FE (view client giao diện) => jframe/jsp/html => webapp
    // BE(server) => logic => service, repositor, ..
    // trao đổi bằng controller thông qua phương thức HTTPMethods
    // VALUE luôn luôn bắt đầu bằng /
    // VALUE chứa đường dẫn của trình duyệt
    // BE & FE trao đổi thông qua controller bằng phương thức HTTP Methods
    // Có 4 loại cơ bản:
    // GET :  = READ : Hiển thị dữ liệu (Lấy ra) <=> SELECT
    // POST: <=> CREATE: Thêm dữ liệu <=> INSERT INTO
    // PUT : <=> UPDATE: Sửa dữ liệu
    // DELETE <=> DELETE: Xóa dữ liệu
    // J4/ J5: Get , Post
    // GET: Hiển thị, lấy ra
    // Post: Xử lý
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Truyền giá trị từ servlet sang jsp => setAttribute
        String mess ="HangNT169";
        request.setAttribute("mess123",mess);
        // Chuyển trang
        // C1: Mang dữ liệu muốn truyền sang jsp
        //request.getRequestDispatcher("a.jsp").forward(request,response);
        // C2: Chuyển trang => Chỉ chuyển trang
        response.sendRedirect("/buoi1/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //B1: Lấy dữ liệu từ jsp về servlet <=> getParameter
        String user = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("username", user);
        request.setAttribute("password", password);
        request.getRequestDispatcher("/buoi2/ket-qua.jsp").forward(request, response);
    }
}