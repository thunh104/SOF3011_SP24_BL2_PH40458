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
</head>
<body>
<form action="" method="post">
    Mã GV:
    <input type="text" name="maGV" value="${gv1.maGV}"/>
    <br>
    Họ tên:
    <input type="text" name="ten" value="${gv1.ten}"/>
    <br>
    Tuổi:
    <input type="text" name="tuoi" value="${gv1.tuoi}"/>
    <br>
    Quê quán:
    <input type="text" name="queQuan" value="${gv1.queQuan}"/>
    <br><br>
    <button type="submit">Update</button>
    <br><br>
</form>
</body>
</html>
