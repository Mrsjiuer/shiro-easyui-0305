<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/easyui/themes/icon.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/easyui/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout">
<%--easyui中，给元素加class，就会把元素变成一个控件，easyui-控件名--%>
<%--所有控件属性，写在data-options中，大多属性可以直接写成标签的属性--%>
<div data-options="region:'north'" style="height:100px;">
    <a href="logout.html">退出</a>
</div>
<div data-options="region:'west'" title="菜单" style="width:200px;">
    <ul id="ul-tree">
    </ul>
</div>
<div data-options="region:'center',title:'首页'">
    <%--静态初始化，直接加class--%>
    <div class="easyui-tabs" id="main-tabs">
    </div>
</div>
<script type="text/javascript">
    $(function () {
        //动态初始化，选中之后，直接调用方法，方法名就是控件名
        $("#ul-tree").tree({
            url:"side.html",
            onClick: function (node) {//被点击的树节点
                if ($('#main-tabs').tabs('exists', node.text)) {//如果面板已经存在，就不追加
                    $('#main-tabs').tabs('select', node.text)
                } else {
                    $('#main-tabs').tabs('add', {
                        title: node.text,
                        closable: true,
                        href:node.attributes.url
                    });
                }
            }
        })
    })
</script>
</body>
</html>
