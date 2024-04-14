<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/5/2024
  Time: 1:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa cửa hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<div class="container text-content ms-5 mt-3">
    <form action="/cua-hang/update?id=${updateCH.id}" method="post">
        <div class="row col-12">
            <div class="mb-3 col-6">
                <label for="inputMa" class="form-label">Mã cửa hàng</label>
                <input type="text" class="form-control" id="inputMa" name="ma" value="${updateCH.ma}">
            </div>
            <div class="mb-3 col-6">
                <label for="inputTen" class="form-label">Tên cửa hàng</label>
                <input type="text" class="form-control" id="inputTen" name="ten" value="${updateCH.ten}">
            </div>
            <div class="mb-3 col-6">
                <label for="inputDiaChi" class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" id="inputDiaChi" name="diaChi" value="${updateCH.diaChi}">
            </div>
            <div class="mb-3 col-6">
                <label for="inputThanhPho" class="form-label">Thành phố</label>
                <input type="text" class="form-control" id="inputThanhPho" name="thanhPho" value="${updateCH.thanhPho}">
            </div>
            <div class="mb-3 col-6">
                <label for="inputQuocGia" class="form-label">Quốc gia</label>
                <input type="text" class="form-control" id="inputQuocGia" name="quocGia" value="${updateCH.quocGia}">
            </div>
        </div>
        <div class="text-content">
            <button class="btn btn-outline-success" type="submit">Chỉnh sửa</button>
        </div>
    </form>
</div>
</body>
</html>

