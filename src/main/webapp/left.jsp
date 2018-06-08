<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 2018/3/29
  Time: 14:40
  To change this template use File | Settings | File Templates.
  分类查看
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body class="bg-info" >
<div id="nav" >
    <ul class="nav nav-pills nav-stacked">
        <li role="presentation"><a href="${pageContext.request.contextPath }/showAll.action" target="rightFrame">最新查看</a></li>
        <li role="presentation"><a href="${pageContext.request.contextPath }/showbycomment.action" target="rightFrame">最多评论</a></li>
        <li role="presentation"><a href="${pageContext.request.contextPath }/showbyclick.action" target="rightFrame">最多点赞</a></li>
    </ul>
</div>

</body>
</html>
