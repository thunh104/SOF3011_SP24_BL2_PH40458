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
    <title>Nhân viên</title>
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
    <div class="col-12 fs-4 fw-semibold mt-3">Nhân viên</div>
    <hr>
    <form action="/nhan-vien/add" method="post">
        <div class="container row col-12">
            <div class="row">
                <div class="mb-3 col-3">
                    <label for="inputMaNV" class="form-label">Mã nhân viên</label>
                    <input type="text" class="form-control" id="inputMaNV" name="ma" value="${detailNV.ma}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputTenNV" class="form-label">Tên nhân viên</label>
                    <input type="text" class="form-control" id="inputTenNV" name="ten" value="${detailNV.ten}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputTenDem" class="form-label">Tên đệm</label>
                    <input type="text" class="form-control" id="inputTenDem" name="tenDem" value="${detailNV.tenDem}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputHo" class="form-label">Họ</label>
                    <input type="text" class="form-control" id="inputHo" name="ho" value="${detailNV.ho}">
                </div>
            </div>
            <div class="row">
                <div class="mb-3 col-3">
                    <label for="inputGioiTinh" class="form-label">Giới tính</label>
                    <input type="text" class="form-control" id="inputGioiTinh" name="gioiTinh" value="${detailNV.gioiTinh}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputNgaySinh" class="form-label">Ngày sinh</label>
                    <input type="date" class="form-control" id="inputNgaySinh" name="ngaySinh" value="${detailNV.ngaySinh}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputDiaChi" class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" id="inputDiaChi" name="diaChi" value="${detailNV.diaChi}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputSDT" class="form-label">Số ĐT</label>
                    <input type="text" class="form-control" id="inputSDT" name="sdt" value="${detailNV.sdt}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputIDCH" class="form-label">ID cửa hàng</label>
                    <input type="text" class="form-control" id="inputIDCH" name="idCH" value="${detailNV.idCH}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputIDCV" class="form-label">ID chức vụ</label>
                    <input type="text" class="form-control" id="inputIDCV" name="idCV" value="${detailNV.idCV}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputGuiBC" class="form-label">ID gửi BC</label>
                    <input type="text" class="form-control" id="inputGuiBC" name="idGuiBC" value="${detailNV.idGuiBC}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputTrangThai" class="form-label">Trạng thái</label>
                    <input type="text" class="form-control" id="inputTrangThai" name="trangThai" value="${detailNV.trangThai}">
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
            <th>Mã nhân viên</th>
            <th>Tên nhân viên</th>
            <th>Tên đệm</th>
            <th>Họ</th>
            <th>Giới tính</th>
            <th>Ngày sinh</th>
            <th>Số ĐT</th>
            <th>ID cửa hàng</th>
            <th>ID chức vụ</th>
            <th>ID gửi BC</th>
            <th>Trạng thái</th>
            <th colspan="3">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${nhanVien}" var="nv">
            <tr>
                <td>${nv.id}</td>
                <td>${nv.ma}</td>
                <td>${nv.ten}</td>
                <td>${nv.tenDem}</td>
                <td>${nv.ho}</td>
                <td>${nv.gioiTinh}</td>
                <td>${nv.ngaySinh}</td>
                <td>${nv.sdt}</td>
                <td>${nv.idCH}</td>
                <td>${nv.idCV}</td>
                <td>${nv.idGuiBC}</td>
                <td>${nv.trangThai}</td>
                <td>
                    <a href="/nhan-vien/detail?id=${nv.id}"><i class="bi bi-eye me-2"></i></a>
                    <a href="/nhan-vien/view-update?id=${nv.id}"><i class="bi bi-pencil-square ms-4 me-4"></i></a>
                    <a href="/nhan-vien/remove?id=${nv.id}"><i class="bi bi-trash3 ms-2"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
