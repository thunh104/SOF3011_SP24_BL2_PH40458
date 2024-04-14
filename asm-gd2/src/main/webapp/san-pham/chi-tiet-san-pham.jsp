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
    <title>Chi tiết sản phẩm</title>
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
                   placeholder="Tìm kiếm theo dòng sản phẩm...">
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
        <div class="col-10 fs-4 fw-semibold">Chi tiết sản phẩm</div>
        <hr>
    </div>
    <form action="/chi-tiet-san-pham/add" method="post">
        <div class="container">
            <div class="row col-12">
                <div class="mb-3 col-4">
                    <label for="inputIDSP" class="form-label">ID sản phẩm</label>
                    <input type="text" class="form-control" id="inputIDSP" name="idSP" value="${detailCTSP.idSP}">
                </div>
                <div class="mb-3 col-4">
                    <label for="inputNSX" class="form-label">ID nhà SX</label>
                    <input type="text" class="form-control" id="inputNSX" name="idNSX" value="${detailCTSP.idNSX}">
                </div>
                <div class="mb-3 col-4">
                    <label for="inputIDMS" class="form-label">ID màu sắc</label>
                    <input type="text" class="form-control" id="inputIDMS" name="idMauSac" value="${detailCTSP.idMauSac}">
                </div>
            </div>
            <div class="row">
                <div class="mb-3 col-4">
                    <label for="inputIDDSP" class="form-label">ID dòng SP</label>
                    <input type="text" class="form-control" id="inputIDDSP" name="idDongSP" value="${detailCTSP.idDongSP}">
                </div>
                <div class="mb-3 col-4">
                    <label for="inputNamBH" class="form-label">Năm bảo hành</label>
                    <input type="text" class="form-control" id="inputNamBH" name="namBH" value="${detailCTSP.namBH}">
                </div>
                <div class="mb-3 col-4">
                    <label for="inputMoTa" class="form-label">Mô tả</label>
                    <input type="text" class="form-control" id="inputMoTa" name="moTa" value="${detailCTSP.moTa}">
                </div>
            </div>
            <div class="row">
                <div class="mb-3 col-4">
                    <label for="inputSLTon" class="form-label">Số lượng tồn</label>
                    <input type="text" class="form-control" id="inputSLTon" name="soLuongTon" value="${detailCTSP.soLuongTon}">
                </div>
                <div class="mb-3 col-4">
                    <label for="inputGiaNhap" class="form-label">Giá nhập</label>
                    <input type="text" class="form-control" id="inputGiaNhap" name="giaNhap" value="${detailCTSP.giaNhap}">
                </div>
                <div class="mb-3 col-4">
                    <label for="inputGiaBan" class="form-label">Giá bán</label>
                    <input type="text" class="form-control" id="inputGiaBan" name="giaBan" value="${detailCTSP.giaBan}">
                </div>
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
            <th>ID sản phẩm</th>
            <th>ID nhà SX</th>
            <th>ID màu sắc</th>
            <th>ID dòng SP</th>
            <th>Năm bảo hành</th>
            <th>Mô tả</th>
            <th>Số lượng tồn</th>
            <th>Giá nhập</th>
            <th>Giá bán</th>
            <th colspan="3">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${chiTietSanPham}" var="ctsp">
            <tr>
                <td>${ctsp.id}</td>
                <td>${ctsp.idSP}</td>
                <td>${ctsp.idNSX}</td>
                <td>${ctsp.idMauSac}</td>
                <td>${ctsp.idDongSP}</td>
                <td>${ctsp.namBH}</td>
                <td>${ctsp.moTa}</td>
                <td>${ctsp.soLuongTon}</td>
                <td>${ctsp.giaNhap}</td>
                <td>${ctsp.giaBan}</td>
                <td>
                    <a href="/chi-tiet-san-pham/detail?id=${ctsp.id}"><i class="bi bi-eye me-2"></i></a>
                    <a href="/chi-tiet-san-pham/view-update?id=${ctsp.id}"><i class="bi bi-pencil-square ms-4 me-4"></i></a>
                    <a href="/chi-tiet-san-pham/remove?id=${ctsp.id}"><i class="bi bi-trash3 ms-2"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
