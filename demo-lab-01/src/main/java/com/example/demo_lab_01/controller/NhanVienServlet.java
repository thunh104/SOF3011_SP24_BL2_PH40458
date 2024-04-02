package com.example.demo_lab_01.controller;

import com.example.demo_lab_01.entity.NhanVien;
import com.example.demo_lab_01.repository.NhanVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/remove",
        "/nhan-vien/detail",
        "/nhan-vien/view-update",
        "/nhan-vien/update",
        "/nhan-vien/add"
})
public class NhanVienServlet extends HttpServlet {
    private List<NhanVien> nhanVienList = new ArrayList<>();
    private NhanVienRepository repo = new NhanVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiNhanVien(request, response);
        } else if (uri.contains("remove")) {
            this.removeNhanVien(request, response);
        } else if (uri.contains("detail")) {
            this.detailNhanVien(request, response);
        } else {
            this.viewUpdateNhanVien(request, response);
        }
    }

    private void hienThiNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        nhanVienList = repo.getAll();
        request.setAttribute("nv", nhanVienList);
        request.getRequestDispatcher("/demo/nhan-vien.jsp").forward(request, response);
    }

    private void removeNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhanVien nv = repo.getByID(Long.parseLong(id));
        repo.deleteNhanVien(nv);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    private void detailNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhanVien nv = repo.getByID(Long.parseLong(id));
        request.setAttribute("nv1", nv);
        nhanVienList = repo.getAll();
        request.setAttribute("nv", nhanVienList);
        request.getRequestDispatcher("/demo/nhan-vien.jsp").forward(request, response);
    }

    private void viewUpdateNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhanVien nv = repo.getByID(Long.parseLong(id));
        request.setAttribute("nv1", nv);
        request.getRequestDispatcher("/demo/update-nhan-vien.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateNhanVien(request, response);
        } else {
            this.addNhanVien(request, response);
        }
    }

    private void addNhanVien(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String gioiTinh = request.getParameter("gioiTinh");
        String diaChi = request.getParameter("diaChi");
        NhanVien nv = new NhanVien();
//        BeanUtils.populate(nv, request.getParameterMap());
        nv.setMa(ma);
        nv.setTen(ten);
        nv.setTuoi(Long.parseLong(tuoi));
        nv.setGioiTinh(Boolean.valueOf(gioiTinh));
        nv.setDiaChi(diaChi);
        repo.addNhanVien(nv);
        request.setAttribute("nv", nhanVienList);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    private void updateNhanVien(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String gioiTinh = request.getParameter("gioiTinh");
        String diaChi = request.getParameter("diaChi");
        NhanVien nv = repo.getByID(Long.parseLong(id));
        nv.setMa(ma);
        nv.setTen(ten);
        nv.setTuoi(Long.parseLong(tuoi));
        nv.setGioiTinh(Boolean.valueOf(gioiTinh));
        nv.setDiaChi(diaChi);
        repo.updateNhanVien(nv);
        response.sendRedirect("/nhan-vien/hien-thi");
    }
}
