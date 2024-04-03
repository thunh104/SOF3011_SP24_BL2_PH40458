package com.example.luyen_tap_lab_78.controller;

import com.example.luyen_tap_lab_78.entity.SinhVien;
import com.example.luyen_tap_lab_78.repository.SinhVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/update",
        "/sinh-vien/detail",
        "/sinh-vien/remove",
        "/sinh-vien/add",
        "/sinh-vien/view-update"
})
public class SinhVienServlet extends HttpServlet {
    private List<SinhVien> sinhVienList = new ArrayList<>();
    private SinhVienRepository svRepo = new SinhVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiSinhVien(request, response);
        } else if (uri.contains("detail")) {
            this.detailSinhVien(request, response);
        } else if (uri.contains("remove")) {
            this.removeSinhVien(request, response);
        } else {
            this.viewUpdateSinhVien(request, response);
        }
    }

    private void viewUpdateSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SinhVien sinhVien = svRepo.getById(Long.parseLong(id));
        request.setAttribute("sv1", sinhVien);
        request.getRequestDispatcher("/lab/update-sinh-vien.jsp").forward(request, response);
    }

    private void hienThiSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sinhVienList = svRepo.getAll();
        request.setAttribute("sinhVien", sinhVienList);
        request.getRequestDispatcher("/lab/sinh-vien.jsp").forward(request, response);
    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SinhVien sinhVien = svRepo.getById(Long.parseLong(id));
        request.setAttribute("sv1", sinhVien);
        sinhVienList = svRepo.getAll();
        request.setAttribute("sinhVien", sinhVienList);
        request.getRequestDispatcher("/lab/sinh-vien.jsp").forward(request, response);
    }

    private void removeSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        SinhVien sinhVien = svRepo.getById(Long.parseLong(id));
        svRepo.deleteSinhVien(sinhVien);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.addSinhVien(request, response);
        } else {
            this.updateSinhVien(request, response);
        }
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        SinhVien sv = new SinhVien();
        BeanUtils.populate(sv, request.getParameterMap());
        svRepo.addSinhVien(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        String id = request.getParameter("id");
        SinhVien sv = svRepo.getById(Long.parseLong(id));
        BeanUtils.populate(sv, request.getParameterMap());
        svRepo.updateSinhVien(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }
}
