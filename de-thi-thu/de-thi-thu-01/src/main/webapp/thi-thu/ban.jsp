<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/5/2024
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bạn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form action="/ban/add" method="post">
        <div class="text-center fs-2 fw-semibold mt-5">Quản lý bạn bè</div>
        <br>
        <div class="row col-12">
            <div class="mb-3 col-6">
                <label for="inputMa" class="form-label">Mã</label>
                <input type="text" class="form-control" id="inputMa" name="ma" value="${detailBan.ma}">
            </div>
            <div class="mb-3 col-6">
                <label for="inputSoThich" class="form-label">Sở thích</label>
                <input type="text" class="form-control" id="inputSoThich" name="soThich" value="${detailBan.soThich}">
            </div>
        </div>
        <div class="row col-12">
            <div class="mb-3 col-6">
                <label for="inputTen" class="form-label">Tên</label>
                <input type="text" class="form-control" id="inputTen" name="ten" value="${detailBan.ten}">
            </div>
            <div class="mb-3 col-6">
                <label class="form-label">Giới tính</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="rdo1"
                           value="0" ${detailBan.gioiTinh == 0 ? "Nam" : "checked"}>
                    <label class="form-check-label" for="rdo1">
                        Nam
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="rdo2"
                           value="1" ${detailBan.gioiTinh == 1 ? "Nữ" : "checked"}>
                    <label class="form-check-label" for="rdo2">
                        Nữ
                    </label>
                </div>
            </div>
            <div class="container text-content">
                <button class="btn btn-success" type="submit">Thêm mới</button>
            </div>
        </div>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Sở thích</th>
            <th>Giới tính</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ban}" var="b">
            <tr>
                <td>${b.id}</td>
                <td>${b.ma}</td>
                <td>${b.ten}</td>
                <td>${b.soThich}</td>
                <td>${b.gioiTinh == 1 ? "Nam" : "Nữ"}</td>
                <td>
                    <button class="btn btn-outline-info"><a href="/ban/detail?id=${b.id}">Detail</a></button>
                    <button class="btn btn-outline-warning"><a href="/ban/view-update?id=${b.id}">Update</a></button>
                    <button class="btn btn-outline-danger"><a href="/ban/remove?id=${b.id}">Remove</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
