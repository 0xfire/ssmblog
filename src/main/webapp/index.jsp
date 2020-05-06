<%--
  Created by IntelliJ IDEA.
  User: 0xfire
  Date: 2020/4/23
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>登录</h3>
<form action="/user/login" method="post">
    账号：<input type="text" name="name"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="提交">
</form>

<h3>注册</h3>
<form action="/user/register" method="post">
    账号：<input type="text" name="name" required><br>
    密码：<input type="text" name="password" required><br>
    性别：<select name="gender" >
             <option value ="man">男</option>
             <option value ="woman">女</option>
         </select>
    爱好：<input type="checkbox" name="hobby" value="math">
         <input type="checkbox" name="hobby" value="english"><br/>
    <input type="submit" value="提交">
</form>
<a href="/user/findAll">查询所有</a>
</body>
</html>
