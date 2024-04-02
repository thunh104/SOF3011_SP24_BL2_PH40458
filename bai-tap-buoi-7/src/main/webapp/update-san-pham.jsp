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
    <title>Chỉnh sửa thông tin sản phẩm</title>
</head>
<body>
<form action="" method="post">
    ID:
    <input type="text" name="id" value="${sp1.id}"/>
    <br>
    Mã:
    <input type="text" name="ma" value="${sp1.ma}"/>
    <br>
    Tên:
    <input type="text" name="ten" value="${sp1.ten}"/>
    <br>
    Giá:
    <input type="text" name="gia" value="${sp1.gia}"/>
    Loại:
    <select class="form-select" aria-label="Default select example" name="loai">
        <option value="1" ${sp1.loai == 1 ? "selected" : ""}>Loại 1</option>
        <option value="2" ${sp1.loai == 2 ? "selected" : ""}>Loại 2</option>
        <option value="3" ${sp1.loai == 3 ? "selected" : ""}>Loại 3</option>
        <option value="4" ${sp1.loai == 4 ? "selected" : ""}>Loại 4</option>
    </select>
    <br><br>
    <button type="submit">Update</button>
    <br><br>
</form>
</body>
</html>
