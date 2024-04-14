package com.example.asm_gd2.controller;

import com.example.asm_gd2.entity.KhachHang;
import com.example.asm_gd2.entity.SanPham;
import com.example.asm_gd2.repository.KhachHangRepository;
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

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi",
        "/khach-hang/detail",
        "/khach-hang/update",
        "/khach-hang/remove",
        "/khach-hang/add",
        "/khach-hang/view-update"
})
public class KhachHangServlet extends HttpServlet {
    private List<KhachHang> listkh = new ArrayList<>();
    private KhachHangRepository khachHangRepository = new KhachHangRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiKhachHang(request, response);
        } else if (uri.contains("detail")) {
            this.detailKhachHang(request, response);
        } else if (uri.contains("remove")) {
            this.removeKhachHang(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateKhachHang(request, response);
        }
    }

    private void viewUpdateKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        KhachHang kh = khachHangRepository.getOne(Long.parseLong(id));
        request.setAttribute("updateKH", kh);
        request.getRequestDispatcher("/tai-khoan/update-khach-hang.jsp").forward(request, response);
    }

    private void removeKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        KhachHang kh = khachHangRepository.getOne(Long.parseLong(id));
        khachHangRepository.deleteKH(kh);
        response.sendRedirect("/khach-hang/hien-thi");
    }

    private void detailKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        KhachHang kh = khachHangRepository.getOne(Long.parseLong(id));
        request.setAttribute("detailKH", kh);
        listkh = khachHangRepository.getAll();
        request.setAttribute("khachHang", listkh);
        request.getRequestDispatcher("/tai-khoan/khach-hang.jsp").forward(request, response);
    }

    private void hienThiKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listkh = khachHangRepository.getAll();
        request.setAttribute("khachHang", listkh);
        request.getRequestDispatcher("/tai-khoan/khach-hang.jsp").forward(request, response);
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
        KhachHang kh = new KhachHang();
        BeanUtils.populate(kh, request.getParameterMap());
        khachHangRepository.addKH(kh);
        response.sendRedirect("/khach-hang/hien-thi");
    }

    private void updateSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        String id = request.getParameter("id");
        KhachHang kh = khachHangRepository.getOne(Long.parseLong(id));
        BeanUtils.populate(kh, request.getParameterMap());
        khachHangRepository.updateKH(kh);
        response.sendRedirect("/khach-hang/hien-thi");
    }
}
