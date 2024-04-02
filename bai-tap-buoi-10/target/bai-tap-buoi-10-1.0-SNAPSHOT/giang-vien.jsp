<%--
  Created by IntelliJ IDEA.
  User: Hthu khong depp
  Date: 3/16/2024
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <title>Giảng viên</title>
</head>
<body>
<div class="container mt-5">
    <table class="table">
        <form action="/giang-vien/add" method="post">
            <div class="container">
                <div class="row col-12">
                    <div class="mb-3 col-3">
                        <label for="inputName" class="form-label">Tên:</label>
                        <input type="text" class="form-control" id="inputName">
                    </div>
                    <div class="mb-3 col-3">
                        <label for="inputAge" class="form-label">Tuổi:</label>
                        <input type="text" class="form-control" id="inputAge">
                    </div>
                    <div class="mb-3 col-3">
                        <label for="inputMin" class="form-label">Min:</label>
                        <input type="text" class="form-control" id="inputMin">
                    </div>
                    <div class="mb-3 col-3">
                        <label for="inputMax" class="form-label">Max:</label>
                        <input type="text" class="form-control" id="inputMax">
                    </div>
                </div>
            </div>
            <button type="button" class="btn btn-outline-success"><a href="">Search</a></button>
            <br><br>
            <div class="container">
                <div class="row col-12">
                    <div class="mb-3 col-3">
                        <label for="inputMSSV" class="form-label">Mã GV:</label>
                        <input type="text" class="form-control" id="inputMSSV" name="mssv" value="${gVien.mssv}">
                    </div>
                    ${checkMa}
                    <div class="mb-3 col-3">
                        <label for="inputTen" class="form-label">Họ tên:</label>
                        <input type="text" class="form-control" id="inputTen" name="ten" value="${gVien.ten}">
                    </div>
                    ${checkTen}
                    <div class="mb-3 col-2">
                        <label for="inputTuoi" class="form-label">Tuổi:</label>
                        <input type="text" class="form-control" id="inputTuoi" name="tuoi" value="${gVien.tuoi}">
                    </div>
                    ${checkTuoi}
                    <div class="mb-3 col-1">
                        <label class="form-label">Giới tính:</label>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="false" name="gioiTinh" id="rdo1" ${gVien.gioiTinh == false ? "checked" : ""}>
                            <label class="form-check-label" for="rdo1" >
                                Nam
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" value="true" name="gioiTinh" id="rdo2" ${gVien.gioiTinh == true ? "checked" : ""}>
                            <label class="form-check-label" for="rdo2">
                                Nữ
                            </label>
                        </div>
                    </div>
                    <div class="mb-3 col-3">
                        <label for="inputQueQuan" class="form-label">Quê quán:</label>
                        <input type="text" class="form-control" id="inputQueQuan" name="queQuan" value="${gVien.queQuan}">
                    </div>
                    ${checkQueQuan}
                </div>
            </div>
            <button type="submit" class="btn btn-outline-primary">Add</button>
            <br>
        </form>
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Tuổi</th>
            <th>Giới tính</th>
            <th>Quê quán</th>
            <th colspan="3">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${gv}" var="giangVien">
            <tr>
                <td>${giangVien.id}</td>
                <td>${giangVien.mssv}</td>
                <td>${giangVien.ten}</td>
                <td>${giangVien.tuoi}</td>
                <td>${giangVien.gioiTinh == true ? "Nữ" : "Nam"}</td>
                <td>${giangVien.queQuan}</td>
                <td>
                    <button class="btn btn-success"><a href="/giang-vien/view-update?mssv=${giangVien.mssv}">Edit</a>
                    </button>
                    <button class="btn btn-danger"><a href="/giang-vien/remove?mssv=${giangVien.mssv}">Remove</a>
                    </button>
                    <button class="btn btn-warning"><a href="/giang-vien/detail?mssv=${giangVien.mssv}">Detail</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
