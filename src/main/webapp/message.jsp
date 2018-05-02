<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 2018/5/2
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="content">
    <c:forEach  items="${requestScope.list}" var="i" begin="0" end="10" varStatus="loop">
        ${i.userEntity.username}：回复您：在标题${i.content.title}下：${i.comment.content}
        <div style="font-size:20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
        <br>

    </c:forEach>
    啦啦啦
</div>

</body>
</html>
