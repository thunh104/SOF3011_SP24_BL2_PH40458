package com.example.de_thi_thu_01.controller;

import com.example.de_thi_thu_01.entity.Ban;
import com.example.de_thi_thu_01.repository.BanRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BanServlet", value = {
        "/ban/hien-thi",
        "/ban/add",
        "/ban/detail",
        "/ban/remove",
        "/ban/update",
        "/ban/view-update"
})
public class BanServlet extends HttpServlet {
    private List<Ban> lists = new ArrayList<>();
    private BanRepository banRepository = new BanRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiBan(request, response);
        } else if (uri.contains("detail")) {
            this.detailBan(request, response);
        } else if (uri.contains("remove")) {
            this.removeBan(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateBan(request, response);
        }
    }

    private void viewUpdateBan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Ban ban = banRepository.getOne(id);
        request.setAttribute("updateBan", lists);
        request.getRequestDispatcher("/thi-thu/update-ban.jsp").forward(request, response);
    }

    private void removeBan(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Ban ban = banRepository.getOne(Long.parseLong(id));
        banRepository.deleteBan(ban);
        response.sendRedirect("/ban/hien-thi");
    }

    private void hienThiBan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = banRepository.getAll();
        request.setAttribute("ban", lists);
        request.getRequestDispatcher("/thi-thu/ban.jsp").forward(request, response);
    }

    private void detailBan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Ban ban = banRepository.getOne(Long.parseLong(id));
        request.setAttribute("detailBan", ban);
        lists = banRepository.getAll();
        request.setAttribute("ban", lists);
        request.getRequestDispatcher("/thi-thu/ban.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addBan(request, response);
        } else if (uri.contains("update")) {
            this.updateBan(request, response);
        }
    }

    private void updateBan(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Ban ban = banRepository.getOne(id);
        BeanUtils.populate(ban, request.getParameterMap());
        banRepository.updateBan(ban);
        response.sendRedirect("/ban/hien-thi");

    }

    private void addBan(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Ban ban = new Ban();
        BeanUtils.populate(ban, request.getParameterMap());
        banRepository.addBan(ban);
        response.sendRedirect("/ban/hien-thi");
    }
}
