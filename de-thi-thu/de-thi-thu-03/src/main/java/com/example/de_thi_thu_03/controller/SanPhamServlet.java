package com.example.de_thi_thu_03.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/hien-thi",
        "/san-pham/add",
        "/san-pham/detail",
        "/san-pham/update",
        "/san-pham/view-update",
        "/san-pham/remove"
})
public class SanPhamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiSanPham(request, response);
        } else if (uri.contains("detail")) {
            this.detailSanPham(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateSanPham(request, response);
        } else {
            this.removeSanPham(request, response);
        }
    }

    private void hienThiSanPham(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailSanPham(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateSanPham(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeSanPham(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addSanPham(request, response);
        } else if (uri.contains("update")) {
            this.updateSanPham(request, response);
        }
    }

    private void addSanPham(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateSanPham(HttpServletRequest request, HttpServletResponse response) {
    }
}
