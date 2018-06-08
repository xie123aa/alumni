<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 2018/3/25
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<html>
<head>
    <title>登陆界面</title>
    <style>
        #main{
            width:300px;
            height:200px;  position:absolute; left:50%; top:50%; margin-left:-150px; margin-top:-200px;

        }
        .bodystyle{
            filter:alpha(opacity=50);
            -moz-opacity:0.5;
            -khtml-opacity: 0.5;
            opacity: 0.5;
            height:100%;
            width:100%;
            position:absolute;
            background:url("${pageContext.request.contextPath}/res/common/image/201705.jpg");
        }
    </style>
</head>

<body>
<div class="bodystyle">
</div>





<center id="main">
    <h1 ><p  class="text-muted">登陆</p></h1>
    <form id="indexform" name="indexForm" action="login.action" method="post">
        <table border="0">
            <tr>
                <td><button type="button" class="btn btn-default btn-lg" style="color: rgb(212, 106, 64);">
                    账号
                </button>
                </td>
                <td><div class="input-group input-group-lg">
                    <input type="text" name="userEntity.username" class="form-control" placeholder="账号">
                </div></td>
            </tr>
            <tr>
                <td>
                    <button type="button" class="btn btn-default btn-lg" style="color: rgb(212, 106, 64);">
                密码
            </button>
                <td>
                <div class="input-group input-group-lg">
                <input type="password" name="userEntity.password"class="form-control" placeholder="密码">
                </div>
                </td>
            </tr>
        </table>
        <br>
        <input type="submit" class="btn btn-primary"value="登录" >
        <input type="button" class="btn btn-default" value="注册" onclick= "window.location.href='register.jsp'"></button>
    </form>
    <s:if test="hasActionErrors()">
        <div class="errors">
            <div class="alert alert-danger"><s:actionerror/></div>
        </div>
    </s:if>
</center>
</body>
</html>
