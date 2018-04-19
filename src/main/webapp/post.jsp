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
<form id="jvForm" action="" method="post" enctype="multipart/form-data">
    <td>上传商品图片(90x150尺寸):</td>
    <td width="80%" class="pn-fcontent">
        注:该尺寸图片必须为90x150。
    </td>
    </tr>
    <tr>
        <td width="20%" class="pn-flabel pn-flabel-h"></td>
        <td width="80%" class="pn-fcontent">
            <img width="100" height="100" id="allImgUrl"/>
            <input type="hidden" name="imgUrl" id="path"/>
            <input type="file" onchange="uploadPic()" name="pic"/>
            <input type="submit" class="submit" value="提交"/> &nbsp; <input type="reset" class="reset" value="重置"/>
        </td>
    </tr>
</form>
</body>
</html>