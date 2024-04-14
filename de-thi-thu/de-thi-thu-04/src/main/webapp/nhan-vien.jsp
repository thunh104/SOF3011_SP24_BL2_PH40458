<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/13/2024
  Time: 7:26 PM
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
</head>
<body>
<div class="container">
    <form action="/nhan-vien/add" method="post">
        <div class="container text-center fs-3 fw-semibold mt-5">Quản lý nhân viên</div>
        <div class="mb-3">
            <label for="inputMa" class="form-label">Mã:</label>
            <input type="text" class="form-control" id="inputMa" value="${detailNV.ma}" name="ma">
        </div>
        <div class="mb-3">
            <label for="inputTen" class="form-label">Tên:</label>
            <input type="text" class="form-control" id="inputTen" value="${detailNV.ten}" name="ten">
        </div>
        <div class="mb-3">
            <label for="inputMatKhau" class="form-label">Mật khẩu:</label>
            <input type="text" class="form-control" id="inputMatKhau" value="${detailNV.matKhau}" name="matKhau">
        </div>
        <div class="mb-3">
            <label class="form-label">Trạng thái:</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" id="rdo1" name="trangThai" value="1" ${detailNV.trangThai == 1 ? "checked" : ""}>
                <label class="form-check-label" for="rdo1">
                    Hoạt động
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" id="rdo2" name="trangThai" value="0" ${detailNV.trangThai == 0 ? "checked" : ""}>
                <label class="form-check-label" for="rdo2">
                    Ngừng hoạt động
                </label>
            </div>
        </div>
        <div class="container"><button class="btn btn-outline-success" type="submit">Add</button></div>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Mật khẩu</th>
            <th>Trạng thái</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${htNV}" var="nv">
            <tr>
                <td>${nv.id}</td>
                <td>${nv.ma}</td>
                <td>${nv.ten}</td>
                <td>${nv.matKhau}</td>
                <td>${nv.trangThai == 1 ? "Hoạt động" : "Ngừng hoạt động"}</td>
                <td>
                    <button class="btn btn-outline-success"><a href="/nhan-vien/detail?id=${nv.id}">Detail</a></button>
                    <button class="btn btn-outline-warning"><a href="/nhan-vien/view-update?id=${nv.id}">Update</a></button>
                    <button class="btn btn-outline-danger"><a href="/nhan-vien/remove?id=${nv.id}">Remove</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
