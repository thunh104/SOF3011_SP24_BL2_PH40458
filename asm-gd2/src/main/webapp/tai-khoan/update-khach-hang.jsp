<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/4/2024
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    title>Chỉnh sửa khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<form action="/khach-hang/update=${updateKH.id}" method="post">
    <div class="container row col-12">
        <div class="row">
            <div class="mb-3 col-3">
                <label for="inputMaKH" class="form-label">Mã khách hàng</label>
                <input type="text" class="form-control" id="inputMaKH" name="ma" value="${updateKH.ma}">
            </div>
            <div class="mb-3 col-3">
                <label for="inputTenKH" class="form-label">Tên khách hàng</label>
                <input type="text" class="form-control" id="inputTenKH" name="ten" value="${updateKH.ten}">
            </div>
            <div class="mb-3 col-3">
                <label for="inputTenDem" class="form-label">Tên đệm</label>
                <input type="text" class="form-control" id="inputTenDem" name="tenDem" value="${updateKH.ma}">
            </div>
            <div class="mb-3 col-3">
                <label for="inputHo" class="form-label">Họ</label>
                <input type="text" class="form-control" id="inputHo" name="ho" value="${updateKH.ten}">
            </div>
        </div>
        <div class="row">
            <div class="mb-3 col-3">
                <label for="inputNS" class="form-label">Ngày sinh</label>
                <input type="date" class="form-control" id="inputNS" name="ngaySinh" value="${updateKH.ten}">
            </div>
            <div class="mb-3 col-3">
                <label for="inputSDT" class="form-label">Số điện thoại</label>
                <input type="text" class="form-control" id="inputSDT" name="sdt" value="${updateKH.ten}">
            </div>
            <div class="mb-3 col-3">
                <label for="inputDiaChi" class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" id="inputDiaChi" name="diaChi" value="${updateKH.ten}">
            </div>
            <div class="mb-3 col-3">
                <label class="form-label">Thành phố</label>
                <select class="form-select" aria-label="Default select example" name="thanhPho">
                    <option value="Hà Nội" ${updateKH.thanhPho == "Hà Nội" ? "selected" : ""}>Hà Nội</option>
                    <option value="Hồ Chí Minh" ${updateKH.thanhPho == "Hồ Chí Minh" ? "selected" : ""}>Hồ Chí Minh</option>
                    <option value="Hà Giang" ${updateKH.thanhPho == "Hà Giang" ? "selected" : ""}>Hà Giang</option>
                </select>
            </div>
        </div>
    </div>
    <div class="container text-content">
        <button class="btn btn-outline-success" type="submit">Chỉnh sửa</button>
    </div>
</form>
</body>
</html>
