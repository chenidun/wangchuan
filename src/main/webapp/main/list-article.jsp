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
        <div class="main-header">
            <a href="../main/add-article.jsp"><button style="color: brown;font-weight: normal;font-size: 25px; background-color: #c5d4e9;display: inline-block;position: relative;
    margin: 20px;text-decoration: none;-webkit-border-radius: 30px;-moz-border-radius: 30px;border-radius: 10px;" name="add-article" onclick="add-article()">添加纪事</button></a>
        </div>
        <div class="main-inner">
            <div class="img-border">
                <header class="hhfont">憨憨式无辜QoQ</header>
                <img class="hhimg" src="../img/hh1.jpg" >
            </div>
            <div class="img-border">
                <header class="hhfont">憨憨式翘臀wow</header>
                <img class="hhimg" src="../img/hh2.jpg">
            </div>
            <div class="img-border">
                <header class="hhfont">憨憨式高冷</header>
                <img class="hhimg" src="../img/hh3.jpg">
            </div>


        </div>
    </main>
</div>
</body>
</html>