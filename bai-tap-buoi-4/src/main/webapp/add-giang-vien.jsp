<%--
  Created by IntelliJ IDEA.
  User: Hthu khong depp
  Date: 3/13/2024
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm giảng viên mới</title>
</head>
<body>
<form action="" method="post">
    Mã GV: <input type="text" name="ma"/>
    <br/>
    ${checkMa}
    <br>
    Tên: <input type="text" name="ten"/>
    <br/>
    ${checkTen}
    <br>
    Tuổi: <input type="text" name="tuoi"/>
    <br/>
    ${checkTuoi}
    <br>
    Giới tính:
    <input type="radio" name="gioiTinh" checked value="true"/>Nam
    <input type="radio" name="gioiTinh" value="false"/>Nữ
    <br/>
    <br>
    Địa chỉ: <input type="text" name="diaChi"/>
    <br/>
    ${checkDiaChi}
    <br>
    <button type="submit">Add</button>
</form>
</body>
</html>
