package com.example.BTVN12.controller;

import com.example.BTVN12.entity.SinhVien;
import com.example.BTVN12.entity.Lop;
import com.example.BTVN12.repository.SinhVienRepository;
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
        "/sinh-vien/detail",
        "/sinh-vien/delete",
        "/sinh-vien/update",
        "/sinh-vien/view-update",
        "/sinh-vien/search",
        "/sinh-vien/top3"
})
public class SinhVienServlet extends HttpServlet {
    private List<SinhVien> sinhVienList = new ArrayList<>();
    private SinhVienRepository sinhVienRepository = new SinhVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("search")) {
            this.timKiem(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("delete")) {
            this.remove(request, response);
        } else if (uri.contains("top3")) {
            this.top3SinhVien(request, response);
        } else {
            this.hienThi(request, response);
        }

    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SinhVien sv = sinhVienRepository.getOne(Long.parseLong(id));
        request.setAttribute("gvl", sv);
        sinhVienList = sinhVienRepository.getAll();
        request.setAttribute("hienThi", sinhVienList);
        request.getRequestDispatcher("/btvn12/sinhvien.jsp").forward(request, response);
    }

    private void timKiem(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SinhVien sv = sinhVienRepository.getOne(Long.parseLong(id));
        request.setAttribute("gvl", sv);
        request.getRequestDispatcher("/btvn12/update.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SinhVien sv = sinhVienRepository.getOne(Long.parseLong(id));
        sinhVienRepository.delete(sv);
        sinhVienList =sinhVienRepository.getAll();
        request.setAttribute("hienThi", sinhVienList);
        request.getRequestDispatcher("/btvn12/sinhvien.jsp").forward(request, response);



    }

    private void top3SinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<SinhVien> top3SinhVienList = sinhVienRepository.findTop3("A");
//
//        request.setAttribute("top3SinhVienList", top3SinhVienList);
//
//        request.getRequestDispatcher("/btvn12/top3SinhVien.jsp").forward(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sinhVienList = sinhVienRepository.getAll();
        request.setAttribute("hienThi", sinhVienList);
        request.getRequestDispatcher("/btvn12/sinhvien.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else {
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        SinhVien sv = new SinhVien();
        Lop lop = new Lop();
        BeanUtils.populate(sv, request.getParameterMap());
        String maLop = request.getParameter("maLop");
        String tenLop = request.getParameter("tenLop");
        lop.setMaLop(maLop);
        lop.setTenLop(tenLop);
        sinhVienRepository.update(sv);

        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {

        SinhVien sv = new SinhVien();
        Lop lop = new Lop();
        BeanUtils.populate(sv, request.getParameterMap());

        String maLop = request.getParameter("maLop");
        String tenLop = request.getParameter("tenLop");
        lop.setMaLop(maLop);
        lop.setTenLop(tenLop);
        sv.setLop(lop); // Gán thông tin về lớp cho sinh viên

        sinhVienRepository.add(sv); // Thêm sinh viên vào cơ sở dữ liệu
        sinhVienRepository.getAll();

        response.sendRedirect("/sinh-vien/hien-thi");
    }
}
