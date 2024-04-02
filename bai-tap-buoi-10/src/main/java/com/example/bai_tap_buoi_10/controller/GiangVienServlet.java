package com.example.bai_tap_buoi_10.controller;

import com.example.bai_tap_buoi_10.entity.GiangVien;
import com.example.bai_tap_buoi_10.repository.GiangVienRepository;
import com.example.bai_tap_buoi_10.service.GiangVienService;
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

@WebServlet(name = "GiangVienServlet", value = {
        "/giang-vien/hien-thi-tat-ca",
        "/giang-vien/detail",
        "/giang-vien/remove",
        "/giang-vien/update",
        "/giang-vien/view-update",
        "/giang-vien/tim-kiem",
        "/giang-vien/add"
})
public class GiangVienServlet extends HttpServlet {
    private List<GiangVien> giangVienList = new ArrayList<>();
    private GiangVienRepository giangVienRepo = new GiangVienRepository();
    private GiangVienService giangVienService = new GiangVienService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi-tat-ca")) {
            this.hienThiGiangVien(request, response);
        } else if (uri.contains("detail")) {
            this.detailGiangVien(request, response);
        } else if (uri.contains("tim-kiem")) {
            this.timKiemGiangVien(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateGiangVien(request, response);
        } else {
            this.removeGiangVien(request, response);
        }
    }

    private void viewUpdateGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mssv = request.getParameter("mssv");
        GiangVien giangVien = giangVienService.detailGiangVien(mssv);
        request.setAttribute("gVien", giangVien);
        request.getRequestDispatcher("/update-giang-vien.jsp").forward(request, response);
    }

    private void removeGiangVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mssv = request.getParameter("mssv");
        GiangVien giangVien = giangVienService.detailGiangVien(mssv);
        giangVienService.removeGiangVien(giangVien);
        response.sendRedirect("/giang-vien/hien-thi-tat-ca");
    }

    private void timKiemGiangVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailGiangVien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String mssv = request.getParameter("mssv");
        GiangVien giangVien = giangVienService.detailGiangVien(mssv);
        request.setAttribute("gVien", giangVien);
        giangVienList = giangVienService.getAllGiangVien();
        request.setAttribute("gv", giangVienList);
        request.getRequestDispatcher("/giang-vien.jsp").forward(request, response);
    }

    private void hienThiGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        giangVienList = giangVienService.getAllGiangVien();
        request.setAttribute("gv", giangVienList);
        request.getRequestDispatcher("/giang-vien.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addGiangVien(request, response);
        } else {
            this.updateGiangVien(request, response);
        }
    }

    private void updateGiangVien(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException, ServletException {
        String mssv = request.getParameter("mssv");
        String ten = request.getParameter("ten");
        Long tuoi = Long.parseLong(request.getParameter("tuoi"));
        boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
        String queQuan = request.getParameter("queQuan");
        boolean check = false;

        if (mssv == null || mssv.isEmpty()) {
            request.setAttribute("checkMa", "Không được bỏ trống mã giảng viên !");
            check = true;
        }
        if (ten == null || ten.isEmpty()) {
            request.setAttribute("checkTen", "Không được bỏ trống tên giảng viên !");
            check = true;
        }
        if (tuoi == null || String.valueOf(tuoi).isEmpty()) {
            request.setAttribute("checkTuoi", "Không được bỏ trống tuổi của giảng viên !");
            check = true;
        }
        if (queQuan == null || queQuan.isEmpty()) {
            request.setAttribute("checkQueQuan", "Không được bỏ trống quê quán của giảng viên");
            check = true;
        }
        if (check) {
            request.getRequestDispatcher("/update-giang-vien.jsp").forward(request, response);
        } else {
            GiangVien gv = new GiangVien();
            BeanUtils.populate(gv, request.getParameterMap());
            giangVienService.updateGiangVien(gv);
            response.sendRedirect("/giang-vien/hien-thi-tat-ca");
        }
    }

    private void addGiangVien(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        String mssv = request.getParameter("mssv");
        String ten = request.getParameter("ten");
        Long tuoi = Long.parseLong(request.getParameter("tuoi"));
        boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
        String queQuan = request.getParameter("queQuan");
        boolean check = false;

        if (mssv == null || mssv.isEmpty()) {
            request.setAttribute("checkMa", "Không được bỏ trống mã giảng viên !");
            check = true;
        }
        if (ten == null || ten.isEmpty()) {
            request.setAttribute("chechTen", "Không được bỏ trống tên giảng viên !");
            check = true;
        }
        if (tuoi == null || String.valueOf(tuoi).isEmpty()) {
            request.setAttribute("checkTuoi", "Không được bỏ trống tuổi của giảng viên !");
            check = true;
        }
        if (queQuan == null || queQuan.isEmpty()) {
            request.setAttribute("checkQueQuan", "Không được bỏ trống quê quán của giảng viên");
            check = true;
        }
        if (check) {
            request.getRequestDispatcher("/giang-vien.jsp").forward(request, response);
        } else {
            GiangVien gv = new GiangVien();
            BeanUtils.populate(gv, request.getParameterMap());
            giangVienService.addGiangVien(gv);
            response.sendRedirect("/giang-vien/hien-thi-tat-ca");
        }
    }
}