package com.example.asm_gd2.controller;

import com.example.asm_gd2.entity.NhaSanXuat;
import com.example.asm_gd2.entity.SanPham;
import com.example.asm_gd2.repository.NhaSanXuatRepository;
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

@WebServlet(name = "NhaSanXuatServlet", value = {
        "/nha-san-xuat/hien-thi",
        "/nha-san-xuat/detail",
        "/nha-san-xuat/update",
        "/nha-san-xuat/remove",
        "/nha-san-xuat/add",
        "/nha-san-xuat/view-update"
})
public class NhaSanXuatServlet extends HttpServlet {
    private List<NhaSanXuat> listnsx = new ArrayList<>();
    private NhaSanXuatRepository nhaSanXuatRepository = new NhaSanXuatRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiNSX(request, response);
        } else if (uri.contains("detail")) {
            this.detailNSX(request, response);
        } else if (uri.contains("remove")) {
            this.removeNSX(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateNSX(request, response);
        }
    }

    private void viewUpdateNSX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhaSanXuat nsx = nhaSanXuatRepository.getOne(Long.parseLong(id));
        request.setAttribute("updateNSX", nsx);
        request.getRequestDispatcher("/san-pham/update-nha-san-xuat.jsp").forward(request, response);
    }

    private void removeNSX(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        NhaSanXuat nsx = nhaSanXuatRepository.getOne(Long.parseLong(id));
        nhaSanXuatRepository.deleteNSX(nsx);
        response.sendRedirect("/nha-san-xuat/hien-thi");
    }

    private void detailNSX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhaSanXuat nsx = nhaSanXuatRepository.getOne(Long.parseLong(id));
        request.setAttribute("detailNSX", nsx);
        listnsx = nhaSanXuatRepository.getAll();
        request.setAttribute("nhaSanXuat", listnsx);
        request.getRequestDispatcher("/san-pham/nha-san-xuat.jsp").forward(request, response);
    }

    private void hienThiNSX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listnsx = nhaSanXuatRepository.getAll();
        request.setAttribute("nhaSanXuat", listnsx);
        request.getRequestDispatcher("/san-pham/nha-san-xuat.jsp").forward(request, response);
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
        NhaSanXuat nsx = new NhaSanXuat();
        BeanUtils.populate(nsx, request.getParameterMap());
        nhaSanXuatRepository.addNSX(nsx);
        response.sendRedirect("/nha-san-xuat/hien-thi");
    }

    private void updateNSX(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        String id = request.getParameter("id");
        NhaSanXuat nsx = nhaSanXuatRepository.getOne(Long.parseLong(id));
        BeanUtils.populate(nsx, request.getParameterMap());
        nhaSanXuatRepository.updateNSX(nsx);
        response.sendRedirect("/nha-san-xuat/hien-thi");
    }
}
