package com.hangnt169.demo.controller;

import com.hangnt169.demo.entity.SanPham;
import com.hangnt169.demo.repository.SanPhamRepository;
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

/**
 * @author hangnt169
 */
@WebServlet(name = "SanPhamServlet", value = {
        "/may-tinh/hien-thi",
        "/may-tinh/detail",
        "/may-tinh/view-update",
        "/may-tinh/update",
        "/may-tinh/add",
        "/may-tinh/remove"
})
public class SanPhamServlet extends HttpServlet {
    private List<SanPham> sanPhamList = new ArrayList<>();
    private SanPhamRepository repo = new SanPhamRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiMayTinh(request, response);
        } else if (uri.contains("detail")) {
            this.detailMayTinh(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateMayTinh(request, response);
        } else {
            this.removeMayTinh(request, response);
        }
    }

    private void hienThiMayTinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SanPham> listSP = repo.getAll();
        request.setAttribute("lists", listSP);
        request.getRequestDispatcher("/view/san-pham.jsp").forward(request, response);
    }

    private void detailMayTinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sp = repo.getOne(Integer.valueOf(id));
        request.setAttribute("sanPham", sp);
        List<SanPham> listSP = repo.getAll();
        request.setAttribute("lists", listSP);
        request.getRequestDispatcher("/view/san-pham.jsp").forward(request, response);
    }

    private void viewUpdateMayTinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sp = repo.getOne(Integer.valueOf(id));
        request.setAttribute("sanPham", sp);
        request.getRequestDispatcher("/view/update-san-pham.jsp").forward(request, response);
    }

    private void removeMayTinh(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        SanPham sp = repo.getOne(Integer.valueOf(id));
        repo.delete(sp);
        response.sendRedirect("/may-tinh/hien-thi");
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addMayTinh(request, response);
        } else {
            this.updateMayTinh(request, response);
        }
    }

    private void addMayTinh(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        SanPham sanPham = new SanPham();
        BeanUtils.populate(sanPham, request.getParameterMap());
        repo.addOrUpdate(sanPham);
        response.sendRedirect("/may-tinh/hien-thi");
    }

    private void updateMayTinh(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        SanPham sanPham =
        response.sendRedirect("/may-tinh/hien-thi");
    }
}
