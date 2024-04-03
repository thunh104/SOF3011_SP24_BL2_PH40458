<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/2/2024
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update sinh viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form action="/sinh-vien/update?id=${sv.id}" method="post">
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
        <button class="btn btn-outline-success" type="submit">Update</button>
    </form>
</div>
</body>
</html>
