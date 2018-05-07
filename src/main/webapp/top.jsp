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
    <li role="presentation" class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
            管理 <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a href="contentManage.action" target="mainFrame">我的发布 </a></li>
           <li><a href="commentManage.action" target="mainFrame">我的评论</a></li>
        </ul>
    </li>
    <li><a href="${pageContext.request.contextPath }/message.action" target="mainFrame">通知</a></li>
    <li><a href="${pageContext.request.contextPath }/logout.action"target="_parent" >注销</a></li>
</ul>
</body>
</html>
