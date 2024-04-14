<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/5/2024
  Time: 12:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa chi tiết sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<div class="container">
    <form action="/chi-tiet-san-pham/update?id=${updateCTSP.id}" method="post">
        <div class="container text-content ms-5 mt-3">
            <div class="row col-12">
                <div class="mb-3 col-4">
                    <label for="inputIDSP" class="form-label">ID sản phẩm</label>
                    <input type="text" class="form-control" id="inputIDSP" name="idSP" value="${updateCTSP.idSP}">
                </div>
                <div class="mb-3 col-4">
                    <label for="inputNSX" class="form-label">ID nhà SX</label>
                    <input type="text" class="form-control" id="inputNSX" name="idNSX" value="${updateCTSP.idNSX}">
                </div>
                <div class="mb-3 col-4">
                    <label for="inputIDMS" class="form-label">ID màu sắc</label>
                    <input type="text" class="form-control" id="inputIDMS" name="idMauSac" value="${updateCTSP.idMauSac}">
                </div>
            </div>
            <div class="row">
                <div class="mb-3 col-4">
                    <label for="inputIDDSP" class="form-label">ID dòng SP</label>
                    <input type="text" class="form-control" id="inputIDDSP" name="idDongSP" value="${updateCTSP.idDongSP}">
                </div>
                <div class="mb-3 col-4">
                    <label for="inputNamBH" class="form-label">Năm bảo hành</label>
                    <input type="text" class="form-control" id="inputNamBH" name="namBH" value="${updateCTSP.namBH}">
                </div>
                <div class="mb-3 col-4">
                    <label for="inputMoTa" class="form-label">Mô tả</label>
                    <input type="text" class="form-control" id="inputMoTa" name="moTa" value="${updateCTSP.moTa}">
                </div>
            </div>
            <div class="row">
                <div class="mb-3 col-4">
                    <label for="inputSLTon" class="form-label">Số lượng tồn</label>
                    <input type="text" class="form-control" id="inputSLTon" name="soLuongTon" value="${updateCTSP.soLuongTon}">
                </div>
                <div class="mb-3 col-4">
                    <label for="inputGiaNhap" class="form-label">Giá nhập</label>
                    <input type="text" class="form-control" id="inputGiaNhap" name="giaNhap" value="${updateCTSP.giaNhap}">
                </div>
                <div class="mb-3 col-4">
                    <label for="inputGiaBan" class="form-label">Giá bán</label>
                    <input type="text" class="form-control" id="inputGiaBan" name="giaBan" value="${updateCTSP.giaBan}">
                </div>
            </div>
        </div>
        <div class="text-content">
            <button class="btn btn-outline-success" type="submit">Chỉnh sửa</button>
        </div>
    </form>
</div>
</body>
</html>
