package com.example.asm_gd2.controller;

import com.example.asm_gd2.entity.ChiTietSanPham;
import com.example.asm_gd2.entity.ChucVu;
import com.example.asm_gd2.repository.ChiTietSanPhamRepository;
import com.example.asm_gd2.repository.ChucVuRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ChiTietSanPhamServlet", value = {
        "/chi-tiet-san-pham/hien-thi",
        "/chi-tiet-san-pham/detail",
        "/chi-tiet-san-pham/update",
        "/chi-tiet-san-pham/remove",
        "/chi-tiet-san-pham/add",
        "/chi-tiet-san-pham/view-update"
})
public class ChiTietSanPhamServlet extends HttpServlet {
    private List<ChiTietSanPham> listctsp = new ArrayList<>();
    private ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiCTSP(request, response);
        } else if (uri.contains("detail")) {
            this.detailCTSP(request, response);
        } else if (uri.contains("remove")) {
            this.removeCTSP(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateCTSP(request, response);
        }
    }

    private void viewUpdateCTSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSanPham ctsp = chiTietSanPhamRepository.getOne(Long.parseLong(id));
        request.setAttribute("updateCTSP", ctsp);
        request.getRequestDispatcher("/san-pham/update-chi-tiet-san-pham.jsp").forward(request, response);
    }

    private void removeCTSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        ChiTietSanPham ctsp = chiTietSanPhamRepository.getOne(Long.parseLong(id));
        chiTietSanPhamRepository.deleteCTSP(ctsp);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");
    }

    private void detailCTSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSanPham ctsp = chiTietSanPhamRepository.getOne(Long.parseLong(id));
        request.setAttribute("detailCTSP", ctsp);
        listctsp = chiTietSanPhamRepository.getAll();
        request.setAttribute("chiTietSanPham", listctsp);
        request.getRequestDispatcher("/san-pham/chi-tiet-san-pham.jsp").forward(request, response);
    }

    private void hienThiCTSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listctsp = chiTietSanPhamRepository.getAll();
        request.setAttribute("chiTietSanPham", listctsp);
        request.getRequestDispatcher("/san-pham/chi-tiet-san-pham.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateNSX(request, response);
        } else if (uri.contains("add")) {
            this.addNSX(request, response);
        }
    }

    private void addNSX(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        ChiTietSanPham ctsp = new ChiTietSanPham();
        BeanUtils.populate(ctsp, request.getParameterMap());
        chiTietSanPhamRepository.addCTSP(ctsp);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");
    }

    private void updateNSX(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        String id = request.getParameter("id");
        ChiTietSanPham ctsp = chiTietSanPhamRepository.getOne(Long.parseLong(id));
        BeanUtils.populate(ctsp, request.getParameterMap());
        chiTietSanPhamRepository.updateCTSP(ctsp);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");
    }
}
