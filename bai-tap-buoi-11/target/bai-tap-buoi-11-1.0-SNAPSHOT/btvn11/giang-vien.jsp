<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<body>
<div class="container" style="margin-left:30px ">

    <form action="" method="post">
        <div class="mb-3 col-3">
            <label for="inputName" class="form-label">Tên:</label>
            <input type="text" class="form-control" name="ten" id="inputName">
        </div>
        <button type="button" class="btn btn-outline-success"><a href="">Search</a></button>
    </form>
    <br>
    <hr>
    <button class="btn "><a href="/giang-vien/view-add">Add</a> <br>
        <button class="btn "><a href="/giang-vien/giang-vien-nu">Giảng viên nữ</a></button>
        <br>
        <hr>

        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Mã</th>
                <th>Tên</th>
                <th>Tuổi</th>
                <th>Giới tính</th>
                <th>Địa Chỉ</th>
                <th colspan="3">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${hienThi}" var="giangVien">
            <tr>
                <td>${giangVien.id}</td>
                <td>${giangVien.ma}</td>
                <td>${giangVien.ten}</td>
                <td>${giangVien.tuoi}</td>
                <td>${giangVien.gioiTinh == true ? "Nữ" : "Nam"}</td>
                <td>${giangVien.diaChi}</td>
                <td>
                    <button class="btn btn-success"><a href="/giang-vien/view-update?ma=${giangVien.ma}">Edit</a>
                    </button>
                    <button class="btn btn-danger"><a href="/giang-vien/remove?ma=${giangVien.ma}">Remove</a>
                    </button>
                    <button class="btn btn-warning"><a href="/giang-vien/detail?ma=${giangVien.ma}">Detail</a></button>
    </button>
    </td>
    </tr>
    </c:forEach>
    </tbody>
    </table>
</div>
</body>
</html>