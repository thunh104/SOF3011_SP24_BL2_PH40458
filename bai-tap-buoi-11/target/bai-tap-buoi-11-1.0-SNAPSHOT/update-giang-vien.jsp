<%--
  Created by IntelliJ IDEA.
  User: Hthu khong depp
  Date: 3/16/2024
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa thông tin giảng viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<form action="" method="post">
    <div class="container mt-5">
        <div class="row col-12">
            <div class="mb-3 col-3">
                <label for="inputMSSV" class="form-label">Mã GV:</label>
                <input type="text" class="form-control" id="inputMSSV" name="ma" value="${gv1.ma}">
                ${checkMa}
            </div>
            <div class="mb-3 col-3">
                <label for="inputTen" class="form-label">Họ tên:</label>
                <input type="text" class="form-control" id="inputTen" name="ten" value="${gv1.ten}">
                ${checkTen}
            </div>
            <div class="mb-3 col-2">
                <label for="inputTuoi" class="form-label">Tuổi:</label>
                <input type="text" class="form-control" id="inputTuoi" name="tuoi" value="${gv1.tuoi}">
                ${checkTuoi}
            </div>
            <div class="mb-3 col-1">
                <label class="form-label">Giới tính:</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="rdo1"
                           value="false" ${gVien.gioiTinh == 'false' ? 'checked' : ''}>
                    <label class="form-check-label" for="rdo1">
                        Nam
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="rdo2" checked
                           value="true" ${gVien.gioiTinh == 'true' ? 'checked' : ''}>
                    <label class="form-check-label" for="rdo2">
                        Nữ
                    </label>
                </div>
                ${checkTuoi}
            </div>
            <div class="mb-3 col-3">
                <label for="inputQueQuan" class="form-label">Địa chỉ:</label>
                <input type="text" class="form-control" id="inputQueQuan" name="queQuan" value="${gv1.diaChi}">
            </div>
            ${checkQueQuan}
        </div>
        <button type="submit" class="btn btn-outline-primary text-content">Update giảng viên</button>
    </div>
    <br><br>
</form>
</body>
</html>
