<%--
  Created by IntelliJ IDEA.
  User: Hthu khong depp
  Date: 3/20/2024
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa dộng vật</title>
</head>
<body>
<form method="post">
    ID:
    <input type="text" name="id"><br>
    Tên:
    <input type="text" name="ten"><br>
    Tuổi:
    <input type="text" name="tuoi"><br>
    Khu vực:
    <input type="text" name="khuVuc"><br>
    Cân nặng:
    <input type="text" name="canNang"><br>
    Giới tính:
    <div class="form-check">
        <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault1">
        <label class="form-check-label" for="flexRadioDefault1">
            Nam
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault2" checked>
        <label class="form-check-label" for="flexRadioDefault2">
            Nữ
        </label>
    </div>
    <br>
    <button type="submit">Update động vật</button>
</form>
</body>
</html>
