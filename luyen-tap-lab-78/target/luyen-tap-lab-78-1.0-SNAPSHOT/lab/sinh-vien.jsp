<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/2/2024
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sinh viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form method="post">
        <div class="mb-3">
            <label for="inputMa" class="form-label">Mã:</label>
            <input type="text" class="form-control" id="inputMa" value="${sv1.ma}" name="ma">
        </div>
        <div class="mb-3">
            <label for="inputTen" class="form-label">Tên:</label>
            <input type="text" class="form-control" id="inputTen" value="${sv1.ten}" name="ten">
        </div>
        <div class="mb-3">
            <label for="inputTuoi" class="form-label">Tuổi:</label>
            <input type="text" class="form-control" id="inputTuoi" value="${sv1.tuoi}" name="tuoi">
        </div>
        <div class="mb-3">
            <label class="form-label">Giới tính:</label>
            <select class="form-select" aria-label="Default select example" name="gioiTinh">
                <option value="Nam" ${sv1.gioiTinh == "Nam" ? "selected" : ""}>Nam</option>
                <option value="Nữ" ${sv1.gioiTinh == "Nữ" ? "selected" : ""}>Nữ</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="inputDiaChi" class="form-label">Địa chỉ:</label>
            <input type="text" class="form-control" id="inputDiaChi" value="${sv1.diaChi}" name="diaChi">
        </div>
        <div class="mb-3">
            <label for="inputLopID" class="form-label">Lớp ID:</label>
            <input type="text" class="form-control" id="inputLopID" value="${sv1.lopId}" name="lopId">
        </div>
        <br>
        <button class="btn btn-outline-success" type="submit">Add</button>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Tuổi</th>
            <th>Giới tính</th>
            <th>Địa chỉ</th>
            <th>Lớp ID</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sinhVien}" var="sv">
            <tr>
                <td>${sv.id}</td>
                <td>${sv.ma}</td>
                <td>${sv.ten}</td>
                <td>${sv.tuoi}</td>
                <td>${sv.gioiTinh == true ? "Nam" : "Nữ"}</td>
                <td>${sv.diaChi}</td>
                <td>${sv.lopId}</td>
                <td>
                    <button class="btn btn-outline-success"><a href="/sinh-vien/detail?id=${sv.id}">Detail</a></button>
                    <button class="btn btn-outline-danger"><a href="/sinh-vien/remove?id=${sv.id}">Remove</a></button>
                    <button class="btn btn-outline-warning"><a href="/sinh-vien/view-update?id=${sv.id}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
