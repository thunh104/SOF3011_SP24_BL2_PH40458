<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/1/2024
  Time: 12:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Nhan Vien</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-5 mb-5 ms-5 me-5">
    <table class="table">
        <form action="" method="post">
            <div class="mb-3">
                <label for="inputMa" class="form-label">Staff Code:</label>
                <input class="form-control" id="inputMa" value="${nv1.ma}" name="ma">
            </div>
            <div class="mb-3">
                <label for="inputTen" class="form-label">Staff Name:</label>
                <input class="form-control" id="inputTen" value="${nv1.ten}" name="ten">
            </div>
            <div class="mb-3">
                <label for="inputTuoi" class="form-label">Staff Age:</label>
                <input class="form-control" id="inputTuoi" value="${nv1.tuoi}" name="tuoi">
            </div>
            <div class="mb-3">
                <label class="form-label">Staff Gender:</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" id="rdo1" name="gioiTinh"
                           value="true" ${nv1.gioiTinh == false ? 'checked' : ''}>
                    <label class="form-check-label" for="rdo1">
                        Female
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="rdo2"
                           value="false" ${nv1.gioiTinh == true ? 'checked' : ''}>
                    <label class="form-check-label" for="rdo2">
                        Male
                    </label>
                </div>
            </div>
            <div class="mb-3">
                <label for="inputDiaChi" class="form-label">Staff Address:</label>
                <input class="form-control" id="inputDiaChi" value="${nv1.diaChi}" name="diaChi">
            </div>
            <button class="btn btn-outline-success"><a href="/nhan-vien/add">Add</a></button>
        </form>
        <thead>
        <tr>
            <th>ID</th>
            <th>Staff Code</th>
            <th>Staff Name</th>
            <th>Staff Gender</th>
            <th>Staff Age</th>
            <th>Staff Address</th>
            <th colspan="3">Action</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <c:forEach items="${nv}" var="nhanVien">
        <tr>
            <td>${nhanVien.id}</td>
            <td>${nhanVien.ma}</td>
            <td>${nhanVien.ten}</td>
            <td>${nhanVien.gioiTinh == true ? "Male" : "Female"}</td>
            <td>${nhanVien.tuoi}</td>
            <td>${nhanVien.diaChi}</td>
            <td>
                <button class="btn btn-outline-success"><a href="/nhan-vien/detail?id=${nhanVien.id}">Detail</a>
                </button>
                <button class="btn btn-outline-warning"><a href="/nhan-vien/update?id=${nhanVien.id}">Update</a>
                </button>
                <button class="btn btn-outline-danger"><a href="/nhan-vien/remove?id=${nhanVien.id}">Remove</a></button>
            </td>
        </tr>
        </c:forEach>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
