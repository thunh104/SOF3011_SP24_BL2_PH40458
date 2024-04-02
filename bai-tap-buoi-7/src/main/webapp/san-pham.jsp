<%--
  Created by IntelliJ IDEA.
  User: Hthu khong depp
  Date: 3/18/2024
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sản phẩm</title>
</head>
<body>
<table border="1">
    <form action="/san-pham/add" method="post">
        <label for="">Tên:</label>
        <input type="text" name="ten"/>
        <br>
        <button type="submit">Search</button>
        <br>
        <br>
        <label for="">ID:</label>
        <input type="text" name="id" value="${spl.id}"/>
        ${checkMa}
        <br>
        <label for="">Mã:</label>
        <input type="text" name="ma" value="${spl.ma}"/>
        ${checkMa}
        <br>
        <label for="">Tên:</label>
        <input type="text" name="ten" value="${spl.ten}"/>
        ${checkTen}
        <br>
        <label for="">Giá:</label>
        <input type="text" name="gia" value="${spl.gia}"/>
        ${checkTuoi}
        <br>
        <label for="">Loại:</label>
        <select class="form-select" aria-label="Default select example" name="loai">
            <option value="1" ${spl.loai == 1 ? "selected" : ""}>Loại 1</option>
            <option value="2" ${spl.loai == 2 ? "selected" : ""}>Loại 2</option>
            <option value="3" ${spl.loai == 3 ? "selected" : ""}>Loại 3</option>
            <option value="4" ${spl.loai == 4 ? "selected" : ""}>Loại 4</option>
        </select>
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
        <th>Loại</th>
        <th>Giá</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sp}" var="sanPham" varStatus="i">
        <tr>
            <td>${sanPham.id}</td>
            <td>${sanPham.ma}</td>
            <td>${sanPham.ten}</td>
            <td>${sanPham.loai}</td>
            <td>${sanPham.gia}</td>
            <td>
                <button><a href="/san-pham/detail?ma=${sanPham.ma}">Detail</a></button>
                <button><a href="/san-pham/view-update?ma=${sanPham.ma}">Edit</a></button>
                <button><a href="/san-pham/remove?ma=${sanPham.ma}">Remove</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>