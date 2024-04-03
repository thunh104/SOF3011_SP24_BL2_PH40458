package com.example.asm_gd2.controller;

import com.example.asm_gd2.entity.SanPham;
import com.example.asm_gd2.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/hien-thi",
        "/san-pham/detail",
        "/san-pham/update",
        "/san-pham/remove"
})
public class SanPhamServlet extends HttpServlet {
    private List<SanPham> listsp = new ArrayList<>();
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiSanPham(request, response);
        } else if (uri.contains("detail")) {
            this.detailSanPham(request, response);
        } else if (uri.contains("remove")) {
            this.removeSanPham(request, response);
        }
    }

    private void removeSanPham(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailSanPham(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listsp = sanPhamRepository.getAll();
        request.setAttribute("sanPham", listsp);
        request.getRequestDispatcher("/san-pham/san-pham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateSanPham(request, response);
        }
    }

    private void updateSanPham(HttpServletRequest request, HttpServletResponse response) {
    }
}
