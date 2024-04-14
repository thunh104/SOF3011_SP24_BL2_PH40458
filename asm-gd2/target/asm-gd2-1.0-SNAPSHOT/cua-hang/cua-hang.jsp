<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/2/2024
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chức vụ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<div class="container">
    <div class="container mt-2">
        <ul class="nav nav-pills">
            <li class="nav-item">
                <a class="nav-link" href="/san-pham/hien-thi">Sản phẩm</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/hoa-don/hien-thi">Hoá đơn</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/mau-sac/hien-thi">Màu sắc</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/chuc-vu/hien-thi">Chức vụ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/nha-san-xuat/hien-thi">Nhà sản xuất</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/khach-hang/hien-thi">Khách hàng</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/chi-tiet-san-pham/hien-thi">Chi tiết sản phẩm</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/cua-hang/hien-thi">Cửa hàng</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/dong-san-pham/hien-thi">Dòng sản phẩm</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/gio-hang/hien-thi">Giỏ hàng</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/gio-hang-chi-tiet/hien-thi">Giỏ hàng chi tiết</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/hoa-don-chi-tiet/hien-thi">Hóa đơn chi tiết</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/nhan-vien/hien-thi">Nhân viên</a>
            </li>
        </ul>
    </div>
    <br>
    <div class="row col-12 mt-3 mb-3">
        <div class="col-12 fs-4 fw-semibold">Bộ lọc</div>
        <hr>
        <div class="mb-3 col-6">
            <label for="inputSearch" class="form-label">Tìm kiếm</label>
            <input type="text" class="form-control" id="inputSearch"
                   placeholder="Tìm kiếm theo cửa hàng">
        </div>
        <div class="mb-3 col-6">
            <label for="inputSearch" class="form-label">Trạng thái</label>
            <select class="form-select" aria-label="Default select example">
                <option value="Đang hoạt động">Đang hoạt động</option>
                <option value="Dừng hoạt động">Dừng hoạt động</option>
            </select>
        </div>
    </div>
    <div class="row col-12 mt-3">
        <div class="col-10 fs-4 fw-semibold">Cửa hàng</div>
        <hr>
    </div>
    <form action="/cua-hang/add" method="post">
        <div class="row col-12">
            <div class="mb-3 col-6">
                <label for="inputMa" class="form-label">Mã cửa hàng</label>
                <input type="text" class="form-control" id="inputMa" name="ma" value="${detailCH.ma}">
            </div>
            <div class="mb-3 col-6">
                <label for="inputTen" class="form-label">Tên cửa hàng</label>
                <input type="text" class="form-control" id="inputTen" name="ten" value="${detailCH.ten}">
            </div>
            <div class="mb-3 col-6">
                <label for="inputDiaChi" class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" id="inputDiaChi" name="diaChi" value="${detailCH.diaChi}">
            </div>
            <div class="mb-3 col-6">
                <label for="inputThanhPho" class="form-label">Thành phố</label>
                <input type="text" class="form-control" id="inputThanhPho" name="thanhPho" value="${detailCH.thanhPho}">
            </div>
            <div class="mb-3 col-6">
                <label for="inputQuocGia" class="form-label">Quốc gia</label>
                <input type="text" class="form-control" id="inputQuocGia" name="quocGia" value="${detailCH.quocGia}">
            </div>
        </div>
        <div class="text-content">
            <button class="btn btn-outline-success" type="submit">Thêm mới</button>
        </div>
    </form>
    <table class="table me-3">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã cửa hàng</th>
            <th>Tên cửa hàng</th>
            <th>Địa chỉ</th>
            <th>Thành phố</th>
            <th>Quốc gia</th>
            <th colspan="3">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cuaHang}" var="ch">
            <tr>
                <td>${ch.id}</td>
                <td>${ch.ma}</td>
                <td>${ch.ten}</td>
                <td>${ch.diaChi}</td>
                <td>${ch.thanhPho}</td>
                <td>${ch.quocGia}</td>
                <td>
                    <a href="/cua-hang/detail?id=${ch.id}"><i class="bi bi-eye me-2"></i></a>
                    <a href="/cua-hang/view-update?id=${ch.id}"><i class="bi bi-pencil-square ms-4 me-4"></i></a>
                    <a href="/cua-hang/remove?id=${ch.id}"><i class="bi bi-trash3 ms-2"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
