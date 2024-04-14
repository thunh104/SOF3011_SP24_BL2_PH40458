<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/13/2024
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Xe máy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<div class="container">
    <form action="/xe-may/add" method="post">
        <div class="mb-3">
            <label for="inputMa" class="form-label">Mã</label>
            <input type="text" class="form-control" id="inputMa" name="ma" value="${detailXM.ma}">
        </div>
        <div class="mb-3">
            <label for="inputTen" class="form-label">Tên</label>
            <input type="text" class="form-control" id="inputTen" name="ten" value="${detailXM.ten}">
        </div>
        <div class="mb-3">
            <label for="inputNgaySX" class="form-label">Ngày sản xuất</label>
            <input type="date" class="form-control" id="inputNgaySX" name="ngaySX" value="${detailXM.ngaySX}">
        </div>
        <div class="mb-3">
            <label for="inputMoTa" class="form-label">Mô tả</label>
            <input type="text" class="form-control" id="inputMoTa" name="moTa" value="${detailXM.moTa}">
        </div>
        <div class="mb-3">
            <label for="inputGiaNhap" class="form-label">Giá nhập</label>
            <input type="text" class="form-control" id="inputGiaNhap" name="giaNhap" value="${detailXM.giaNhap}">
        </div>
        <div class="mb-3">
            <label for="inputGiaBan" class="form-label">Giá bán</label>
            <input type="text" class="form-control" id="inputGiaBan" name="giaBan" value="${detailXM.giaBan}">
        </div>
        <div class="mb-3">
            <label for="inputSoLuong" class="form-label">Số lượng</label>
            <input type="text" class="form-control" id="inputSoLuong" name="soLuong" value="${detailXM.soLuong}">
        </div>
        <div class="mb-3">
            <label for="inputWebsite" class="form-label">Website</label>
            <input type="text" class="form-control" id="inputWebsite" name="website" value="${detailXM.website}">
        </div>
        <div class="mb-3">
            <label for="inputIDLXM" class="form-label">ID loại xe máy</label>
            <input type="text" class="form-control" id="inputIDLXM" name="idLXM" value="${detailXM.idLXM}">
        </div>
        <div class="mb-3">
            <label for="inputTrangThai" class="form-label">Trạng thái</label>
            <input type="text" class="form-control" id="inputTrangThai" name="trangThai" value="${detailXM.trangThai}">
        </div>
        <div>
            <button class="btn btn-outline-success" type="submit">Add</button>
        </div>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Ngày sản xuất</th>
            <th>Mô tả</th>
            <th>Giá bán</th>
            <th>Giá nhập</th>
            <th>Số lượng</th>
            <th>Website</th>
            <th>ID loại xe máy</th>
            <th>Trạng thái</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${hienThiXM}" var="xm">
            <tr>
                <td>${xm.id}</td>
                <td>${xm.ma}</td>
                <td>${xm.ten}</td>
                <td>${xm.ngaySX}</td>
                <td>${xm.moTa}</td>
                <td>${xm.giaBan}</td>
                <td>${xm.giaNhap}</td>
                <td>${xm.soLuong}</td>
                <td>${xm.website}</td>
                <td>${xm.lxma.ma}</td>
                <td>${xm.trangThai == 1 ? "Hoạt động" : "Ngừng hoạt động"}</td>
                <td>
                    <a href="/xe-may/detail?id=${xm.id}"><i class="bi bi-eye"></i></a>
                    <a href="/xe-may/view-update?id=${xm.id}"><i class="bi bi-pencil-square"></i></a>
                    <a href="/xe-may/remove?id=${xm.id}"><i class="bi bi-trash3"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
