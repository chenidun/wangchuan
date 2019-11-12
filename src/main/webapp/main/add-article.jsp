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
            <a href="../main/list-article.jsp"><span style="float: right">返回</span></a>
        </div>
        <div>
            <form style="text-align: center">
                纪事标题:<input type="text" name="title"><br/><br/>
                纪事内容：<textarea cols="30" rows="4" name="content"></textarea><br/><br/>
                <button type="button" style="color: brown;font-weight: normal;font-size: 25px; background-color: #c5d4e9;" name="add-article" onclick="addArticle()">添加纪事</button>&nbsp;
                <button type="reset" style="color: brown;font-weight: normal;font-size: 25px; background-color: #c5d4e9;" name="add-article" >重置</button>
            </form>
        </div>
    </main>
</div>
<script type="text/javascript" src="../jquery/jquery-1.10.2.min.js"></script>

<script type="text/javascript">
    function addArticle(){
        var title = $("input[name=title]").val();
        var content = $("textarea[name=content]").val();
        console.log(title + "=====" + content);

        $.ajax({
            url: "/demo/article/add",
            type: "post",
            data: JSON.stringify({'title': title, 'content': content}),
            dataType: 'json',
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                if (data.code === 1) {
                    // 请求成功
                    alert("添加纪事成功啦！~");
                    location.href = "../main/list-article.jsp";
                } else {
                    alert("添加失败");
                    location.href = "../main/list-article.jsp";
                }
            }
        })
    }
</script>
</body>

</html>