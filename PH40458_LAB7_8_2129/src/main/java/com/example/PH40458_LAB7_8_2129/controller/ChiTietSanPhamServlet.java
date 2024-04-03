package com.example.PH40458_LAB7_8_2129.controller;

import com.example.PH40458_LAB7_8_2129.entity.ChiTietSanPham;
import com.example.PH40458_LAB7_8_2129.repository.ChiTietSanPhamRepository;
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
        "/chi-tiet-san-pham/add",
        "/chi-tiet-san-pham/remove",
})
public class ChiTietSanPhamServlet extends HttpServlet {
    private List<ChiTietSanPham> listctsp = new ArrayList<>();
    private ChiTietSanPhamRepository repo = new ChiTietSanPhamRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiCTSP(request, response);
        } else if (uri.contains("remove")) {
            this.removeCTSP(request, response);
        }
    }

    private void removeCTSP(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idCTSP = request.getParameter("idCTSP");
        ChiTietSanPham ctsp = repo.getOne(Long.parseLong(idCTSP));
        repo.removeCT(ctsp);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");
        //request.getRequestDispatcher("/lab/chi-tiet-san-pham.jsp").forward(request, response);
    }

    private void hienThiCTSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listctsp = repo.getAll();
        request.setAttribute("htspct", listctsp);
        request.getRequestDispatcher("/lab/chi-tiet-san-pham.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addCTSP(request, response);
        }
    }

    private void addCTSP(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException, ServletException {
        ChiTietSanPham ctsp = new ChiTietSanPham();
        BeanUtils.populate(ctsp, request.getParameterMap());
        repo.addCT(ctsp);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");
        //request.getRequestDispatcher("/lab/chi-tiet-san-pham.jsp").forward(request, response);
    }
}
