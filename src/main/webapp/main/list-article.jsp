<%@ page import="com.chenly.model.Article" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <script type="text/javascript" src="../jquery/jquery-1.10.2.min.js"></script>

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
        <% List<Article> articleList= (List<Article>)request.getAttribute("articleList");%>
        <div class="main-inner">
<%--            <c:forEach items="${data}" var="article">--%>
<%--                <div class="img-border">--%>
<%--                    <header class="hhfont">${article.title}</header><br/>--%>
<%--                    <span>${article.content}</span>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
            <table border="1px" cellspacing="0" with="300">
                <tr>
                    <td>id</td>
                    <td>标题</td>
                    <td>内容</td>
                </tr>
                <% for( Article  article:articleList){ %>

                <% } %>
            </table>
        </div>
    </main>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $.ajax({
            url: '/demo/article/getList',
            type: 'get',
            contentType:"application/json; charset=utf-8",
            dataType:'json',
            success: function (data) {
                var name = document.getElementsByClassName("main-header");
                if (data.code === 1) {
                    //请求成功
                    // console.log(JSON.stringify(data));
                    for (var i = 0; i < data.length; i++) {
                        renderTemp(data[i], name)
                    }
                }
            }
        })

        function renderTemp(data, varName ) {
            console.log(data);

        }
    })
</script>
</body>
</html>