<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa thông tin giảng viên </title>
</head>
<body>
<form action="" method="post">
    <div class="container mt-5">
        <div class="row col-12">
            <div class="mb-3 col-3">
                <label for="inputMSSV" class="form-label">Mã GV:</label>
                <input type="text" class="form-control" id="inputMSSV" name="ma" value="${gvl.ma}">
                ${checkMa}
            </div>
            <div class="mb-3 col-3">
                <label for="inputTen" class="form-label">Họ tên:</label>
                <input type="text" class="form-control" id="inputTen" name="ten" value="${gvl.ten}">
                ${checkTen}
            </div>
            <div class="mb-3 col-2">
                <label for="inputTuoi" class="form-label">Tuổi:</label>
                <input type="text" class="form-control" id="inputTuoi" name="tuoi" value="${gvl.tuoi}">
                ${checkTuoi}
            </div>
            <div class="mb-3 col-1">
                <label class="form-label">Giới tính:</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="rdo1"
                           value="false" ${gvl.gioiTinh == 'false' ? 'checked' : ''}>
                    <label class="form-check-label" for="rdo1">
                        Nam
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh" id="rdo2" checked
                           value="true" ${gvl.gioiTinh == 'true' ? 'checked' : ''}>
                    <label class="form-check-label" for="rdo2">
                        Nữ
                    </label>
                </div>
                ${checkTuoi}
            </div>
            <div class="mb-3 col-3">
                <label for="inputQueQuan" class="form-label">Địa chỉ:</label>
                <input type="text" class="form-control" id="inputQueQuan" name="queQuan" value="${gvl.diaChi}">
            </div>
            ${checkQueQuan}
        </div>
        <button type="submit" class="btn btn-outline-primary text-content">Update giảng viên</button>
    </div>
    <br><br>
</form>
</body>
</html>
