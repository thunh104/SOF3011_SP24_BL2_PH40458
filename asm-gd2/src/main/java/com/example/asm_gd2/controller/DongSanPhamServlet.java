package com.example.asm_gd2.controller;

import com.example.asm_gd2.entity.ChucVu;
import com.example.asm_gd2.entity.DongSanPham;
import com.example.asm_gd2.repository.ChucVuRepository;
import com.example.asm_gd2.repository.DongSanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DongSanPhamServlet", value = {
        "/dong-san-pham/hien-thi",
        "/dong-san-pham/detail",
        "/dong-san-pham/update",
        "/dong-san-pham/remove",
        "/dong-san-pham/add",
        "/dong-san-pham/view-update"
})
public class DongSanPhamServlet extends HttpServlet {
    private List<DongSanPham> listdsp = new ArrayList<>();
    private DongSanPhamRepository dongSanPhamRepository = new DongSanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiDongSP(request, response);
        } else if (uri.contains("detail")) {
            this.detailDongSP(request, response);
        } else if (uri.contains("remove")) {
            this.removeDongSP(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateDongSP(request, response);
        }
    }

    private void viewUpdateDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DongSanPham dsp = dongSanPhamRepository.getOne(Long.parseLong(id));
        request.setAttribute("updateDSP", dsp);
        request.getRequestDispatcher("/san-pham/update-dong-san-pham.jsp").forward(request, response);
    }

    private void removeDongSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        DongSanPham dsp = dongSanPhamRepository.getOne(Long.parseLong(id));
        dongSanPhamRepository.deleteDSP(dsp);
        response.sendRedirect("/dong-san-pham/hien-thi");
    }

    private void detailDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DongSanPham dsp = dongSanPhamRepository.getOne(Long.parseLong(id));
        request.setAttribute("detailDSP", dsp);
        listdsp = dongSanPhamRepository.getAll();
        request.setAttribute("dongSP", listdsp);
        request.getRequestDispatcher("/san-pham/dong-san-pham.jsp").forward(request, response);
    }

    private void hienThiDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listdsp = dongSanPhamRepository.getAll();
        request.setAttribute("dongSP", listdsp);
        request.getRequestDispatcher("/san-pham/dong-san-pham.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateDSP(request, response);
        } else if (uri.contains("add")) {
            this.addDSP(request, response);
        }
    }

    private void addDSP(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        DongSanPham dsp = new DongSanPham();
        BeanUtils.populate(dsp, request.getParameterMap());
        dongSanPhamRepository.addDSP(dsp);
        response.sendRedirect("/dong-san-pham/hien-thi");
    }

    private void updateDSP(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        String id = request.getParameter("id");
        DongSanPham dsp = dongSanPhamRepository.getOne(Long.parseLong(id));
        BeanUtils.populate(dsp, request.getParameterMap());
        dongSanPhamRepository.updateDSP(dsp);
        response.sendRedirect("/dong-san-pham/hien-thi");
    }
}
