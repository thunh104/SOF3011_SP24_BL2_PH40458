<%--
  Created by IntelliJ IDEA.
  User: Hthu khong depp
  Date: 3/16/2024
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Giảng viên</title>
</head>
<body>
<table border="1">
    <form action="" method="post">
        <label for="">Tên:</label>
        <input type="text"/>
        <br>
        <label for="">Tuổi:</label>
        <input type="text">
        <br>
        <label for="">Min:</label>
        <input type="text"/>
        <br>
        <label for="">Max:</label>
        <input type="text">
        <br>
        <button><a href="">Search</a></button>
        <br>
        <br>
        <label for="">Mã GV:</label>
        <input type="text" name="maGV" value="${gv1.maGV}"/>
        ${checkMa}
        <br>
        <label for="">Họ tên:</label>
        <input type="text" name="ten" value="${gv1.ten}"/>
        ${checkTen}
        <br>
        <label for="">Tuổi:</label>
        <input type="text" name="tuoi" value="${gv1.tuoi}"/>
        ${checkTuoi} ${checkTuoi25}
        <br>
        <label for="">Quê quán:</label>
        <input type="text" name="queQuan" value="${gv1.queQuan}"/>
        ${checkQueQuan}
        <br><br>
        <button type="submit">Add</button>
        <br><br>
    </form>
    <thead>
    <tr>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Quê quán</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${gv}" var="giangVien" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${giangVien.maGV}</td>
            <td>${giangVien.ten}</td>
            <td>${giangVien.tuoi}</td>
            <td>${giangVien.queQuan}</td>
            <td>
                <button><a href="/giang-vien/detail?maGV=${giangVien.maGV}">Detail</a></button>
                <button><a href="/giang-vien/view-update?maGV=${giangVien.maGV}">Edit</a></button>
                <button><a href="/giang-vien/remove?maGV=${giangVien.maGV}">Remove</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
