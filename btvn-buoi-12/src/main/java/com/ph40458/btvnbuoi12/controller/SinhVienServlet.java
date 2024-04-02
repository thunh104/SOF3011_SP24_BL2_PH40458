package com.ph40458.btvnbuoi12.controller;


import com.ph40458.btvnbuoi12.entity.SinhVien;
import com.ph40458.btvnbuoi12.repository.SinhVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/add",
        "/sinh-vien/delete",
        "/sinh-vien/detail",
        "/sinh-vien/update",
        "/sinh-vien/view-update",
        "/sinh-vien/search",
        "/sinh-vien/top3"
})
public class SinhVienServlet extends HttpServlet {
    private List<SinhVien> sinhVienList = new ArrayList<>();
    private SinhVienRepository repository = new SinhVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiSinhVien(request, response);
        } else if (uri.contains("delete")) {
            this.deleteSinhVien(request, response);
        } else if (uri.contains("detail")) {
            this.detailSinhVien(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateSinhVien(request, response);
        } else if (uri.contains("search")) {
            this.searchSinhVien(request, response);
        } else {
            this.top3SinhVien(request, response);
        }
    }

    private void hienThiSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sinhVienList = repository.getALl();
        request.setAttribute("sv", sinhVienList);
        request.getRequestDispatcher("/btvn-12/sinh-vien.jsp").forward(request, response);
    }

    private void deleteSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        SinhVien sv = repository.getByMa(Long.parseLong(id));
        repository.deleteSinhVien(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SinhVien sv = repository.getByMa(Long.parseLong(id));
        request.setAttribute("sv1", sv);
        sinhVienList = repository.getALl();
        request.setAttribute("sv", sinhVienList);
        request.getRequestDispatcher("/btvn-12/sinh-vien.jsp").forward(request, response);
    }

    private void viewUpdateSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SinhVien sv = repository.getByMa(Long.parseLong(id));
        request.setAttribute("sv1", sv);
        request.getRequestDispatcher("/btvn-12/update-sinh-vien.jsp").forward(request, response);
    }

    private void searchSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void top3SinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addSinhVien(request, response);
        } else {
            this.updateSinhVien(request, response);
        }
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException, ServletException {
        SinhVien sinhVien = new SinhVien();
        BeanUtils.populate(sinhVien, request.getParameterMap());
        repository.addSinhVien(sinhVien);
        request.setAttribute("sv", sinhVienList);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String gioiTinh = request.getParameter("gioiTinh");
        String diaChi = request.getParameter("diaChi");
        SinhVien sv = repository.getByMa(Long.parseLong(id));
        sv.setMa(ma);
        sv.setTen(ten);
        sv.setTuoi(Long.parseLong(tuoi));
        sv.setGioiTinh(Boolean.valueOf(gioiTinh));
        sv.setDiaChi(diaChi);
        repository.updateSinhVien(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }
}
