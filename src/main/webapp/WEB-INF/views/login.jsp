<%--
  Created by IntelliJ IDEA.
  User: 0xfire
  Date: 2020/5/7
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/user/login" method="post">
    账号<input type="text" name="name"><br>
    密码<input type="password" name="password"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
