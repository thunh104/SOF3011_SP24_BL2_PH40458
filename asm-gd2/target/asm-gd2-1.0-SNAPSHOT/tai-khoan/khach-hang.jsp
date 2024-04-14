<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/2/2024
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Khách hàng</title>
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
                   placeholder="Tìm kiếm theo tên và số điện thoại...">
        </div>
        <div class="mb-3 col-6">
            <label for="inputSearch" class="form-label">Trạng thái</label>
            <select class="form-select" aria-label="Default select example">
                <option value="Đang hoạt động">Đang hoạt động</option>
                <option value="Dừng hoạt động">Dừng hoạt động</option>
            </select>
        </div>
    </div>
    <div class="row col-12">
        <div class="col-12">
            <label class="form-label">Thành phố</label>
            <select class="form-select" aria-label="Default select example">
                <option value="Hà Nội">Hà Nội</option>
                <option value="Hồ Chí Minh">Hồ Chí Minh</option>
                <option value="Hà Giang">Hà Giang</option>
                <option value="Hải Phòng">Hải Phòng</option>
                <option value="Hải Dương">Hải Dương</option>
            </select>
        </div>
    </div>
    <div class="col-12 fs-4 fw-semibold mt-3">Khách hàng</div>
    <hr>
    <form action="/khach-hang/add" method="post">
        <div class="container row col-12">
            <div class="row">
                <div class="mb-3 col-3">
                    <label for="inputMaKH" class="form-label">Mã khách hàng</label>
                    <input type="text" class="form-control" id="inputMaKH" name="ma" value="${detailKH.ma}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputTenKH" class="form-label">Tên khách hàng</label>
                    <input type="text" class="form-control" id="inputTenKH" name="ten" value="${detailKH.ten}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputTenDem" class="form-label">Tên đệm</label>
                    <input type="text" class="form-control" id="inputTenDem" name="tenDem" value="${detailKH.tenDem}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputHo" class="form-label">Họ</label>
                    <input type="text" class="form-control" id="inputHo" name="ho" value="${detailKH.ho}">
                </div>
            </div>
            <div class="row">
                <div class="mb-3 col-3">
                    <label for="inputNS" class="form-label">Ngày sinh</label>
                    <input type="date" class="form-control" id="inputNS" name="ngaySinh" value="${detailKH.ngaySinh}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputSDT" class="form-label">Số điện thoại</label>
                    <input type="text" class="form-control" id="inputSDT" name="sdt" value="${detailKH.sdt}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputDiaChi" class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" id="inputDiaChi" name="diaChi" value="${detailKH.diaChi}">
                </div>
                <div class="mb-3 col-3">
                    <label class="form-label">Thành phố</label>
                    <select class="form-select" aria-label="Default select example" name="thanhPho">
                        <option value="Hà Nội" ${detailKH.thanhPho == "Hà Nội" ? "selected" : ""}>Hà Nội</option>
                        <option value="Hồ Chí Minh" ${detailKH.thanhPho == "Hồ Chí Minh" ? "selected" : ""}>Hồ Chí Minh</option>
                        <option value="Hà Giang" ${detailKH.thanhPho == "Hà Giang" ? "selected" : ""}>Hà Giang</option>
                    </select>
                </div>
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
            <th>Mã khách hàng</th>
            <th>Tên khách hàng</th>
            <th>Tên đệm</th>
            <th>Họ</th>
            <th>Ngày sinh</th>
            <th>Số điện thoại</th>
            <th>Địa chỉ</th>
            <th>Thành phố</th>
            <th colspan="3">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${khachHang}" var="kh">
            <tr>
                <td>${kh.id}</td>
                <td>${kh.ma}</td>
                <td>${kh.ten}</td>
                <td>${kh.tenDem}</td>
                <td>${kh.ho}</td>
                <td>${kh.ngaySinh}</td>
                <td>${kh.sdt}</td>
                <td>${kh.diaChi}</td>
                <td>${kh.thanhPho}</td>
                <td>
                    <a href="/khach-hang/detail?id=${kh.id}"><i class="bi bi-eye me-2"></i></a>
                    <a href="/khach-hang/view-update?id=${kh.id}"><i class="bi bi-pencil-square ms-4 me-4"></i></a>
                    <a href="/khach-hang/remove?id=${kh.id}"><i class="bi bi-trash3 ms-2"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
