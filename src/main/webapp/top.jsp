<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 2018/3/29
  Time: 14:34
  To change this template use File | Settings | File Templates.
  导航栏
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="nav">
    <a href="${pageContext.request.contextPath }/" >首页</a>
    <a href="${pageContext.request.contextPath }/post.jsp"  target="mainFrame">发布</a>
    <a href="${pageContext.request.contextPath }/">管理</a>
    登陆成功
    欢迎您${sessionScope.userInfo.username}

</div>
</body>
</html>
