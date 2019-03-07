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
<form action="editCp.html" method="post" id="edit-form">
    <table border="1">
        <input type="hidden" name="id" value="${cp.id}">
        <tr>
            <td> 公司：</td>
            <td><input name="name" value="${cp.name}"/></td>
        </tr>
        <tr>
            <td>密钥：</td>
            <td><input name="secretKey" value="${cp.secretKey}"/></td>
        </tr>
        <tr>
            <td>支付通知密钥：</td>
            <td><input name="noticeKey" value="${cp.noticeKey}"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input name="password" value="${cp.password}"/></td>
        </tr>
        <tr>
            <td> 状态:</td>
            <td>
                <input type="radio" name="status" value="1" ${cp.status eq '1'?'checked':''} class="form_input">有效
                <input type="radio" name="status" value="0" ${cp.status eq '0'?'checked':''} class="form_input">失效
            </td>
        </tr>
        <tr>
            <td>创建日期：</td>
            <td><input name="createdDate" value='<fmt:formatDate value="${cp.createdDate}" pattern="yyyy-MM-dd"/>'></td>
        </tr>
    </table>
</form>
</body>
</html>
