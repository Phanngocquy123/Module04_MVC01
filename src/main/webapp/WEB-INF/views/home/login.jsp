<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/11/2024
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
    <h1>Đăng nhập</h1>
    <p style="color: yellow">${msg}</p>
    <form action="/home/login" method="post">
        <p><b>Tài khoản: </b> <input tyle="text" name="user" ></p>
        <p><b>Mật khẩu: </b> <input type="password" name="pass"></p>
        <button>Đăng nhập</button>
    </form>
</body>
</html>
