<%--
  Created by IntelliJ IDEA.
  User: Hthu khong depp
  Date: 3/7/2024
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo buổi 1</title>
</head>
<body>
<form action="/ket-qua" method="post">
    ${mess123}
    <div class="container">
        <label for="uname"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>

        <button type="submit">Login</button>
    </div>
</form>
</body>
</html>
