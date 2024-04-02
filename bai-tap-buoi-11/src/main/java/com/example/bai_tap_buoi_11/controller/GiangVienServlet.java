package com.example.bai_tap_buoi_11.controller;

import com.example.bai_tap_buoi_11.entity.GiangVien;
import com.example.bai_tap_buoi_11.repository.GiangVienRepository;
import com.example.bai_tap_buoi_11.service.GiangVienService;
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
        "/giang-vien/hien-thi", //get
        "/giang-vien/search", //get
        "/giang-vien/giang-vien-nu", //get
        "/giang-vien/remove", //get
        "/giang-vien/view-update", //get
        "/giang-vien/detail", //get
        "/giang-vien/update", //post
        "/giang-vien/view-add", //get
        "/giang-vien/add" //post
})
public class GiangVienServlet extends HttpServlet {
    private List<GiangVien> giangVienList = new ArrayList<>();
    private GiangVienService giangVienService = new GiangVienService();
    private GiangVienRepository giangVienRepository = new GiangVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiGiangVien(request, response);
        } else if (uri.contains("search")) {
            this.searchGiangVien(request, response);
        } else if (uri.contains("giang-vien-nu")) {
            this.searchGiangVienNu(request, response);
        } else if (uri.contains("remove")) {
            this.removeGiangVien(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateGiangVien(request, response);
        } else if (uri.contains("detail")) {
            this.detailGiangVien(request, response);
        } else {
            this.viewAddGiangVien(request, response);
        }
    }

    private void viewAddGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/btvn11/add-giang-vien.jsp").forward(request, response);
    }

    private void searchGiangVienNu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        GiangVien gv = giangVienRepository.getOne(ma);
        request.setAttribute("gvl", gv);
        giangVienList = giangVienRepository.getAll();
        request.setAttribute("hienThi", giangVienList);
        request.getRequestDispatcher("/btvn11/detail-giang-vien.jsp").forward(request, response);

    }

    private void searchGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void viewUpdateGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        GiangVien gv = giangVienRepository.getOne(ma);
        request.setAttribute("gvl", gv);
        giangVienList = giangVienRepository.getAll();
        request.setAttribute("hienThi", giangVienList);
        request.getRequestDispatcher("/btvn11/update-giang-vien.jsp").forward(request, response);
    }

    private void removeGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        GiangVien gv = giangVienRepository.getOne(ma);
        giangVienRepository.delete(gv);
        response.sendRedirect(request.getContextPath() + "/giang-vien/hien-thi");
    }

    private void giangvienNu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/btvn11/add-giang-vien.jsp").forward(request, response);
    }

    private void hienThiGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        giangVienList = giangVienRepository.getAll();
        request.setAttribute("hienThi", giangVienList);
        request.getRequestDispatcher("/btvn11/giang-vien.jsp").forward(request, response);
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

    private void addGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String gioiTinh = request.getParameter("gioiTinh");
        String diaChi = request.getParameter("diaChi");
        if (ma == null || ma.isEmpty()) {
            request.setAttribute("checkMa", "Không bỏ trống mã của giảng viên");
            request.getRequestDispatcher("/btvn11/add-giang-vien.jsp").forward(request, response);
        }
        if (ten == null || ten.isEmpty()) {
            request.setAttribute("checkTen", "Không bỏ trống tên của giảng viên");
            request.getRequestDispatcher("/btvn11/add-giang-vien.jsp").forward(request, response);
        }
        if (String.valueOf(tuoi) == null || String.valueOf(tuoi).isEmpty()) {
            request.setAttribute("checkTuoi", "Không bỏ trống tuổi của giảng viên");
            request.getRequestDispatcher("/btvn11/add-giang-vien.jsp").forward(request, response);
        }
        if (diaChi == null || diaChi.isEmpty()) {
            request.setAttribute("checkDiaChi", "Không bỏ trống địa chỉ của giảng viên");
            request.getRequestDispatcher("/btvn11/add-giang-vien.jsp").forward(request, response);
        } else {
            GiangVien gvien = new GiangVien();
            BeanUtils.populate(gvien, request.getParameterMap());
            giangVienService.addGiangVien(gvien);
            giangVienList = giangVienService.getAllGiangVien();
            request.setAttribute("gv", giangVienList);
            response.sendRedirect("/giang-vien/hien-thi");
        }
    }

    private void updateGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String gioiTinh = request.getParameter("gioiTinh");
        String diaChi = request.getParameter("diaChi");
        if (ma == null || ma.isEmpty()) {
            request.setAttribute("checkMa", "Không bỏ trống mã của giảng viên");
            request.getRequestDispatcher("/btvn11/add-giang-vien.jsp").forward(request, response);
        }
        if (ten == null || ten.isEmpty()) {
            request.setAttribute("checkTen", "Không bỏ trống tên của giảng viên");
            request.getRequestDispatcher("/btvn11/add-giang-vien.jsp").forward(request, response);
        }
        if (String.valueOf(tuoi) == null || String.valueOf(tuoi).isEmpty()) {
            request.setAttribute("checkTuoi", "Không bỏ trống tuổi của giảng viên");
            request.getRequestDispatcher("/btvn11/add-giang-vien.jsp").forward(request, response);
        }
        if (diaChi == null || diaChi.isEmpty()) {
            request.setAttribute("checkDiaChi", "Không bỏ trống địa chỉ của giảng viên");
            request.getRequestDispatcher("/btvn11/add-giang-vien.jsp").forward(request, response);
        } else {
            GiangVien gvien = new GiangVien();
            BeanUtils.populate(gvien, request.getParameterMap());
            giangVienService.updateGiangVien(gvien);
            giangVienList = giangVienService.getAllGiangVien();
            request.setAttribute("gv", giangVienList);
            response.sendRedirect("/giang-vien/hien-thi");
        }
    }
}



