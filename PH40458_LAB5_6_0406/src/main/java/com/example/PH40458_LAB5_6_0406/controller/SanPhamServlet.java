package com.example.PH40458_LAB5_6_0406.controller;

import com.example.PH40458_LAB5_6_0406.entity.SanPham;
import com.example.PH40458_LAB5_6_0406.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/hien-thi",
        "/san-pham/add",
        "/san-pham/search",
        "/san-pham/remove"
})
public class SanPhamServlet extends HttpServlet {
    private List<SanPham> sanPhamList = new ArrayList<>();
    private SanPhamRepository repository = new SanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiSanPham(request, response);
        } else if (uri.contains("search")) {
            this.searchSanPham(request, response);
        } else {
            this.removeSanPham(request, response);
        }
    }

    private void hienThiSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sanPhamList = repository.getAll();
        request.setAttribute("sp", sanPhamList);
        request.getRequestDispatcher("/lab/san-pham.jsp").forward(request, response);
    }

    private void searchSanPham(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sanPham = repository.getByID(Long.parseLong(id));
        repository.deleteSanPham(sanPham);
        response.sendRedirect("/san-pham/hien-thi");
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addSanPham(request, response);
        }
    }

    private void addSanPham(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        SanPham sp = new SanPham();
        BeanUtils.populate(sp, request.getParameterMap());
        repository.addSanPham(sp);
        sanPhamList = repository.getAll();
        request.setAttribute("sp", sanPhamList);
        response.sendRedirect("/san-pham/hien-thi");
    }
}
