<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 3/29/2024
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sinh vien</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container ms-5 me-5 text-content">
    <table class="table">
        <form action="/sinh-vien/add" method="post">
            <div class="container mt-5 mb-5">
                <div class="mb-3">
                    <label for="inputMa" class="form-label">Ma: </label>
                    <input class="form-control" id="inputMa" name="ma" value="${sv1.ma}"></input>
                </div>
                <div class="mb-3">
                    <label for="inputTen" class="form-label">Ten: </label>
                    <input class="form-control" id="inputTen" name="ten" value="${sv1.ten}"></input>
                </div>
                <div class="mb-3">
                    <label for="inputTuoi" class="form-label">Tuoi: </label>
                    <input class="form-control" id="inputTuoi" name="tuoi" value="${sv1.tuoi}"></input>
                </div>
                <div class="mb-3">
                    <label for="inputDiaChi" class="form-label">Dia chi: </label>
                    <input class="form-control" id="inputDiaChi" name="diaChi" value="${sv1.diaChi}"></input>
                </div>
                <div class="mb-3">
                    <label class="form-label">Gioi tinh: </label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gioiTinh" id="rdo1" value="true" ${sv1.gioiTinh == 'true' ? 'checked' : ''}>
                        <label class="form-check-label" for="rdo1">
                            Nam
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gioiTinh" id="rdo2" value="false" ${sv1.gioiTinh == 'false' ? 'checked' : ''}>
                        <label class="form-check-label" for="rdo2">
                            Nu
                        </label>
                    </div>
                </div>
                <div class="mb-3>
                    <label class="form-label"> Lop ID :</label>
                    <input type="text" class="form-control" name="lopId" value="${sv1.lopId}">
                </div>
                <div class="text-center mt-4"><button class="btn btn-outline-success" style="width: 500px">Them moi</button></div>
            </div>
        </form>
        <hr>
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
        <c:forEach items="${sv}" var="sinhVien">
            <tr>
                <td>${sinhVien.id}</td>
                <td>${sinhVien.ma}</td>
                <td>${sinhVien.ten}</td>
                <td>${sinhVien.tuoi}</td>
                <td>${sinhVien.gioiTinh == false ? 'Nu' : 'Nam'}</td>
                <td>${sinhVien.diaChi}</td>
                <td>${sinhVien.lopId}</td>
                <td>
                    <button class="btn btn-outline-dark"><a
                            href="/sinh-vien/detail?id=${sinhVien.id}">Detail</a></button>
                    <button class="btn btn-outline-warning"><a href="/sinh-vien/view-update?id=${sinhVien.id}">Update</a>
                    </button>
                    <button class="btn btn-outline-danger"><a
                            href="/sinh-vien/delete?id=${sinhVien.id}">Delete</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
