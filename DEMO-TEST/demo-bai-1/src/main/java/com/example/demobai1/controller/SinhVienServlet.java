package com.example.demobai1.controller;

import com.example.demobai1.entity.SinhVien;
import com.example.demobai1.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/search",
        "/sinh-vien/remove",
        "/sinh-vien/detail",
        "/sinh-vien/view-update",
        "/sinh-vien/update",
        "/sinh-vien/view-add",
        "/sinh-vien/add"
})
public class SinhVienServlet extends HttpServlet {
    private List<SinhVien> listsv = new ArrayList<>();
    private SinhVienService sinhVienService = new SinhVienService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiSinhVien(request, response);
        } else if (uri.contains("search")) {
            this.timKiemSinhVien(request, response);
        } else if (uri.contains("remove")) {
            this.removeSinhVien(request, response);
        } else if (uri.contains("detail")) {
            this.detailSinhVien(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateSinhVien(request, response);
        } else {
            this.viewAddSinhVien(request, response);
        }
    }

    private void viewAddSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mssv = request.getParameter("mssv");
        sinhVienService.remove(mssv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void timKiemSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listsv = sinhVienService.getAll();
        request.setAttribute("sv", listsv);
        request.getRequestDispatcher("/sinh-vien.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateSinhVien(request, response);
        } else {
            this.addSinhVien(request, response);
        }
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }
}