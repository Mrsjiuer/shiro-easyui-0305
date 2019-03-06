<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="edit-menu">
    <input type="hidden" name="id" value="${menu.id}" id="menuId">
    <input name="text" value="${menu.text}" style="width:200px;" class="easyui-textbox" data-options="label:'菜单名:',required:true"><br/>
    <input name="url" value="${menu.url}" style="width:200px;" class="easyui-textbox" data-options="label:'地址:'"><br/>
     <select id="cc" style="width:200px;"
                 name="parentId" data-options="label:'父菜单:'">
</select>
</form>
<script type="text/javascript">
    $(function () {
        $("#cc").combotree({
            url: 'menu.html?act=tree',
            value: '${menu.parentId}',
            onLoadSuccess: function (node, data) {//不显示当前的节点
                var tree = $("#cc").combotree("tree");
                if( '${menu.id}'!=''){
                    var root = tree.tree("find", '${menu.id}');
                    tree.tree('remove', root.target);
                }
                tree.tree('insert', {
                    before:tree.tree("getRoot").target,
                    data: [{
                        id: '',
                        text: '根节点'
                    }]
                });
            }

        })
    })


</script>
