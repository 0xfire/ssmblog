<%--
  Created by IntelliJ IDEA.
  User: 0xfire
  Date: 2020/3/8
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>
<h1>注册成功</h1>
注册信息为：<%=request.getSession().getAttribute("USER_SESSION") %>
</body>
</html>
