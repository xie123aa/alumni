<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 2018/4/26
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="head.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    ${content.creatTime}${content.imgurl}${content.description}${content.title}
    private int totalComment;
    private int clickCount;
    <img src="http://localhost:8088/web-image/${content.imgurl}">
</head>
<body>

</body>
</html>
