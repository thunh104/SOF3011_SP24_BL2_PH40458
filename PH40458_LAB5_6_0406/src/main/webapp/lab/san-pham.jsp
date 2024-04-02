<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/1/2024
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container ms-5 me-5 mt-5 mb-5">
    <table class="table">
        <form method="post">
            <div class="mb-3">
                <label for="inputMa" class="form-label">Mã sản phẩm</label>
                <input type="text" class="form-control" id="inputMa" name="ma" value="${sp1.ma}">
            </div>
            <div class="mb-3">
                <label for="inputTen" class="form-label">Tên sản phẩm</label>
                <input type="text" class="form-control" id="inputTen" name="ten" value="${sp1.ten}">
            </div>
            <div class="mb-3">
                <label for="inputGia" class="form-label">Giá</label>
                <input type="text" class="form-control" id="inputGia" name="gia" value="${sp1.gia}">
            </div>
            <div class="mb-3">
                <label for="inputChatLieu" class="form-label">Chất liệu</label>
                <input type="text" class="form-control" id="inputChatLieu" name="chatLieu" value="${sp1.chatLieu}">
            </div>
            <div class="mb-3">
                <label class="form-label">Màu sắc</label>
                <select class="form-select" aria-label="Default select example" name="mauSac" value="${sp1.mauSac}">
                    <option value="Màu xanh">Màu xanh</option>
                    <option value="Màu đỏ">Màu đỏ</option>
                    <option value="Màu vàng>">Màu vàng</option>
                </select>
            </div>
        <button class="btn btn-outline-success mt-4"><a href="/san-pham/add">Thêm mới</a></button>
        </form>
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Chất liệu</th>
            <th>Màu sắc</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sp}" var="sanPham">
            <tr>
                <td>${sanPham.id}</td>
                <td>${sanPham.ma}</td>
                <td>${sanPham.ten}</td>
                <td>${sanPham.gia}</td>
                <td>${sanPham.chatLieu}</td>
                <td>${sanPham.mauSac}</td>
                <td>
                    <button class="btn btn-outline-success"><a href="/san-pham/remove?id=${sanPham.id}">Delete</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
