package com.example.asm_gd2.controller;

import com.example.asm_gd2.entity.SanPham;
import com.example.asm_gd2.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ChucVuServlet", value = {
        "/chuc-vu/hien-thi",
        "/chuc-vu/detail",
        "/chuc-vu/update",
        "/chuc-vu/remove",
        "/chuc-vu/add",
        "/chuc-vu/view-update"
})
public class ChucVuServlet extends HttpServlet {
    private List<SanPham> listsp = new ArrayList<>();
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiChucVu(request, response);
        } else if (uri.contains("detail")) {
            this.detailChucVu(request, response);
        } else if (uri.contains("remove")) {
            this.removeChucVu(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateChucVu(request, response);
        }
    }

    private void viewUpdateChucVu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeChucVu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailChucVu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiChucVu(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
