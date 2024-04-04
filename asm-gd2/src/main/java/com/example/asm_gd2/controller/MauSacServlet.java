package com.example.asm_gd2.controller;

import com.example.asm_gd2.entity.MauSac;
import com.example.asm_gd2.entity.SanPham;
import com.example.asm_gd2.repository.MauSacRepository;
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

@WebServlet(name = "MauSacServlet", value = {
        "/mau-sac/hien-thi",
        "/mau-sac/detail",
        "/mau-sac/update",
        "/mau-sac/remove",
        "/mau-sac/add",
        "/mau-sac/view-update"
})
public class MauSacServlet extends HttpServlet {
    private List<MauSac> listms = new ArrayList<>();
    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiMauSac(request, response);
        } else if (uri.contains("detail")) {
            this.detailMauSac(request, response);
        } else if (uri.contains("remove")) {
            this.removeMauSac(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateMauSac(request, response);
        }
    }
    private void viewUpdateMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MauSac ms = mauSacRepository.getOne(Long.parseLong(id));
        request.setAttribute("updateMS", ms);
        request.getRequestDispatcher("/mau-sac/update-mau-sac.jsp").forward(request, response);
    }

    private void removeMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        MauSac ms = mauSacRepository.getOne(Long.parseLong(id));
        mauSacRepository.deleteMS(ms);
        response.sendRedirect("/mau-sac/hien-thi");
    }

    private void detailMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MauSac ms = mauSacRepository.getOne(Long.parseLong(id));
        request.setAttribute("detailMS", ms);
        listms = mauSacRepository.getAll();
        request.setAttribute("mauSac", listms);
        request.getRequestDispatcher("/mau-sac/mau-sac.jsp").forward(request, response);
    }

    private void hienThiMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listms = mauSacRepository.getAll();
        request.setAttribute("mauSac", listms);
        request.getRequestDispatcher("/mau-sac/mau-sac.jsp").forward(request, response);
    }
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateMauSac(request, response);
        } else if (uri.contains("add")) {
            this.addMauSac(request, response);
        }
    }
    private void addMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        MauSac ms = new MauSac();
        BeanUtils.populate(ms, request.getParameterMap());
        mauSacRepository.addMS(ms);
        response.sendRedirect("/mau-sac/hien-thi");
    }

    private void updateMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        String id = request.getParameter("id");
        MauSac ms = mauSacRepository.getOne(Long.parseLong(id));
        BeanUtils.populate(ms, request.getParameterMap());
        mauSacRepository.updateMS(ms);
        response.sendRedirect("/mau-sac/hien-thi");
    }
}
