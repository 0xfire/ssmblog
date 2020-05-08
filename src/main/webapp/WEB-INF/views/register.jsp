<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h3>注册</h3>
<form action="/user/register" method="post" enctype="multipart/form-data">
    账号：<input type="text" name="name" required><br>
    密码：<input type="text" name="password" required><br>
    性别：<select name="gender">
    <option value="man">男</option>
    <option value="woman">女</option>
</select>
    爱好：<input type="checkbox" name="hobby" value="math">数学
    <input type="checkbox" name="hobby" value="english">英语<br/>

    个人信息：<input type="text" name="userInfo" required><br>
    家庭地址：<input type="text" name="addresses[0].userAddress" required><br>
    <input type="hidden" value="homeAddress" name="addresses[0].type">
    工作地址：<input type="text" name="addresses[1].userAddress" required><br>
    <input type="hidden" value="workAddress" name="addresses[1].type">
    头像：<input type="file" name="userAvatar">
    <input type="submit" value="注册">
</form>
</body>
</html>
