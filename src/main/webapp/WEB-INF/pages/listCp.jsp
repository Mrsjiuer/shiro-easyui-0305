<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="bootstrap.min.css"/>
    <link rel="stylesheet" href="bootstrap-datetimepicker.css"/>
    <script src="jquery-1.10.2.min.js"></script>
    <script src="bootstrap.min.js"></script>
    <script src="bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="echarts.min.js"></script>

</head>
<body>
    <form action="listCp.html" method="post" id="searchForm">
        <input type="hidden" id="pageNum" name="pageNum">
        游戏名<input name="name" value="${param.name}"/>
        <input type="submit" value="查询"><button><a href="/go_updateCp.html">添加</a></button>
    </form>
<table border="1">
    <tr>
        <td>编号</td>
        <td>公司</td>
        <td>密钥</td>
        <td>支付通知密钥</td>
        <td>密码</td>
        <td>状态</td>
        <td>创建日期</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.cps}" var="d">
        <tr id="tr-${d.id}">
            <td>${d.id}</td>
            <td>${d.name}</td>
            <td>${d.secretKey}</td>
            <td>${d.noticeKey}</td>
            <td>${d.password}</td>
            <td>${d.status eq 1?"有效":"失效"}</td>
            <td><fmt:formatDate value="${d.createdDate}" pattern="yyyy-MM-dd"/></td>
            <td><a href="go_updateCp.html?id=${d.id}">修改</a><a href="#" onclick="deleteGame(${d.id})">删除</a> </td>
        </tr>
    </c:forEach>
</table>
<script>
    function deleteGame(id) {
        if (confirm("确定要删除吗")) {
            $.ajax({
                url: "/deleteCp.html",
                method: "post",
                data: "id=" + id,
                success: function (json) {
                    if (json.res > 0) {
                        //alert(json.res)
                        $("#tr-" + id).remove()
                    } else {
                        alert(json.message)
                    }
                }
            })
        }
    }
</script>
</body>
</html>
