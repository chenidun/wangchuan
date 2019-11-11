<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<% String path = request.getContextPath(); %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <%--    <link rel="stylesheet" type="text/css" href="../css/user.css">--%>
    <link rel="stylesheet" href="../css/login.css">
</head>
<body>
<div id="container">
    <div class="content">
        <div style="align-self: auto">
            <h1 style="font-family: 华文楷体;">铁憨憨的日常</h1>
        </div>
        <form action="/user/selectUser" method="post">
            <br/>
            <span style="font-family: 华文楷体;font-size: 18px">账号：</span>
            <input type="text" name="username"/><br/><br/>
            <span style="font-family: 华文楷体;font-size: 18px">密码：</span>
            <input type="password" name="password"><br/><br/>
            <button type="button" name="login" class="btn-primary" onclick="userlogin()">登录</button>
            <button type="button" name="register" class="btn-primary">注册</button>
            <%--<input type="submit" value="登录" class="anniu"/>
            <a href="register.jsp"><input type="button" value="注册" class="anniu"/></a>--%>
        </form>
    </div>
</div>
<script type="text/javascript" src="../jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
    function userlogin() {
        // 获取到form的用户名和密码
        var username = $("input[name=username]").val();
        var password = $("input[name=password]").val();

        $.ajax({
            url: "/demo/user/login",
            type: 'post',
            data: JSON.stringify({'username': username, 'password': password}),
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            success: function (result) {
                if (result.code === 1) {
                    // 请求成功
                    alert(result.message);
                    location.href = "../main/list.jsp";
                } else if (result.code === 112) {
                    alert(result.message);
                    location.href = "../user/login.jsp";
                }
            },
            error: function (result) {
                alert("登录失败！~")
                location.href = "../user/login.jsp";
            }
        })
    }
</script>
</body>
</html>