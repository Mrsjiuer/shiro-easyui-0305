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
<form action="updatePay.html" method="post" id="edit-form">
    <table border="1">
        <input type="hidden" name="id" value="${payChannel.id}">
        <tr>
            <td> 渠道名称：</td>
            <td><input name="name" value="${payChannel.name}"/></td>
        </tr>
        <tr>
            <td>支付方式：</td>
            <td><input name="alias" value="${payChannel.alias}"/></td>
        </tr>
        <tr>
            <td> 状态:</td>
            <td>
                <input type="radio" name="status" value="1" ${payChannel.status eq '1'?'checked':''} class="form_input">成功
                <input type="radio" name="status" value="0" ${payChannel.status eq '0'?'checked':''} class="form_input">失败
            </td>
        </tr>
        <tr>
            <td>创建日期：</td>
            <td><input name="createdDate" value='<fmt:formatDate value="${payChannel.createdDate}" pattern="yyyy-MM-dd"/>'></td>
        </tr>
        <tr>
            <td>类型：</td>
            <td><input name="type" value="${payChannel.type}"/>'></td>
        </tr>
    </table>
</form>
</body>
</html>
