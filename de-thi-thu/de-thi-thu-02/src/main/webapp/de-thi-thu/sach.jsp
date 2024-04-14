<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/8/2024
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form action="/sach/add" method="post">
        <div class="mb-3">
            <label for="inputMa" class="form-label">Mã</label>
            <input type="text" class="form-control" id="inputMa" name="ma">
        </div>
        <div class="mb-3">
            <label for="inputTen" class="form-label">Tên</label>
            <input type="text" class="form-control" id="inputTen" name="ten">
        </div>
        <div class="mb-3">
            <label for="inputSoTrang" class="form-label">Số trang</label>
            <input type="text" class="form-control" id="inputSoTrang" name="soTrang">
        </div>
        <div class="mb-3">
            <label for="inputDonGia" class="form-label">Đơn giá</label>
            <input type="text" class="form-control" id="inputDonGia" name="donGia">
        </div>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Số trang</th>
            <th>Đơn giá</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sach}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.ma}</td>
                <td>${s.ten}</td>
                <td>${s.soTrang}</td>
                <td>${s.donGia}</td>
                <td>
                    <button class="btn btn-outline-success"><a href="/sach/detail?id=${s.id}">Detail</a></button>
                    <button class="btn btn-outline-danger"><a href="/sach/remove?id=${s.id}">Remove</a></button>
                    <button class="btn btn-outline-warning"><a href="/sach/view-update?id=${s.id}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
