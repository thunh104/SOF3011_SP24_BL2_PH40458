<%--
  Created by IntelliJ IDEA.
  User: Hoai Thu
  Date: 4/5/2024
  Time: 1:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa nhân viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<div class="container text-content ms-5 mt-3">
    <form action="/nhan-vien/update?id=${updateNV.id}" method="post">
        <div class="container row col-12">
            <div class="row">
                <div class="mb-3 col-3">
                    <label for="inputMaNV" class="form-label">Mã nhân viên</label>
                    <input type="text" class="form-control" id="inputMaNV" name="ma" value="${updateNV.ma}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputTenNV" class="form-label">Tên nhân viên</label>
                    <input type="text" class="form-control" id="inputTenNV" name="ten" value="${updateNV.ten}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputTenDem" class="form-label">Tên đệm</label>
                    <input type="text" class="form-control" id="inputTenDem" name="tenDem" value="${updateNV.tenDem}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputHo" class="form-label">Họ</label>
                    <input type="text" class="form-control" id="inputHo" name="ho" value="${updateNV.ho}">
                </div>
            </div>
            <div class="row">
                <div class="mb-3 col-3">
                    <label class="form-label">Giới tính</label>
                    <select class="form-select" aria-label="Default select example" name="gioiTinh">
                        <option value="Nam" ${updateNV.gioiTinh == "Nam" ? "checked" : ""}>Nam</option>
                        <option value="Nữ" ${updateNV.gioiTinh == "Nữ" ? "checked" : ""}>Nữ</option>
                    </select>
                </div>
                <div class="mb-3 col-3">
                    <label for="inputNgaySinh" class="form-label">Ngày sinh</label>
                    <input type="date" class="form-control" id="inputNgaySinh" name="ngaySinh" value="${updateNV.ngaySinh}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputDiaChi" class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" id="inputDiaChi" name="diaChi" value="${updateNV.diaChi}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputSDT" class="form-label">Số ĐT</label>
                    <input type="text" class="form-control" id="inputSDT" name="sdt" value="${updateNV.sdt}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputIDCH" class="form-label">ID cửa hàng</label>
                    <input type="text" class="form-control" id="inputIDCH" name="idCH" value="${updateNV.idCH}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputIDCV" class="form-label">ID chức vụ</label>
                    <input type="text" class="form-control" id="inputIDCV" name="idCV" value="${updateNV.idCV}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputGuiBC" class="form-label">ID gửi BC</label>
                    <input type="text" class="form-control" id="inputGuiBC" name="idGuiBC" value="${updateNV.idGuiBC}">
                </div>
                <div class="mb-3 col-3">
                    <label for="inputTrangThai" class="form-label">Trạng thái</label>
                    <input type="text" class="form-control" id="inputTrangThai" name="trangThai" value="${updateNV.trangThai}">
                </div>
            </div>
        </div>
        <div class="container text-content">
            <button class="btn btn-outline-success" type="submit">Chỉnh sửa</button>
        </div>
    </form>
</div>
</body>
</html>
