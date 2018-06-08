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
    <style type="text/css">
        #logout
        {
            position:absolute;
            right:0px
        }
    </style>
</head>
<body >
<div>
<span class="text-info ">欢迎您${sessionScope.userInfo.username}</span>
</div>

<ul class="nav nav-pills ">
    <li class="active"><a href="${pageContext.request.contextPath }/index.action" target="_parent">首页</a></li>
    <li><a href="${pageContext.request.contextPath }/post.jsp" target="mainFrame"><span class="	glyphicon glyphicon-upload"></span>发布</a></li>
    <li role="presentation" class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
            <span class="glyphicon glyphicon-cog"></span>管理 <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a href="contentManage.action" target="mainFrame">我的发布 </a></li>
           <li><a href="commentManage.action" target="mainFrame">我的评论</a></li>
        </ul>
    </li>
    <li><a href="${pageContext.request.contextPath }/message.action" target="mainFrame"><span class="glyphicon glyphicon-inbox"></span>通知</a></li>
    <li id="logout"><a href="${pageContext.request.contextPath }/logout.action"target="_parent" ><span class="glyphicon glyphicon-log-out "></span>注销</a></li>
</ul>
</body>
</html>
