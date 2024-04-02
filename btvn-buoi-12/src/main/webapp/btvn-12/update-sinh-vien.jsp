<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 3/30/2024
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chỉnh sửa sinh viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<form method="post">
    <div class="container mt-5 mb-5">
        <div class="mb-3">
            <label for="inputMa" class="form-label">Ma: </label>
            <input class="form-control" id="inputMa" name="ma" value="${sv1.ma}">
        </div>
        <div class="mb-3">
            <label for="inputTen" class="form-label">Ten: </label>
            <input class="form-control" id="inputTen" name="ten" value="${sv1.ten}">
        </div>
        <div class="mb-3">
            <label for="inputTuoi" class="form-label">Tuoi: </label>
            <input class="form-control" id="inputTuoi" name="tuoi" value="${sv1.tuoi}">
        </div>
        <div class="mb-3">
            <label for="inputDiaChi" class="form-label">Dia chi: </label>
            <input class="form-control" id="inputDiaChi" name="diaChi" value="${sv1.diaChi}">
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
        <div class="text-center"><button class="btn btn-outline-success" style="width: 500px">Chinh sua</button></div>
    </div>
</form>
</body>
</html>
