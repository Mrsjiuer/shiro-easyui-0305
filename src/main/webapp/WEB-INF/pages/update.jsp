<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<form action="edit.html" method="post">
    <table border="1">
        <input type="hidden" name="id" value="${game.id}">
        <tr>
            <td> 姓名：</td>
            <td><input name="name" value="${game.name}"/></td>
        </tr>
        <tr>
            <td> 状态:</td>
            <td>
                <input type="radio" name="status" value="1" ${game.status eq '1'?'checked':''} class="form_input">开服
                <input type="radio" name="status" value="0" ${game.status eq '0'?'checked':''} class="form_input">停服
            </td>
        </tr>
        <tr>
            <td>下载地址：</td>
            <td><input name="downloadUrl" value="${game.downloadUrl}"/></td>
        </tr>
        <tr>
            <td>日期：</td>
            <td><input name="createdDate" value='<fmt:formatDate value="${game.createdDate}" pattern="yyyy-MM-dd"/>'></td>
        </tr>
        <tr>
            <td>
            <input type="submit" value="更新"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
