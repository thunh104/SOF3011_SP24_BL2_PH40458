package com.example.de_thi_thu_04.controller;

import com.example.de_thi_thu_04.entity.NhanVien;
import com.example.de_thi_thu_04.repository.NhanVienRepository;
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
        "/nhan-vien/add",
        "/nhan-vien/detail",
        "/nhan-vien/update",
        "/nhan-vien/view-update",
        "/nhan-vien/remove"
})
public class NhanVienServlet extends HttpServlet {
    private List<NhanVien> listnv = new ArrayList<>();
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiNV(request, response);
        } else if (uri.contains("detail")) {
            this.detailNV(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateNV(request, response);
        } else if (uri.contains("remove")) {
            this.removeNV(request, response);
        }
    }

    private void hienThiNV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listnv = nhanVienRepository.getAll();
        request.setAttribute("htNV", listnv);
        request.getRequestDispatcher("/nhan-vien.jsp").forward(request, response);
    }

    private void detailNV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhanVien nv = nhanVienRepository.getOne(Long.parseLong(id));
        request.setAttribute("detailNV", nv);
        listnv = nhanVienRepository.getAll();
        request.setAttribute("htNV", listnv);
        request.getRequestDispatcher("/nhan-vien.jsp").forward(request, response);
    }

    private void viewUpdateNV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhanVien nv = nhanVienRepository.getOne(Long.parseLong(id));
        request.setAttribute("updateNV", nv);
        request.getRequestDispatcher("/update-nhan-vien.jsp").forward(request, response);
    }

    private void removeNV(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        NhanVien nv = nhanVienRepository.getOne(Long.parseLong(id));
        nhanVienRepository.deleteNV(nv);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addNV(request, response);
        } else if (uri.contains("update")) {
            this.updateNV(request, response);
        }
    }

    private void addNV(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        NhanVien nv = new NhanVien();
        BeanUtils.populate(nv, request.getParameterMap());
        nhanVienRepository.addNV(nv);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    private void updateNV(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        String id = request.getParameter("id");
        NhanVien nv = nhanVienRepository.getOne(Long.parseLong(id));
        BeanUtils.populate(nv, request.getParameterMap());
        nhanVienRepository.updateNV(nv);
        response.sendRedirect("/nhan-vien/hien-thi");
    }
}
