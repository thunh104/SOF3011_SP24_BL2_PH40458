<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/2/2024
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sản phẩm</title>
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
                   placeholder="Tìm kiếm theo sản phẩm...">
        </div>
        <div class="mb-3 col-6">
            <label for="inputSearch" class="form-label">Trạng thái</label>
            <select class="form-select" aria-label="Default select example">
                <option value="Đang hoạt động">Đang hoạt động</option>
                <option value="Dừng hoạt động">Dừng hoạt động</option>
            </select>
        </div>
    </div>
    <div class="row col-12 mt-3 mb-3">
        <div class="col-10 fs-4 fw-semibold">Sản phẩm</div>
    </div>
    <form action="/san-pham/add" method="post">
        <div class="container row col-12">
            <div class="mb-3 col-6">
                <label for="inputMa" class="form-label">Mã sản phẩm</label>
                <input type="text" class="form-control" id="inputMa" name="ma" value="${detailSP.ma}">
            </div>
            <div class="mb-3 col-6">
                <label for="inputTen" class="form-label">Tên sản phẩm</label>
                <input type="text" class="form-control" id="inputTen" name="ten" value="${detailSP.ten}">
            </div>
        </div>
        <div class="container text-content">
            <button class="btn btn-outline-success" type="submit">Thêm mới</button>
        </div>
    </form>
    <table class="table ms-2 me-3">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th colspan="3">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sanPham}" var="sp">
            <tr>
                <td>${sp.id}</td>
                <td>${sp.ma}</td>
                <td>${sp.ten}</td>
                <td>
                    <a href="/san-pham/detail?id=${sp.id}"><i class="bi bi-eye me-2"></i></a>
                    <a href="/san-pham/view-update?id=${sp.id}"><i class="bi bi-pencil-square ms-4 me-4"></i></a>
                    <a href="/san-pham/remove?id=${sp.id}"><i class="bi bi-trash3 ms-2"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
