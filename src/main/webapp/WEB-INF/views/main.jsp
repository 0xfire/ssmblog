<%--
  Created by IntelliJ IDEA.
  User: 0xfire
  Date: 2020/5/8
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>主页</title>
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script>
        //页面加载，绑定单击时间
        $(function () {
            $("#btn").click(function () {

                $.ajax({
                    url:"/user/findAll",
                    type:"post",
                    success:function (data) {
                        for (i=0;i<data.length;i++){
                            html="";
                        }
                    }
                })
            })
        })

    </script>
</head>
<body>
当前用户<p>${USER_SESSION.name}</p><br>

<a href="/user/logout">退出</a>
<button id="btn">查询所有用户</button>
<div>
    <p id="name"></p>
    <p id="password"></p>
</div>
</body>
</html>
