<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: george
  Date: 2018/3/25
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
<s:if test="hasActionErrors()">
    <div class="errors">
        <s:actionerror/>
    </div>
</s:if>

<center>
    <h1 style="color:red">登录</h1>
    <form id="indexform" name="indexForm" action="login.action" method="post">
        <table border="0">
            <tr>
                <td>账号：</td>
                <td><input type="text" name="userEntity.username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="userEntity.password">
                </td>
            </tr>
        </table>
        <br>
        <input type="submit" value="登录" style="color:#BC8F8F">
    </form>
    <form action="register.jsp">
        <input type="submit" value="注册" style="color:#BC8F8F">
    </form>
</center>
</body>
</html>
