<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 2018/3/29
  Time: 16:01
  To change this template use File | Settings | File Templates.
  发布图片
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>babasport-add</title>
    <script type="text/javascript">
        //上传图片
        function uploadPic(){
            //定义参数
            var options = {
                url : "${pageContext.request.contextPath}/uploadpic.action",
                dataType : "json",
                type :  "post",
                success : function(data){
                    //回调 二个路径
                    //url
                    //path
                    $("#allImgUrl").attr("src",data.url);
                    $("#path").val(data.path);

                }

            };

            //jquery.form使用方式
            $("#jvForm").ajaxSubmit(options);


        }
    </script>
</head>
<body>
<%-- action被覆盖--%>
<div class="jumbotron">
    <div class="container">
        <form id="jvForm" action="add.action" method="post" enctype="multipart/form-data">
            <div class="page-header">
                <h1>上传图片</h1>
            </div>
            <input type="text" class="form-control" placeholder="标题" name="content.title"  style="width:300px; height:34px;" />
            <input type="text" class="form-control" placeholder="图片描述" name="description"/>
            <tr>
                <td width="20%" class="pn-flabel pn-flabel-h"></td>
                <td width="80%" class="pn-fcontent">
                    <img width="200" height="200" id="allImgUrl"/>
                    注:图片显示后再提交,图片大小不超过5M
                    <input type="hidden" name="imgurl" id="path"/>
                    <input type="file" onchange="uploadPic()" name="pic" />
                    <input type="submit" class="submit" value="提交" /> &nbsp;
                    <input type="reset" class="reset" value="重置"/>
                </td>
            </tr>
        </form>
    </div>
</div>

</body>
</html>