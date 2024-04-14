package com.example.de_thi_thu_02.controller;

import com.example.de_thi_thu_02.entity.Sach;
import com.example.de_thi_thu_02.repository.SachRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SachServlet", value = {
        "/sach/hien-thi",
        "/sach/add",
        "/sach/detail",
        "/sach/update",
        "/sach/remove",
        "/sach/view-update"
})
public class SachServlet extends HttpServlet {
    private List<Sach> sachList = new ArrayList<>();
    private SachRepository sachRepository = new SachRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiSach(request, response);
        } else if (uri.contains("detail")) {
            this.detailSach(request, response);
        } else if (uri.contains("remove")) {
            this.removeSach(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateSach(request, response);
        }
    }

    private void hienThiSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sachList = sachRepository.getAll();
        request.setAttribute("sach", sachList);
        request.getRequestDispatcher("/de-thi-thu/sach.jsp").forward(request, response);
    }

    private void detailSach(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeSach(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateSach(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateSach(request, response);
        } else if (uri.contains("add")) {
            this.addSach(request, response);
        }
    }

    private void addSach(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateSach(HttpServletRequest request, HttpServletResponse response) {
    }
}
