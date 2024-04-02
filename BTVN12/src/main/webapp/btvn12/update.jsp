<%--
  Created by IntelliJ IDEA.
  User: NamVS
  Date: 3/31/2024
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<body>
<form action="/sinh-vien/update?id=${gvl.id}" method="post">
    <div class="row col-12">

        <div class="mb-3 col-3">
            <label for="inputMSSV" class="form-label">Mã :</label>
            <input type="text" class="form-control" id="inputMSSV" name="ma" value="${gvl.ma}">

            <br>
        </div>
        <div class="mb-3 col-3">
            <label for="inputTen" class="form-label">Họ tên:</label>
            <input type="text" class="form-control" id="inputTen" name="ten" value="${gvl.ten}">

            <br>
        </div>
        <div class="mb-3 col-2">
            <label for="inputTuoi" class="form-label">Tuổi:</label>
            <input type="text" class="form-control" id="inputTuoi" name="tuoi" value="${gvl.tuoi}">
            <br>

            <br>
        </div>
        <div class="mb-3 col-3">
            <label class="form-label"> Địa Chỉ:</label>
            <input type="text" class="form-control"  name="diaChi" value="${gvl.diaChi}">
        </div>
        <br>

        <div class="mb-3 col-1">
            <label class="form-label">Giới tính:</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="true" name="gioiTinh" id="rdo1" ${gvl.gioiTinh == true ? "checked" : ""}>
                <label class="form-check-label" for="rdo1" >
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="false" name="gioiTinh" id="rdo2" ${gvl.gioiTinh == false ? "checked" : ""}>
                <label class="form-check-label" for="rdo2">
                    Nữ
                </label>
            </div>
        </div>
        <div class="mb-3 col-3">
            <label class="form-label"> Mã lớp :</label>
            <input type="text" class="form-control" name="lopID" value="${gvl.lop.ma}">
        </div>
        <div class="mb-3 col-3">
            <label class="form-label"> Tên lớp :</label>
            <input type="text" class="form-control" name="tenLop" value="${gvl.lop.ten}">
        </div>
    </div>

    <button type="submit" class="btn btn-outline-primary">Update</button>
    <br>
</form>

</body>
</html>
