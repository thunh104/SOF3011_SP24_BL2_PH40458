package com.example.asm_gd2.controller;

import com.example.asm_gd2.entity.ChucVu;
import com.example.asm_gd2.entity.CuaHang;
import com.example.asm_gd2.repository.ChucVuRepository;
import com.example.asm_gd2.repository.CuaHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/hien-thi",
        "/cua-hang/detail",
        "/cua-hang/update",
        "/cua-hang/remove",
        "/cua-hang/add",
        "/cua-hang/view-update"
})
public class CuaHangServlet extends HttpServlet {
    private List<CuaHang> listch = new ArrayList<>();
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiCuaHang(request, response);
        } else if (uri.contains("detail")) {
            this.detailCuaHang(request, response);
        } else if (uri.contains("remove")) {
            this.removeCuaHang(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateCuaHang(request, response);
        }
    }
    private void viewUpdateCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CuaHang ch = cuaHangRepository.getOne(Long.parseLong(id));
        request.setAttribute("updateCH", ch);
        request.getRequestDispatcher("/tai-khoan/update-chuc-vu.jsp").forward(request, response);
    }

    private void removeCuaHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        CuaHang ch = cuaHangRepository.getOne(Long.parseLong(id));
        cuaHangRepository.deleteCH(ch);
        response.sendRedirect("/cua-hang/hien-thi");
    }

    private void detailCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CuaHang ch = cuaHangRepository.getOne(Long.parseLong(id));
        request.setAttribute("detailCH", ch);
        listch = cuaHangRepository.getAll();
        request.setAttribute("cuaHang", listch);
        request.getRequestDispatcher("/cua-hang/cua-hang.jsp").forward(request, response);
    }

    private void hienThiCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listch = cuaHangRepository.getAll();
        request.setAttribute("cuaHang", listch);
        request.getRequestDispatcher("/cua-hang/cua-hang.jsp").forward(request, response);
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
        CuaHang ch = new CuaHang();
        BeanUtils.populate(ch, request.getParameterMap());
        cuaHangRepository.addCH(ch);
        response.sendRedirect("/cua-hang/hien-thi");
    }

    private void updateNSX(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        String id = request.getParameter("id");
        CuaHang ch = cuaHangRepository.getOne(Long.parseLong(id));
        BeanUtils.populate(ch, request.getParameterMap());
        cuaHangRepository.updateCH(ch);
        response.sendRedirect("/cua-hang/hien-thi");
    }
}
