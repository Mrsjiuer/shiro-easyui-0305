<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="tb-role">
    <form class="easyui-form" id="search-role-form">
        名称: <input class="easyui-textbox" name="name" size="30" id="role-name">
        状态：<select name="status" class="easyui-combobox" style="width: 100px" id="role-status">
        <option value="">请选择</option>
        <option value="1">有效</option>
        <option value="0">无效</option>
    </select>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchRole()">查询</a>
    </form>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="editRole()">修改</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="assignMenu()">分配权限</a>
</div>
<table id="role-table">
</table>
<script type="text/javascript">
    $(function () {
        $("#role-table").datagrid({
            toolbar: '#tb-role',
            url: 'role.html?act=table',
            pagination: "true",
            singleSelect: true,
            pageSize: 5,//默认初始化尺寸是10，不管是几，pageSize必须是pageList中的值
            pageList: [5, 10, 15, 20],
            columns: [[
                {field: 'id', title: '编号', width: 100},
                {field: 'name', title: '名称', width: 100},
                {field: 'remark', title: '下载地址', width: 100},
                {
                    field: 'status', title: '状态', width: 100, formatter: function (value, row) {
                    if (value == 1) {
                        return '<span style="color: #00ee00">有效</span>';
                    } else {
                        return '<span style="color: #ee1611">有效</span>';
                    }
                }
                }
            ]]
        })
        //重置分页
//        var pager = $('#game-table').datagrid().datagrid('getPager');
//        pager.pagination({
//            layout:['list','sep','first','links','last']
//        })
    })
    function assignMenu() {
        var row = $("#role-table").datagrid("getSelected");
        if (row == null) {
            return;
        }
        var div = $("<div></div>");
        $(div).dialog({
            title: '分配菜单',
            width: 500,
            height: 400,
            closed: false,
            href: 'role.html?act=go_menu&roleId='+row.id,
            modal: true,
            onClose:function(){
                $(div).dialog("destroy");//dialog在关闭的时候必须销毁
            },
            buttons: [{
                iconCls: "icon-ok",
                text: '保存',
                handler: function () {
                    var nodes = $('#role-menu').tree('getChecked', ['checked','indeterminate']);
                    var menuIds=new Array();
                    $.each(nodes,function(i,obj){
                        menuIds.push(obj.id)
                    })
                    $.ajax({
                        url: 'role.html?act=assign_menu',
                        data: "roleId="+row.id+"&menuIds="+menuIds,
                        method: 'post',
                        success: function (json) {
                            if(json.status){
                                $(div).dialog("destroy")
                            }else{
                                alert(json.message)
                            }
                        }
                    })
                }
            }, {
                text: '取消',
                handler: function () {
                    $(div).dialog("destroy")
                }
            }]
        });
    }
    function searchRole(){
        $("#role-table").datagrid({
            queryParams: {
                name: $("#role-name").textbox("getText"),
                status: $("#role-status").combobox("getValue")
            }
        })
    }
</script>
