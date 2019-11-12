<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <%@ include file="left.jsp" %>
    <main id="main">
        <div>
            <h4 style="text-align: center;margin-top: auto;padding-top: 15px">添加纪事</h4>
        </div>
        <div>
            <form style="text-align: center">
                纪事标题:<input type="text" name="title"><br/><br/>
                纪事内容：<textarea cols="30" rows="4"></textarea><br/><br/>
                <button type="button" style="color: brown;font-weight: normal;font-size: 25px; background-color: #c5d4e9;" name="add-article" onclick="add-article()">添加纪事</button>&nbsp;
                <button type="reset" style="color: brown;font-weight: normal;font-size: 25px; background-color: #c5d4e9;" name="add-article" onclick="add-article()">重置</button>
            </form>
        </div>
    </main>
</div>
</body>
</html>