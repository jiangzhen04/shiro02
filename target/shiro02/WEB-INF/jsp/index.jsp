<%--
  Created by IntelliJ IDEA.
  User: T440s
  Date: 2021/11/27
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>登录成功</h1>
    <div>
        <s:hasRole name="高级用户">
            <a href="<%=request.getContextPath()%>/user/gj">高级用户</a><br/>
        </s:hasRole>
    </div>
    <div>
        <s:hasRole name="管理员">
            <a href="#">管理员</a><br/>
        </s:hasRole>
    </div>
    <div>
        <s:hasRole name="普通用户">
            <a href="#">普通用户</a><br/>
        </s:hasRole>
    </div>

    <div>
        <s:hasPermission name="书本查询">
            <h2>书本查询</h2><br/>
        </s:hasPermission>
    </div>

</body>
</html>
