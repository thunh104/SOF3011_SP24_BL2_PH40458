<%--
  Created by IntelliJ IDEA.
  User: Hthu khong depp
  Date: 3/11/2024
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hiển thị giảng viên</title>
</head>
<body>
<table border="1">
    <form action="">
        <label for="">Tên:</label>
        <input type="text" name="ten">
        <br>
        <button type="submit">Search</button>
    </form>
    <br>
    <br>
    <button><a href="/giang-vien/view-add">Add</a></button>
    <button type="submit">Giảng viên nữ</button>
    <br>
    <thead>
    <tr>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Giới tính</th>
        <th>Địa chỉ</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${gv}" var="giangVien" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${giangVien.ma}</td>
            <td>${giangVien.ten}</td>
            <td>${giangVien.tuoi}</td>
            <td>${giangVien.gioiTinh == true ? "Cái" : "Đực"}</td>
            <td>${giangVien.diaChi}</td>
            <td>
                <button><a href="/giang-vien/detail?ma=${giangVien.ma}">Detail</a></button>
                <button><a href="/giang-vien/edit?ma=${giangVien.ma}">Edit</a></button>
                <button><a href="/giang-vien/remove?ma=${giangVien.ma}">Remove</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
