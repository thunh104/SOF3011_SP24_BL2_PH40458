package com.example.de_thi_thu_05.controller;

import com.example.de_thi_thu_05.entity.XeMay;
import com.example.de_thi_thu_05.repository.XeMayRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "XeMayServlet", value = {
        "/xe-may/hien-thi",
        "/xe-may/add",
        "/xe-may/detail",
        "/xe-may/remove",
        "/xe-may/view-update",
        "/xe-may/update"
})
public class XeMayServlet extends HttpServlet {
    private List<XeMay> xeMayList = new ArrayList<>();
    private XeMayRepository repository = new XeMayRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiXM(request, response);
        } else if (uri.contains("remove")) {
            this.removeXM(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("detail")) {
            this.detailXM(request, response);
        }
    }

    private void hienThiXM(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        xeMayList = repository.getAll();
        request.setAttribute("hienThiXM", xeMayList);
        request.getRequestDispatcher("/de-thi/xe-may.jsp").forward(request, response);
    }

    private void removeXM(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        XeMay xeMay = repository.getOne(Long.parseLong(id));
        repository.deleteXM(xeMay);
        response.sendRedirect("/xe-may/hien-thi");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        XeMay xeMay = repository.getOne(Long.parseLong(id));
        request.setAttribute("updateXM", xeMay);
        request.getRequestDispatcher("/de-thi/update-xe-may.jsp").forward(request, response);
    }

    private void detailXM(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        XeMay xeMay = repository.getOne(Long.parseLong(id));
        request.setAttribute("detailXM", xeMay);
        request.getRequestDispatcher("/de-thi/xe-may.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addXM(request, response);
        } else if (uri.contains("update")) {
            this.updateXM(request, response);
        }
    }

    private void addXM(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        XeMay xm = new XeMay();
        BeanUtils.populate(xm, request.getParameterMap());
        repository.addXM(xm);
        response.sendRedirect("/xe-may/hien-thi");
    }

    private void updateXM(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        String id = request.getParameter("id");
        XeMay xeMay = repository.getOne(Long.parseLong(id));
        BeanUtils.populate(xeMay, request.getParameterMap());
        repository.updateXM(xeMay);
        response.sendRedirect("/xe-may/hien-thi");
    }
}
