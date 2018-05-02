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
    <script type="text/JavaScript">
        var domain = "${pageContext.request.contextPath}";

        var id="${content.id}"

    </script>
    <title>Title</title>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/res/common/js/my.js" type="text/javascript"></script>


</head>
<body>

${content.creatTime}${content.imgurl}${content.description}${content.title}
private int totalComment;
private int clickCount;
<img src="http://localhost:8088/web-image/${content.imgurl}" height="500" width="500">
<div>
    <div id="append">

    </div>
    <div id="content">
        <c:forEach  items="${requestScope.page.list}" var="i" begin="0" end="10" varStatus="loop">
            ${i.content}
            <div style="font-size:20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
            <br>
        </c:forEach>
    </div>

</div>
<c:if test="${requestScope.page.totalPage==0}">
    暂无评论

</c:if>

<div id="reply">
    <textarea class="form-control" rows="3" id="comment"></textarea>
    <br>
    <button type="button" class="btn btn-primary" id="btn">评论</button>
    结果：<span id="result"></span>
</div>
<!--翻页时进行判断jsp标准标签库	 -->
<%--如果当前页为第一页时且不是最后一页，就没有上一页这个超链接显示 ，有下一页显示--%>
<c:if test="${requestScope.page.pageNum ==1&&$requestScope.page.pageNum != requestScope.page.totalPage&&requestScope.page.totalPage!=0}">
    <ul class="pagination">
        <li class="disabled"><a href="#">&laquo;</a></li>

        <c:forEach begin="${requestScope.page.start}" end="${requestScope.page.end}" step="1" var="i">
            <c:if test="${requestScope.page.pageNum == i}">
                <li class="disabled"><a href="#">${i}</a></li>
            </c:if>
            <c:if test="${requestScope.page.pageNum != i}">
                <li><a href="showPic.action?pageNum=${i}&id=${content.id}">${i}</a></li>
            </c:if>
        </c:forEach>
        <li><a href="showPic.action?pageNum=${requestScope.page.pageNum+1}&id=${content.id}">&raquo;</a></li>
    </ul>
</c:if>
<%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
<c:if test="${requestScope.page.pageNum > 1 && requestScope.page.pageNum < requestScope.page.totalPage}">
    <ul class="pagination">
        <li ><a href="showPic.action?pageNum=${requestScope.page.pageNum-1}&id=${content.id}">&laquo;</a></li>

        <c:forEach begin="${requestScope.page.start}" end="${requestScope.page.end}" step="1" var="i">
            <c:if test="${requestScope.page.pageNum == i}">
                <li class="disabled"><a href="#">${i}</a></li>
            </c:if>
            <c:if test="${requestScope.page.pageNum != i}">
                <li><a href="showPic.action?pageNum=${i}&id=${content.id}">${i}</a></li>
            </c:if>
        </c:forEach>
        <li><a href="showPic.action?pageNum=${requestScope.page.pageNum+1}&id=${content.id}">&raquo;</a></li>
    </ul>
</c:if>
<%-- 如果当前页是最后一页且不是只有一页，则只有上一页这个超链接显示，下一页没有 --%>
<c:if test="${requestScope.page.pageNum == requestScope.page.totalPage&&requestScope.page.pageNum !=1}">
    <ul class="pagination">
        <li><a href="showPic.action?pageNum=${requestScope.page.pageNum-1}&id=${content.id}">&laquo;</a></li>

        <c:forEach begin="${requestScope.page.start}" end="${requestScope.page.end}" step="1" var="i">
            <c:if test="${requestScope.page.pageNum == i}">
                <li class="disabled"><a href="#">${i}</a></li>
            </c:if>
            <c:if test="${requestScope.page.pageNum != i}">
                <li><a href="showPic.action?pageNum=${i}&id=${content.id}">${i}</a></li>
            </c:if>
        </c:forEach>
        <li class="disabled"><a href="#">&raquo;</a></li>
    </ul>
</c:if>


</body>
</html>