<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/3/2024
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chi tiet san pham</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container ms-5 me-5 mt-5 mb-5">
    <form method="post">
        <div class="mb-3">
            <label for="inputIDSPCT" class="form-label">ID chi tiết sản phẩm</label>
            <input type="text" class="form-control" id="inputIDSPCT" name="idCTSP">
        </div>
        <div class="mb-3">
            <label for="inputIDTH" class="form-label">ID thương hiệu</label>
            <input type="text" class="form-control" id="inputIDTH" name="idThuongHieu">
        </div>
        <div class="mb-3">
            <label for="inputSoLuongTon" class="form-label">Số lượng tồn</label>
            <input type="text" class="form-control" id="inputSoLuongTon" name="soLuongTon">
        </div>
        <div class="mb-3">
            <label for="inputDonGia" class="form-label">Đơn giá</label>
            <input type="text" class="form-control" id="inputDonGia" name="donGia">
        </div>
        <div class="mb-3">
            <label for="inputGhiChu" class="form-label">Ghi chú</label>
            <input type="text" class="form-control" id="inputGhiChu" name="ghiChu">
        </div>
        <br>
        <button class="btn btn-outline-success" type="submit"><a href="">Add</a></button>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th>ID chi tiết sản phẩm</th>
            <th>ID thương hiệu</th>
            <th>Số lượng tồn</th>
            <th>Đơn giá</th>
            <th>Ghi chú</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${htspct}" var="spct">
            <tr>
                <td>${spct.idCTSP}</td>
                <td>${spct.idThuongHieu}</td>
                <td>${spct.soLuongTon}</td>
                <td>${spct.donGia}</td>
                <td>${spct.ghiChu}</td>
                <td>
                    <button class="btn btn-outline-danger"><a href="/chi-tiet-san-pham/remove?idCTSP=${spct.idCTSP}">Remove</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
