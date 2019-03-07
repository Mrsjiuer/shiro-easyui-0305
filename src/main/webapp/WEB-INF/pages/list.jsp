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
    <form action="list.html" method="post" id="searchForm">
        <input type="hidden" id="pageNum" name="pageNum">
        游戏名<input name="name" value="${param.name}"/>
        <input type="submit" value="查询"><button><a href="/go_update.html">添加</a></button>
    </form>
<table border="1">
    <tr>
        <td>游戏</td>
        <td>状态</td>
        <td>日期</td>
        <td>下载地址</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.pageInfo.list}" var="d">
        <tr id="tr-${d.id}">
            <td>${d.name}</td>
            <td>${d.status eq 1?"开服":"停服"}</td>
            <td><fmt:formatDate value="${d.createdDate}" pattern="yyyy-MM-dd"/></td>
            <td>${d.downloadUrl}</td>
            <td><a href="go_update.html?id=${d.id}">修改</a><a href="#" onclick="deleteGame(${d.id})">删除</a> </td>
        </tr>
    </c:forEach>
</table>
         <a class="disabled" href="#" onclick="chagePage(1)">首页</a>
      <a href="#" onclick="chagePage(${requestScope.pageInfo.prePage})">上一页</a>
        <c:forEach items="${requestScope.pageInfo.navigatepageNums}" var="num">
            <a class="${num eq pageInfo.pageNum?'':''}"><a href="#" onclick="chagePage(${num})">${num}</a>
            </a>
        </c:forEach>
        <c:if test="${pageInfo.hasNextPage}">
            <a href="#" onclick="chagePage(${requestScope.pageInfo.nextPage})">下一页</a>
        </c:if>
        <c:choose>
            <c:when test="${pageInfo.hasNextPage}">
              <a href="#" onclick="chagePage(${requestScope.pageInfo.pages})">末页</a>
            </c:when>
            <c:otherwise>
                    <a class="disabled" href="#">末页</a>
            </c:otherwise>
        </c:choose>
<script>

    function chagePage(pageNum) {
        $("#pageNum").val(pageNum);
        $("#searchForm").submit();
    }

    function deleteGame(id) {
        if (confirm("确定要删除吗")) {
            $.ajax({
                url: "/delete.html",
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
