package com.example.bai_tap_buoi_6.controller;

import com.example.bai_tap_buoi_6.entity.GiangVien;
import com.example.bai_tap_buoi_6.service.GiangVienService;
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
        "/giang-vien/hien-thi-tat-ca", //GET
        "/giang-vien/detail", //GET
        "/giang-vien/remove", //GET
        "/giang-vien/update", //POST
        "/giang-vien/tim-kiem", //GET
        "/giang-vien/add", //POST
        "/giang-vien/view-update"
})
public class GiangVienServlet extends HttpServlet {
    private GiangVienService giangVienService = new GiangVienService();
    private List<GiangVien> lists = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi-tat-ca")) {
            this.hienThiGiangVien(request, response);
        } else if (uri.contains("detail")) {
            this.detailGiangVien(request, response);
        } else if (uri.contains("remove")) {
            this.removeGiangVien(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateGiangVien(request, response);
        } else {
            this.timKiemGiangVien(request, response);
        }
    }

    private void viewUpdateGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maGV = request.getParameter("maGV");
        GiangVien gv = giangVienService.detail(maGV);
        request.setAttribute("gv1", gv);
        request.getRequestDispatcher("/update-giang-vien.jsp").forward(request, response);
    }

    private void timKiemGiangVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeGiangVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maGV");
        giangVienService.remove(ma);
        response.sendRedirect("/giang-vien/hien-thi-tat-ca");
    }

    private void detailGiangVien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("maGV");
        GiangVien gv = giangVienService.detail(ma);
        lists = giangVienService.getAll();
        request.setAttribute("gv1", gv);
        request.setAttribute("gv", lists);
        request.getRequestDispatcher("/giang-vien.jsp").forward(request, response);
    }

    private void hienThiGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = giangVienService.getAll();
        request.setAttribute("gv", lists);
        request.getRequestDispatcher("/giang-vien.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateGiangVien(request, response);
        } else {
            this.addGiangVien(request, response);
        }
    }

    private void addGiangVien(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException, ServletException {
        String maGV = request.getParameter("maGV");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String queQuan = request.getParameter("queQuan");

        boolean check = false;

        if (maGV == null || maGV.isEmpty()) {
            request.setAttribute("checkMa", "Không được bỏ trống mã giảng viên !");
            check = true;
        }
        if (ten == null || ten.isEmpty()) {
            request.setAttribute("chechTen", "Không được bỏ trống tên giảng viên !");
            check = true;
        }
        if (tuoi == null || tuoi.isEmpty()) {
            request.setAttribute("checkTuoi", "Không được bỏ trống tuổi của giảng viên !");
            check = true;
        } else {
            try {
                int age = Integer.parseInt(tuoi);
                if (age <= 25) {
                    request.setAttribute("checkTuoi25", "Tuổi của giảng viên phải >25 !");
                    check = true;
                }
            } catch (NumberFormatException e) {
                request.setAttribute("checkTuoi", "Không được bỏ trống tuổi của giảng viên !");
                check = true;
            }
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
            giangVienService.add(gv);
            response.sendRedirect("/giang-vien/hien-thi-tat-ca");
        }
    }

    private void updateGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String maGV = request.getParameter("maGV");
        String ten = request.getParameter("ten");
        int tuoi = Integer.parseInt(request.getParameter("tuoi"));
        String queQuan = request.getParameter("queQuan");
        GiangVien gv = new GiangVien(maGV, ten, tuoi, queQuan);
        giangVienService.update(maGV, gv);
        response.sendRedirect("/giang-vien/hien-thi-tat-ca");
    }
}