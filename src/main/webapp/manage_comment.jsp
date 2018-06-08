<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 2018/4/26
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${requestScope.page.list==null}">
   您展示没有发布评论
</c:if>
<table class="table table-hover">
    <thead>
    <th>评论图片的标题</th>
    <th>图片作者</th>
    <th>发布时间</th>
    <th>内容</th>
    <th>操作</th>
    </thead>
    <tbody>
<c:forEach  items="${requestScope.page.list}" var="i" begin="0" end="20" varStatus="loop">
<tr id="input${i.id}"+code>
    <td>${i.content1.title}</td>
    <td>${i.userEntity.name}</td>
    <td>${i.creatTime}</td>
    <td>${i.content}</td>
    <td> <input id="input"  class="shanchu" type="button" value="删除"  code="${i.id}"/></td>
</tr>
   </div>
</c:forEach>
    </tbody>
</table>
<script src="${pageContext.request.contextPath}/res/common/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    var domain = "${pageContext.request.contextPath}";

    $(".shanchu").click(function(){  //找到删除按钮，对其添加单击事件，单击之后执行事件
        var code = $(this).attr("code");   //找到属性值
        $.post(domain+"/deleteComment.action?id="+code,function (data) {
            alert("删除成功");
            $('#input'+code).fadeOut("slow");
        });
    })
</script>
<!--翻页时进行判断jsp标准标签库	 -->
<%--如果当前页为第一页时且不是最后一页，就没有上一页这个超链接显示 ，有下一页显示--%>
<c:if test="${requestScope.page.pageNum ==1&& requestScope.page.pageNum < requestScope.page.totalPage}">
    <ul class="pagination">
        <li class="disabled"><a href="#">&laquo;</a></li>

        <c:forEach begin="${requestScope.page.start}" end="${requestScope.page.end}" step="1" var="i">
            <c:if test="${requestScope.page.pageNum == i}">
                <li class="disabled"><a href="#">${i}</a></li>
            </c:if>
            <c:if test="${requestScope.page.pageNum != i}">
                <li><a href="commentManage.action?pageNum=${i}">${i}</a></li>
            </c:if>
        </c:forEach>
        <li><a href="commentManage.action?pageNum=${requestScope.page.pageNum+1}">&raquo;</a></li>
    </ul>
</c:if>
<%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
<c:if test="${requestScope.page.pageNum > 1 && requestScope.page.pageNum < requestScope.page.totalPage}">
    <ul class="pagination">
        <li ><a href="commentManage.action?pageNum=${requestScope.page.pageNum-1}}">&laquo;</a></li>

        <c:forEach begin="${requestScope.page.start}" end="${requestScope.page.end}" step="1" var="i">
            <c:if test="${requestScope.page.pageNum == i}">
                <li class="disabled"><a href="#">${i}</a></li>
            </c:if>
            <c:if test="${requestScope.page.pageNum != i}">
                <li><a href="commentManage.action?pageNum=${i}">${i}</a></li>
            </c:if>
        </c:forEach>
        <li><a href="commentManage.action?pageNum=${requestScope.page.pageNum+1}">&raquo;</a></li>
    </ul>
</c:if>
<%-- 如果当前页是最后一页且不是只有一页，则只有上一页这个超链接显示，下一页没有 --%>
<c:if test="${requestScope.page.pageNum == requestScope.page.totalPage&&requestScope.page.pageNum >1}">
    <ul class="pagination">
        <li><a href="commentManage.action?pageNum=${requestScope.page.pageNum-1}">&laquo;</a></li>

        <c:forEach begin="${requestScope.page.start}" end="${requestScope.page.end}" step="1" var="i">
            <c:if test="${requestScope.page.pageNum == i}">
                <li class="disabled"><a href="#">${i}</a></li>
            </c:if>
            <c:if test="${requestScope.page.pageNum != i}">
                <li><a href="commentManage.action?pageNum=${i}">${i}</a></li>
            </c:if>
        </c:forEach>
        <li class="disabled"><a href="#">&raquo;</a></li>
    </ul>
</c:if>

</body>
</html>
