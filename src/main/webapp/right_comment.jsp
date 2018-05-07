<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 2018/3/29
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%-- 这个是用来显示主页面的，图片等信息--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<html>
<head>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>Title</title>
</head>
<body>
显示内容的
<div id="content">
    <c:forEach  items="${requestScope.page.urlList}" var="i" begin="0" end="5" varStatus="loop">
       <a href="showPic.action?id=${requestScope.page.list[loop.count-1].id}&click=true"><img src="http://localhost:8088/web-image/thumbnai/${i}.jpg" class="img-rounded"/></a>
        <div style="font-size:20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
       点击数 ${requestScope.page.list[loop.count-1].clickCount}评论数${requestScope.page.list[loop.count-1].totalComment}
        <br>
    </c:forEach>
</div>
<!--翻页时进行判断jsp标准标签库	 -->
<%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
<c:if test="${requestScope.page.pageNum ==1}">
    <ul class="pagination">
        <li class="disabled"><a href="#">&laquo;</a></li>

        <c:forEach begin="${requestScope.page.start}" end="${requestScope.page.end}" step="1" var="i">
            <c:if test="${requestScope.page.pageNum == i}">
                <li class="disabled"><a href="#">${i}</a></li>
            </c:if>
            <c:if test="${requestScope.page.pageNum != i}">
                <li><a href="showbycomment.action?pageNum=${i}">${i}</a></li>
            </c:if>
        </c:forEach>
        <li><a href="showbycomment.action?pageNum=${requestScope.page.pageNum+1}">&raquo;</a></li>
    </ul>
</c:if>
<%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
<c:if test="${requestScope.page.pageNum > 1 && requestScope.page.pageNum < requestScope.page.totalPage}">
    <ul class="pagination">
        <li ><a href="showbycomment.action?pageNum=${requestScope.page.pageNum-1}">&laquo;</a></li>

        <c:forEach begin="${requestScope.page.start}" end="${requestScope.page.end}" step="1" var="i">
            <c:if test="${requestScope.page.pageNum == i}">
                <li class="disabled"><a href="#">${i}</a></li>
            </c:if>
            <c:if test="${requestScope.page.pageNum != i}">
                <li><a href="showbycomment.action?pageNum=${i}">${i}</a></li>
            </c:if>
        </c:forEach>
        <li><a href="showbycomment.action?pageNum=${requestScope.page.pageNum+1}">&raquo;</a></li>
    </ul>
</c:if>
<%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
<c:if test="${requestScope.page.pageNum == requestScope.page.totalPage}">
    <ul class="pagination">
        <li><a href="showbycomment.action?pageNum=${requestScope.page.pageNum-1}">&laquo;</a></li>

        <c:forEach begin="${requestScope.page.start}" end="${requestScope.page.end}" step="1" var="i">
            <c:if test="${requestScope.page.pageNum == i}">
                <li class="disabled"><a href="#">${i}</a></li>
            </c:if>
            <c:if test="${requestScope.page.pageNum != i}">
                <li><a href="showbycomment.action?pageNum=${i}">${i}</a></li>
            </c:if>
        </c:forEach>
        <li class="disabled"><a href="#">&raquo;</a></li>
    </ul>
</c:if>

</body>
</html>
