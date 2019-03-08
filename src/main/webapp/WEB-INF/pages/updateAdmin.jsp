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
<form action="/adminuser.html?act=update_admin" method="post" id="edit-form">
    <table border="1">
        <input type="hidden" name="id" value="${adminUser.id}">
        <tr>
            <td> 密码：</td>
            <td><input name="password" value="${adminUser.password}"/></td>
        </tr>
        <tr>
            <td>email：</td>
            <td><input name="email" value="${adminUser.email}"/></td>
        </tr>
        <tr>
            <td>真实姓名：</td>
            <td><input name="realName" value="${adminUser.realName}"/></td>
        </tr>
        <tr>
            <td>管理员：</td>
            <td>
                <input type="radio" name="isAdmin" value="1" ${adminUser.isAdmin eq '1'?'checked':''} class="form_input">是
                <input type="radio" name="isAdmin" value="0" ${adminUser.isAdmin eq '0'?'checked':''} class="form_input">否
            </td>
        </tr>
        <tr>
            <td> 状态:</td>
            <td>
                <input type="radio" name="status" value="1" ${adminUser.status eq '1'?'checked':''} class="form_input">在线
                <input type="radio" name="status" value="0" ${adminUser.status eq '0'?'checked':''} class="form_input">下线
            </td>
        </tr>
        <tr>
            <td>创建日期：</td>
            <td><input name="limitedDate" value='<fmt:formatDate value="${adminUser.limitedDate}" pattern="yyyy-MM-dd"/>'></td>
        </tr>
    </table>
</form>
</body>
</html>
