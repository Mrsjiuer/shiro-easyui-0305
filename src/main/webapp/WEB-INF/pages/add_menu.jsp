<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="edit-menu">
    <input type="hidden" name="id" value="${menu.id}" id="menuId">
    菜单名：<input name="text" value="${menu.text}"><br/>
    地址：<input name="url" value="${menu.url}"><br/>
    父菜单： <select id="cc" style="width:200px;"
                 name="parentId">
</select>
</form>
<script type="text/javascript">
    $(function () {
        // $('#cc').combotree('setValue', '${menu.parentId}');
        $("#cc").combotree({
            url: 'menu.html',
            value: '${menu.parentId}',
            onLoadSuccess: function (node, data) {//不显示当前的节点
                if( '${menu.id}'!=''){
                    var tree = $("#cc").combotree("tree");
                    var root = tree.tree("find", '${menu.id}');
                    tree.tree('remove', root.target);
                }

            }

        })
    })


</script>
