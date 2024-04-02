package com.example.bai_tap_buoi_7.controller;

import com.example.bai_tap_buoi_7.entity.SanPham;
import com.example.bai_tap_buoi_7.service.SanPhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/view-all", //GET
        "/san-pham/detail", //GET
        "/san-pham/remove", //GET
        "/san-pham/view-update", //GET
        "/san-pham/update", //POST
        "/san-pham/tim-kiem", //GET
        "/san-pham/add" //POST
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamService spsv = new SanPhamService();
    private List<SanPham> listSP = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("view-all")) {
            this.hienThiSanPham(request, response);
        } else if (uri.contains("detail")) {
            this.detailSanPham(request, response);
        } else if (uri.contains("remove")) {
            this.removeSanPham(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateSanPham(request, response);
        } else {
            this.timKiemSanPham(request, response);
        }
    }

    private void timKiemSanPham(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sp = spsv.detail(ma);
        request.setAttribute("sp1", sp);
        request.getRequestDispatcher("/update-san-pham.jsp").forward(request, response);
    }

    private void removeSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        spsv.remove(ma);
        response.sendRedirect("/san-pham/view-all");
    }

    private void detailSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sp = spsv.detail(ma);
        request.setAttribute("spl", sp);
        listSP = spsv.getAll();
        request.setAttribute("sp", listSP);
        request.getRequestDispatcher("/san-pham.jsp").forward(request, response);
    }

    private void hienThiSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSP = spsv.getAll();
        request.setAttribute("sp", listSP);
        request.getRequestDispatcher("/san-pham.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addSanPham(request, response);
        } else {
            this.updateSanPham(request, response);
        }
    }

    private void updateSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String gia = request.getParameter("gia");
        String loai = request.getParameter("loai");
        SanPham sp = new SanPham(id, ma, ten, gia, loai);
        spsv.update(ma, sp);
        response.sendRedirect("/san-pham/view-all");
    }

    private void addSanPham(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException, ServletException {
        String id = request.getParameter(String.valueOf("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String loai = request.getParameter("loai");
        String gia = request.getParameter("gia");
        boolean check = false;
        if (check) {
            request.getRequestDispatcher("/san-pham.jsp").forward(request, response);
        } else {
            SanPham sp = new SanPham();
            BeanUtils.populate(sp, request.getParameterMap());
            spsv.add(sp);
            response.sendRedirect("/san-pham/view-all");
        }
    }
}