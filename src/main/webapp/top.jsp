<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 2018/3/29
  Time: 14:34
  To change this template use File | Settings | File Templates.
  导航栏
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    登陆成功
    欢迎您${sessionScope.userInfo.username}
<ul class="nav nav-pills">
    <li class="active"><a href="${pageContext.request.contextPath }/index.jsp" target="_parent">首页</a></li>
    <li><a href="${pageContext.request.contextPath }/post.jsp" target="mainFrame">发布</a></li>
    <li><a href="${pageContext.request.contextPath }/manage.jsp" target="mainFrame">管理</a></li>
</ul>
</body>
</html>
