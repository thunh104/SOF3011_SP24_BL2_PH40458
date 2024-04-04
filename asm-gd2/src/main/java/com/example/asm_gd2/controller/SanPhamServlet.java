package com.example.asm_gd2.controller;

import com.example.asm_gd2.entity.SanPham;
import com.example.asm_gd2.repository.SanPhamRepository;
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
        "/san-pham/detail",
        "/san-pham/update",
        "/san-pham/remove",
        "/san-pham/add",
        "/san-pham/view-update"
})
public class SanPhamServlet extends HttpServlet {
    private List<SanPham> listsp = new ArrayList<>();
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiSanPham(request, response);
        } else if (uri.contains("detail")) {
            this.detailSanPham(request, response);
        } else if (uri.contains("remove")) {
            this.removeSanPham(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateSanPham(request, response);
        }
    }

    private void viewUpdateSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sp = sanPhamRepository.getOne(Long.parseLong(id));
        request.setAttribute("updateSP", sp);
        request.getRequestDispatcher("/san-pham/update-san-pham.jsp").forward(request, response);
    }

    private void removeSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        SanPham sp = sanPhamRepository.getOne(Long.parseLong(id));
        sanPhamRepository.deleteSP(sp);
        response.sendRedirect("/san-pham/hien-thi");
    }

    private void detailSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sp = sanPhamRepository.getOne(Long.parseLong(id));
        request.setAttribute("detailSP", sp);
        listsp = sanPhamRepository.getAll();
        request.setAttribute("sanPham", listsp);
        request.getRequestDispatcher("/san-pham/san-pham.jsp").forward(request, response);
    }

    private void hienThiSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listsp = sanPhamRepository.getAll();
        request.setAttribute("sanPham", listsp);
        request.getRequestDispatcher("/san-pham/san-pham.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateSanPham(request, response);
        } else if (uri.contains("add")) {
            this.addSanPham(request, response);
        }
    }

    private void addSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        SanPham sp = new SanPham();
        BeanUtils.populate(sp, request.getParameterMap());
        sanPhamRepository.addSP(sp);
        response.sendRedirect("/san-pham/hien-thi");
    }

    private void updateSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        String id = request.getParameter("id");
        SanPham sp = sanPhamRepository.getOne(Long.parseLong(id));
        BeanUtils.populate(sp, request.getParameterMap());
        sanPhamRepository.updateSP(sp);
        response.sendRedirect("/san-pham/hien-thi");
    }
}
