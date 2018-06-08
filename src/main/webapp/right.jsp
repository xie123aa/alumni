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
 <title>Title</title>
    <style type="text/css">

    </style>
</head>
<body class="bg-info">
<div id="content">
    <table>
    <tr>
        <c:forEach items="${requestScope.page.urlList}" var="i" begin="0" end="4" varStatus="loop">
            <td>
            <div class="deatil">
                <span><a href="showPic.action?id=${requestScope.page.list[loop.count-1].id}&click=true"><img src="http://localhost:8088/web-image/thumbnai/${i}.jpg" class="img-rounded" width="200px" height="240px"/></a>&nbsp;&nbsp;&nbsp;&nbsp;</span>
            </div>
                <span class="text-muted">${requestScope.page.list[loop.count-1].title}</span>
                <br>
                <span class="text-primary"><font size="2" >发布者:</font></span><font size="2">${requestScope.page.list[loop.count-1].userEntity.name}&nbsp;</font>
                <span class="text-warning"><font size="2">点击数:<span class="badge">${requestScope.page.list[loop.count-1].clickCount}</span>评论数:<span class="badge">${requestScope.page.list[loop.count-1].totalComment}</span></font></span>
            </td>
        </c:forEach>
        </tr>
    </table>
<br>
    <table>
        <tr>
            <c:forEach items="${requestScope.page.urlList}" var="i" begin="5" end="10" varStatus="loop">

                <td>
                    <div class="deatil">


                        <span><a href="showPic.action?id=${requestScope.page.list[loop.count+4].id}&click=true"><img src="http://localhost:8088/web-image/thumbnai/${i}.jpg" class="img-rounded" width="200px" height="240px"/></a>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                    </div>
                    <span class="text-muted">${requestScope.page.list[loop.count+4].title}</span>
                    <br>
                    <span class="text-primary"><font size="2" >发布者:</font></span><font size="2">${requestScope.page.list[loop.count+4].userEntity.name}&nbsp;</font>
                    <span class="text-warning"><font size="2">点击数:<span class="badge">${requestScope.page.list[loop.count+4].clickCount}</span>评论数:<span class="badge">${requestScope.page.list[loop.count+4].totalComment}</span></font></span>

                </td>

                <%--<c:if test="${loop.count%5==0}">--%>
                <%--<tr>--%>
                <%--</c:if>--%>
            </c:forEach>
        </tr>
    </table>
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
                <li><a href="showAll.action?pageNum=${i}">${i}</a></li>
            </c:if>
        </c:forEach>
        <li><a href="showAll.action?pageNum=${requestScope.page.pageNum+1}">&raquo;</a></li>
    </ul>
</c:if>
<%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
<c:if test="${requestScope.page.pageNum > 1 && requestScope.page.pageNum < requestScope.page.totalPage}">
    <ul class="pagination">
        <li ><a href="showAll.action?pageNum=${requestScope.page.pageNum-1}">&laquo;</a></li>

        <c:forEach begin="${requestScope.page.start}" end="${requestScope.page.end}" step="1" var="i">
            <c:if test="${requestScope.page.pageNum == i}">
                <li class="disabled"><a href="#">${i}</a></li>
            </c:if>
            <c:if test="${requestScope.page.pageNum != i}">
                <li><a href="showAll.action?pageNum=${i}">${i}</a></li>
            </c:if>
        </c:forEach>
        <li><a href="showAll.action?pageNum=${requestScope.page.pageNum+1}">&raquo;</a></li>
    </ul>
</c:if>
<%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
<c:if test="${requestScope.page.pageNum == requestScope.page.totalPage}">
    <ul class="pagination">
        <li><a href="showAll.action?pageNum=${requestScope.page.pageNum-1}">&laquo;</a></li>

        <c:forEach begin="${requestScope.page.start}" end="${requestScope.page.end}" step="1" var="i">
            <c:if test="${requestScope.page.pageNum == i}">
                <li class="disabled"><a href="#">${i}</a></li>
            </c:if>
            <c:if test="${requestScope.page.pageNum != i}">
                <li><a href="showAll.action?pageNum=${i}">${i}</a></li>
            </c:if>
        </c:forEach>
        <li class="disabled"><a href="#">&raquo;</a></li>
    </ul>
</c:if>

</body>
</html>
