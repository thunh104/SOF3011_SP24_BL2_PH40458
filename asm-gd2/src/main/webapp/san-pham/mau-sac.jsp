<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/2/2024
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Màu sắc</title>
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
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link" href="">Sản phẩm</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="">Hoá đơn</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="">Màu sắc</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Tài khoản</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Giỏ hàng</a>
            </li>
        </ul>
    </div>
    <br>
    <div class="row col-12 mt-3 mb-3">
        <div class="col-10 fs-4 fw-semibold">Màu sắc</div>
    </div>
    <form action="/san-pham/add" method="post">
        <div class="container row col-12">
            <div class="mb-3 col-6">
                <label for="inputMa" class="form-label">Mã màu sắc</label>
                <input type="text" class="form-control" id="inputMa" name="ma" value="${detailMS.ma}">
            </div>
            <div class="mb-3 col-6">
                <label for="inputTen" class="form-label">Tên màu sắc</label>
                <input type="text" class="form-control" id="inputTen" name="ten" value="${detailMS.ten}">
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
            <th>Mã màu sắc</th>
            <th>Tên màu sắc</th>
            <th colspan="3">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${mauSac}" var="ms">
            <tr>
                <td>${ms.id}</td>
                <td>${ms.ma}</td>
                <td>${ms.ten}</td>
                <td>
                    <a href="/mau-sac/detail?id=${ms.id}"><i class="bi bi-eye me-2"></i></a>
                    <a href="/mau-sac/view-update?id=${ms.id}"><i class="bi bi-pencil-square ms-4 me-4"></i></a>
                    <a href="/mau-sac/remove?id=${ms.id}"><i class="bi bi-trash3 ms-2"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
