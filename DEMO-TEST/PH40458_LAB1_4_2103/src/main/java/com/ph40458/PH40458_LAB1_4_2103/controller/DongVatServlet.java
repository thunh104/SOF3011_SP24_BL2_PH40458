package com.ph40458.PH40458_LAB1_4_2103.controller;

import com.ph40458.PH40458_LAB1_4_2103.entity.DongVat;
import com.ph40458.PH40458_LAB1_4_2103.service.DongVatService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DongVatServlet", value = {
        "/dong-vat/hien-thi-tat-ca",
        "/dong-vat/search",
        "/dong-vat/add",
        "/dong-vat/remove",
        "/dong-vat/view-update",
        "/dong-vat/update"
})
public class DongVatServlet extends HttpServlet {
    private List<DongVat> lists = new ArrayList<>();
    private DongVatService dongVatService = new DongVatService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi-tat-ca")) {
            this.hienThiDongVat(request, response);
        } else if (uri.contains("search")) {
            this.timKiemDongVat(request, response);
        } else if (uri.contains("remove")) {
            this.removeDongVat(request, response);
        } else {
            this.viewUpdateDongVat(request, response);
        }
    }

    private void viewUpdateDongVat(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeDongVat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        lists.remove(id);
        lists = dongVatService.getAll();
        request.setAttribute("dv", lists);
        request.getRequestDispatcher("/dong-vat.jsp").forward(request, response);
    }

    private void timKiemDongVat(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiDongVat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = dongVatService.getAll();
        request.setAttribute("dv", lists);
        request.getRequestDispatcher("/dong-vat.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateDongVat(request, response);
        } else {
            this.addDongVat(request, response);
        }
    }

    private void addDongVat(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        DongVat dv = new DongVat();
        BeanUtils.populate(dv, request.getParameterMap());
        request.setAttribute("dv2", lists);
        request.getRequestDispatcher("/dong-vat.jsp").forward(request, response);
    }

    private void updateDongVat(HttpServletRequest request, HttpServletResponse response) {
    }
}