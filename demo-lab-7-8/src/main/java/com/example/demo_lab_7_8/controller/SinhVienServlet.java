package com.example.demo_lab_7_8.controller;

import com.example.demo_lab_7_8.entity.SinhVien;
import com.example.demo_lab_7_8.repository.SinhVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/update",
        "/sinh-vien/detail",
        "/sinh-vien/remove",
        "/sinh-vien/add",
        "/sinh-vien/view-update"
})
public class SinhVienServlet extends HttpServlet {
    private List<SinhVien> listsv = new ArrayList<>();
    private SinhVienRepository repo = new SinhVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiSV(request, response);
        } else if (uri.contains("detail")) {
            this.detailSV(request, response);
        } else if (uri.contains("remove")) {
            this.removeSV(request, response);
        } else {
            this.viewUpdateSV(request, response);
        }
    }

    private void viewUpdateSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SinhVien sv = repo.getOne(Long.parseLong(id));
        request.setAttribute("sv", sv);
        request.getRequestDispatcher("/lab/update-sinh-vien.jsp").forward(request, response);
    }

    private void removeSV(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        SinhVien sv = repo.getOne(Long.parseLong(id));
        repo.deleteSV(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void detailSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SinhVien sv = repo.getOne(Long.parseLong(id));
        request.setAttribute("sv", sv);
        listsv = repo.getAll();
        request.setAttribute("htsv", listsv);
        request.getRequestDispatcher("/lab/sinh-vien.jsp").forward(request, response);
    }

    private void hienThiSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listsv = repo.getAll();
        request.setAttribute("htsv", listsv);
        request.getRequestDispatcher("/lab/sinh-vien.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateSV(request, response);
        } else {
            this.addSV(request, response);
        }
    }

    private void addSV(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        SinhVien sv = new SinhVien();
        BeanUtils.populate(sv, request.getParameterMap());
        repo.addSV(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void updateSV(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        String id = request.getParameter("id");
        SinhVien sv = repo.getOne(Long.parseLong(id));
        BeanUtils.populate(sv, request.getParameterMap());
        repo.updateSV(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }
}
