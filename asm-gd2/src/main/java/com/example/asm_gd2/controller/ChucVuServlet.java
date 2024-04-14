package com.example.asm_gd2.controller;

import com.example.asm_gd2.entity.ChucVu;
import com.example.asm_gd2.entity.NhaSanXuat;
import com.example.asm_gd2.entity.SanPham;
import com.example.asm_gd2.repository.ChucVuRepository;
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

@WebServlet(name = "ChucVuServlet", value = {
        "/chuc-vu/hien-thi",
        "/chuc-vu/detail",
        "/chuc-vu/update",
        "/chuc-vu/remove",
        "/chuc-vu/add",
        "/chuc-vu/view-update"
})
public class ChucVuServlet extends HttpServlet {
    private List<ChucVu> listcv = new ArrayList<>();
    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiChucVu(request, response);
        } else if (uri.contains("detail")) {
            this.detailChucVu(request, response);
        } else if (uri.contains("remove")) {
            this.removeChucVu(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateChucVu(request, response);
        }
    }

    private void viewUpdateChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChucVu cv = chucVuRepository.getOne(Long.parseLong(id));
        request.setAttribute("updateCV", cv);
        request.getRequestDispatcher("/tai-khoan/update-chuc-vu.jsp").forward(request, response);
    }

    private void removeChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        ChucVu cv = chucVuRepository.getOne(Long.parseLong(id));
        chucVuRepository.deleteCV(cv);
        response.sendRedirect("/chuc-vu/hien-thi");
    }

    private void detailChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChucVu cv = chucVuRepository.getOne(Long.parseLong(id));
        request.setAttribute("detailCV", cv);
        listcv = chucVuRepository.getAll();
        request.setAttribute("chucVu", listcv);
        request.getRequestDispatcher("/tai-khoan/chuc-vu.jsp").forward(request, response);
    }

    private void hienThiChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listcv = chucVuRepository.getAll();
        request.setAttribute("chucVu", listcv);
        request.getRequestDispatcher("/tai-khoan/chuc-vu.jsp").forward(request, response);
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
        ChucVu cv = new ChucVu();
        BeanUtils.populate(cv, request.getParameterMap());
        chucVuRepository.addCV(cv);
        response.sendRedirect("/chuc-vu/hien-thi");
    }

    private void updateNSX(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        String id = request.getParameter("id");
        ChucVu cv = chucVuRepository.getOne(Long.parseLong(id));
        BeanUtils.populate(cv, request.getParameterMap());
        chucVuRepository.updateCV(cv);
        response.sendRedirect("/chuc-vu/hien-thi");
    }
}
