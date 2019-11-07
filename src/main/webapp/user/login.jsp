<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="../css/user.css">
</head>
<body>
    <div class="login">
        <form action="/user/selectUser" method="post">
            <br/>
            账号：<input type="text" name="username"/><br/><br/>
            密码：<input type="password" name="password"><br/><br/>
            <input type="submit" value="登录" class="anniu"/>
            <a href="register.jsp"><input type="button" value="注册" class="anniu" /></a>
        </form>
    </div>
</body>
</html>