<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <form action="">
        Tên: <input name="ten"/>
        <button type="submit">Search</button>
    </form>
    <br/>
    <a href="/sinh-vien/view-add">Add Student</a>
    <tr>
        <th>STT</th>
        <th>MSSV</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
<%--    for(Đối tượng: mảng)--%>
    <c:forEach items="${a}" var="sinhVien" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${sinhVien.mssv}</td>
            <td>${sinhVien.ten}</td>
            <td>${sinhVien.tuoi}</td>
            <td>${sinhVien.diaChi}</td>
            <td>${sinhVien.gioiTinh}</td>
            <td>
                <a href="/sinh-vien/remove?mssv=${sinhVien.mssv}">Delete</a>
                <a href="/sinh-vien/detail?mssv=${sinhVien.mssv}">Detail</a>
                <a href="/sinh-vien/view-update?mssv=${sinhVien.mssv}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
