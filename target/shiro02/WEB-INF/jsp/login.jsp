<%--
  Created by IntelliJ IDEA.
  User: T440s
  Date: 2021/11/26
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>登录</h1>
    <h2 style="color: red">${message}</h2>
    <form action="<%=request.getContextPath()%>/user/login" method="post">
        用户名：<input name="username" /><br/>
        密码:<input type="password" name="password" ><br/>
        <input type="submit" value="登录">
    </form>

</body>
</html>
