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
        <input type="text" name="mssv"/>
        ${checkMa}
        <br>
        <label for="">Họ tên:</label>
        <input type="text" name="ten"/>
        ${checkTen}
        <br>
        <label for="">Tuổi:</label>
        <input type="text" name="tuoi"/>
        ${checkTuoi} ${checkTuoi25}
        <br>
        <label for="">Dia chi:</label>
        <input type="text" name="diaChi"/>
        ${checkQueQuan}
        <br>
        Gioi tinh:
        <div class="form-check">
            <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault1">
            <label class="form-check-label" for="flexRadioDefault1">
                Nam
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault2" checked>
            <label class="form-check-label" for="flexRadioDefault2">
                Nu
            </label>
        </div>
        <br>
        <button type="submit">Add</button>
        <br><br>
    </form>
    <thead>
    <tr>
        <th>Ma</th>
        <th>Ten</th>
        <th>Tuoi</th>
        <th>Dia chi</th>
        <th>Gioi tinh</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sv}" varStatus="i" var="sinhVien">
        <tr>
            <td>${sinhVien.mssv}</td>
            <td>${sinhVien.ten}</td>
            <td>${sinhVien.tuoi}</td>
            <td>${sinhVien.diaChi}</td>
            <td>${sinhVien.gioiTinh == true ? "Nam" : "Nu"}</td>
            <td>
                <a href="/sinh-vien/detail?mssv=${sinhVien.mssv}"><button>Detail</button></a>
                <a href="/sinh-vien/view-update?mssv=${sinhVien.mssv}"><button>Edit</button></a>
                <button><a href="/sinh-vien/remove?mssv=${sinhVien.mssv}">Remove</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
