package com.example.buoi_4.controller;

import com.example.buoi_4.entity.SinhVien;
import com.example.buoi_4.service.SinhVienService;
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

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi", //get
        "/sinh-vien/search", //get
        "/sinh-vien/remove", //get
        "/sinh-vien/detail", //get
        "/sinh-vien/view-update", //get
        "/sinh-vien/update", //post
        "/sinh-vien/view-add", //get
        "/sinh-vien/add" //post
})
public class SinhVienServlet extends HttpServlet {
    private SinhVienService sinhVienService = new SinhVienService();
    private List<SinhVien> lists = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //B1: Lấy ra đường dẫn trên url
        String uri = request.getRequestURI();

        //B2: Kiểm tra thuộc url nào trong những cái có sẵn
        if (uri.contains("hien-thi")) {
            //Thực hiện chức năng hiển thị
            this.hienThiSinhVien(request, response);
        } else if (uri.contains("search")) {
            //Thực hiện chức năng tìm kiếm
            this.searchSinhVien(request, response);
        } else if (uri.contains("remove")) {
            //Thực hiện chức năng xóa
            this.removeSinhVien(request, response);
        } else if (uri.contains("detail")) {
            //Thực hiện chức năng xem chi tiết
            this.detailSinhVien(request, response);
        } else if (uri.contains("view-update")) {
            //Thực hiện chức năng xem update
            this.viewUpdateSinhVien(request, response);
        } else {
            //Thực hiện chức năng xem thêm
            this.viewAddSinhVien(request, response);
        }
    }

    private void viewAddSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/add-sinh-vien.jsp").forward(request, response);
    }

    private void viewUpdateSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mssv = request.getParameter("mssv");
        SinhVien sv = sinhVienService.detail(mssv);
        request.setAttribute("sv1", sv);
        request.getRequestDispatcher("/update-sinh-vien.jsp").forward(request, response);
    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mssv = request.getParameter("mssv");
        SinhVien sv = sinhVienService.detail(mssv);
        request.setAttribute("sv1", sv);
        request.getRequestDispatcher("/detail-sinh-vien.jsp").forward(request, response);
    }

    private void removeSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mssv = request.getParameter("mssv");
        sinhVienService.remove(mssv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void searchSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = sinhVienService.getAll(); //fake data: 6
        request.setAttribute("a", lists);
        request.getRequestDispatcher("/sinhviens.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //B1: Lấy ra đường dẫn trên url
        String uri = request.getRequestURI();

        //B2: Kiểm tra thuộc url nào trong những cái có sẵn
        if (uri.contains("update")) {
            //Thực hiện chức năng chỉnh sửa
            this.updateSinhVien(request, response);

        } else {
            //Thực hiện chức năng thêm
            this.addSinhVien(request, response);

        }
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //C1:
        //B1: Lấy dữ liệu từ jsp về servlet
//        String maSV = request.getParameter("mssv");
//        String ten = request.getParameter("ten");
//        String tuoi = request.getParameter("tuoi");
//        String diaChi = request.getParameter("diaChi");
//        String gioiTinh = request.getParameter("gioiTinh");

        //B2: Khởi tạo một đối tượng (constructor => new)
//        SinhVien sv = SinhVien.builder()
//                .gioiTinh(Boolean.valueOf(gioiTinh))
//                .maSV(maSV)
//                .tenSV(ten)
//                .tuoi(Integer.valueOf(tuoi))
//                .diaChi(diaChi)
//                .build(); //constructor không tham số

        //B3: Gọi service
//        sinhVienService.add(sv);
//        lists = sinhVienService.getAll(); //fake data: 6
//        request.setAttribute("a", lists);
//        request.getRequestDispatcher("/sinhviens.jsp").forward(request, response);
//        or
//        response.sendRedirect("/sinh-vien/hien-thi");

        //C2: BeanUtil
        SinhVien sv = new SinhVien();
        BeanUtils.populate(sv, request.getParameterMap()); //= line 103-116
        sinhVienService.add(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }
}