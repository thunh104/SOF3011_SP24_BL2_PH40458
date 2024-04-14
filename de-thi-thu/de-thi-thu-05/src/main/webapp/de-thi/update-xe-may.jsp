<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/14/2024
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update xe máy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<div class="container">
    <form action="/xe-may/update?id=${updateXM.id}" method="post">
        <div class="mb-3">
            <label for="inputMa" class="form-label">Mã</label>
            <input type="text" class="form-control" id="inputMa" name="ma" value="${updateXM.ma}">
        </div>
        <div class="mb-3">
            <label for="inputTen" class="form-label">Tên</label>
            <input type="text" class="form-control" id="inputTen" name="ten" value="${updateXM.ten}">
        </div>
        <div class="mb-3">
            <label for="inputNgaySX" class="form-label">Ngày sản xuất</label>
            <input type="date" class="form-control" id="inputNgaySX" name="ngaySX" value="${updateXM.ngaySX}">
        </div>
        <div class="mb-3">
            <label for="inputMoTa" class="form-label">Mô tả</label>
            <input type="text" class="form-control" id="inputMoTa" name="moTa" value="${updateXM.moTa}">
        </div>
        <div class="mb-3">
            <label for="inputGiaNhap" class="form-label">Giá nhập</label>
            <input type="text" class="form-control" id="inputGiaNhap" name="giaNhap" value="${updateXM.giaNhap}">
        </div>
        <div class="mb-3">
            <label for="inputGiaBan" class="form-label">Giá bán</label>
            <input type="text" class="form-control" id="inputGiaBan" name="giaBan" value="${updateXM.giaBan}">
        </div>
        <div class="mb-3">
            <label for="inputSoLuong" class="form-label">Số lượng</label>
            <input type="text" class="form-control" id="inputSoLuong" name="soLuong" value="${updateXM.soLuong}">
        </div>
        <div class="mb-3">
            <label for="inputWebsite" class="form-label">Website</label>
            <input type="text" class="form-control" id="inputWebsite" name="website" value="${updateXM.website}">
        </div>
        <div class="mb-3">
            <label for="inputIDLXM" class="form-label">ID loại xe máy</label>
            <input type="text" class="form-control" id="inputIDLXM" name="idLXM" value="${updateXM.idLXM}">
        </div>
        <div class="mb-3">
            <label for="inputTrangThai" class="form-label">Trạng thái</label>
            <input type="text" class="form-control" id="inputTrangThai" name="trangThai" value="${updateXM.trangThai}">
        </div>
        <div>
            <button class="btn btn-outline-success" type="submit">Update</button>
        </div>
    </form>
</div>
</body>
</html>
