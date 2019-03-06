<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/easyui/themes/default/easyui.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/easyui/jquery.easyui.min.js"></script>

</head>
<body>
<div class="easyui-panel" title="登陆" style="width:100%;max-width:400px;padding:30px 60px;">
    <form id="ff" method="post" action="dologin.html">

        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="email" style="width:100%" data-options="label:'邮箱:',required:true,validType:'email'">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-passwordbox" name="password" style="width:100%" data-options="label:'密码:',required:true">
        </div>
    </form>
    <div style="text-align:center;padding:5px 0">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">登陆</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
    </div>
</div>
${message}
<script>
    function submitForm(){
        $('#ff').submit();
    }
    function clearForm(){
        $('#ff').form('clear');
    }
</script>
</body>
</html>
