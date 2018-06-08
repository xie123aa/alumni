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
        var name="${sessionScope.userInfo.name}"

    </script>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/res/common/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/res/common/js/my.js" type="text/javascript"></script>


</head>
<body>
<div class="panel panel-info">
    <div class="panel-heading">
        <h1>${content.title}</h1>
    </div>
    <div class="panel-body">
        <button class="btn btn-primary btn">
            <span class="glyphicon glyphicon-time"></span> 发布时间
        </button>:${content.creatTime}   <button class="btn btn-primary btn">
            <span class="glyphicon glyphicon-user"></span> 发布者
        </button>：${content.userEntity.name}

        <br>
         <button class="btn btn-primary btn">
        <span class="glyphicon glyphicon-info-sign"></span> 描述
        </button>
        ${content.description}
        <br>

        <img src="http://localhost:8088/web-image/${content.imgurl}" height="500" width="500">
    </div>
    <div class="panel-footer">
        <div>
            <div id="append">

            </div>
            <div id="content">
                <c:forEach  items="${requestScope.page.list}" var="i" begin="0" end="10" varStatus="loop">
                    <div class="well well-sm"><span class="text-success">${i.userEntity.name}在${i.creatTime}回复：</span>
                        <br> ${i.content}</div>

                </c:forEach>
            </div>

        </div>
    </div>
</div>



<c:if test="${requestScope.page.totalPage==0}">
    暂无评论

</c:if>

<div id="reply">
    <textarea class="form-control" rows="3" id="comment" placeholder="输入你的评论"></textarea>
    <br>
    <button type="button" class="btn btn-primary" id="btn">评论</button>
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
