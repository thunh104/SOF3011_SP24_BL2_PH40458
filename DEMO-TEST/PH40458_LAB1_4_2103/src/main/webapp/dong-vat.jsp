<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hthu khong depp
  Date: 3/20/2024
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Động vật</title>
</head>
<body>
<table border="1">
    <form>
        Tên:
        <input type="text">
        <button type="submit">Search</button>
    </form>
    <br><br>
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
    <button>Add</button>
    <thead>
    <tr>
        <td>ID</td>
        <td>Tên</td>
        <td>Tuổi</td>
        <td>Giới tính</td>
        <td>Khu vực</td>
        <td>Cân nặng</td>
        <td colspan="3">Action</td>
    </tr>
    </thead>
    <c:forEach items="${dv}" var="dv1" varStatus="i">
        <tr>
            <td>${dv1.id}</td>
            <td>${dv1.ten}</td>
            <td>${dv1.tuoi}</td>
            <td>${dv1.gioiTinh == true ? "1" : "0"}</td>
            <td>${dv1.khuVuc}</td>
            <td>${dv1.canNang}</td>
            <td>
                <button><a href="/dong-vat/update?id=${dv1.id}">Update</a></button>
                <button><a href="/dong-vat/remove?id=${dv1.id}">Remove</a></button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
