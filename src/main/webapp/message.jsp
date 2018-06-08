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

        <div class="well"><span class="text-primary"><font size="3">${i.userEntity.name}：在您发布的${i.content.title}下评论：${i.comment.content}</></span>
            <button type="button" class="btn btn-default" onclick="window.location.href='showPic.action?mid=${i.id}&&id=${i.content.id}'">查看</button></div>
    </c:forEach>
    <c:if test="${requestScope.list==null}">
        您展示没有发布任何照片
    </c:if>
    啦啦啦
</div>

</body>
</html>
