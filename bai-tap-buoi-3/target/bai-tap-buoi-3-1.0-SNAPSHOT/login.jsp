<%--
  Created by IntelliJ IDEA.
  User: Hthu khong depp
  Date: 3/8/2024
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/home" method="post">
    <label for="inputUsername" class="form-label">Username:</label>
    <input type="text" class="form-control" id="inputUsername" name="username">
    <br>
    ${msgUser}
    <br>
    <label for="inputPassword" class="form-label">Password:</label>
    <input type="text" class="form-control" id="inputPassword" name="password">
    <br>
    ${msgPass}
    ${message}
    <br>
    <button type="submit">Login</button>
</form>
</body>
</html>
