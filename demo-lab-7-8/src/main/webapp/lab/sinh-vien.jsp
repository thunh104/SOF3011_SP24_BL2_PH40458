<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/2/2024
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form action="/sinh-vien/add" method="post">
        <div class="mb-3">
            <label for="inputMa" class="form-label">Ma:</label>
            <input type="text" class="form-control" id="inputMa" name="ma" value="${sv.ma}">
        </div>
        <div class="mb-3">
            <label for="inputTen" class="form-label">Ten:</label>
            <input type="text" class="form-control" id="inputTen" name="ten" value="${sv.ten}">
        </div>
        <div class="mb-3">
            <label for="inputTuoi" class="form-label">Tuoi:</label>
            <input type="text" class="form-control" id="inputTuoi" name="tuoi" value="${sv.tuoi}">
        </div>
        <div class="mb-3">
            <label for="inputDiaChi" class="form-label">Dia chi:</label>
            <input type="text" class="form-control" id="inputDiaChi" name="diaChi" value="${sv.diaChi}">
        </div>
        <div class="mb-3">
            <label class="form-label">Gioi tinh:</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" id="rdo1" value=true ${sv.gioiTinh == "true" ? "checked" : ""}>
                <label class="form-check-label" for="rdo1">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" id="rdo2" value=false ${sv.gioiTinh == "false" ? "checked" : ""}>
                <label class="form-check-label" for="rdo2">
                    Nu
                </label>
            </div>
        </div>
        <div class="mb-3">
            <label for="inputLopID" class="form-label">Lop ID:</label>
            <input type="text" class="form-control" id="inputLopID" name="lopId" value="${sv.lopId}">
        </div>
        <br>
        <button class="btn btn-outline-success" type="submit">Add</button>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Ma</th>
                <th>Ten</th>
                <th>Tuoi</th>
                <th>Gioi tinh</th>
                <th>Dia chi</th>
                <th>Lop ID</th>
                <th colspan="3">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${htsv}" var="sv1">
                <tr>
                    <td>${sv1.id}</td>
                    <td>${sv1.ma}</td>
                    <td>${sv1.ten}</td>
                    <td>${sv1.tuoi}</td>
                    <td>${sv1.gioiTinh == true ? "Nam" : "Nu"}</td>
                    <td>${sv1.diaChi}</td>
                    <td>${sv1.lopId}</td>
                    <td>
                        <button class="btn btn-outline-success"><a href="/sinh-vien/detail?id=${sv1.id}">Detail</a></button>
                        <button class="btn btn-outline-warning"><a href="/sinh-vien/view-update?id=${sv1.id}">Update</a></button>
                        <button class="btn btn-outline-danger"><a href="/sinh-vien/remove?id=${sv1.id}">Remove</a></button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
