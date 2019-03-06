<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="tb-adminuser">
    <form class="easyui-form">
        真实姓名: <input class="easyui-textbox" name="realName" size="30" id="adminuser-realName">
        状态：<select name="status" class="easyui-combobox" style="width: 100px" id="adminuser-status">
        <option value="">请选择</option>
        <option value="1">有效</option>
        <option value="0">无效</option>
    </select>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchAdminUser()">查询</a>
    </form>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="editAdminUser()">修改</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="assignRole()">分配角色</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="deleteUser()">删除</a>
</div>
<table id="adminuser-table">
</table>
<script type="text/javascript">
    $(function () {
        $("#adminuser-table").datagrid({
            toolbar: '#tb-adminuser',
            url: 'adminuser.html?act=table',
            pagination: "true",
            singleSelect: true,
            pageSize: 5,//默认初始化尺寸是10，不管是几，pageSize必须是pageList中的值
            pageList: [5, 10, 15, 20],
            columns: [[
                {field: 'id', title: '编号', width: 100},
                {field: 'email', title: '邮箱', width: 100},
                {field: 'realName', title: '真实姓名', width: 100},
                {
                    field: 'status', title: '状态', width: 100, formatter: function (value, row) {
                    if (value == 1) {
                        return '<span style="color: #00ee00">有效</span>';
                    } else {
                        return '<span style="color: #ee1611">有效</span>';
                    }
                }
                },
                { field:'ck',checkbox:true},

            ]],
            checkOnSelect:false,
            selectOnCheck:false
        })
        //重置分页
//        var pager = $('#game-table').datagrid().datagrid('getPager');
//        pager.pagination({
//            layout:['list','sep','first','links','last']
//        })
    })
    function assignRole() {
        var row = $("#adminuser-table").datagrid("getSelected");
        if (row == null) {
            return;
        }
        var div = $("<div></div>");
        $(div).dialog({
            title: '分配角色',
            width: 500,
            height: 400,
            closed: false,
            href: 'adminuser.html?act=go_role&userId='+row.id,
            modal: true,
            onClose:function(){
                $(div).dialog("destroy");//dialog在关闭的时候必须销毁
            },
            buttons: [{
                iconCls: "icon-ok",
                text: '保存',
                handler: function () {
                    var nodes = $('#user-role').tree('getChecked', ['checked','indeterminate']);
                    var roleIds=new Array();
                    $.each(nodes,function(i,obj){
                        roleIds.push(obj.id)
                    })
                    $.ajax({
                        url: 'adminuser.html?act=assign_role',
                        data: "userId="+row.id+"&roleIds="+roleIds,
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
//    function searchAdminUser(){
//        $("#role-table").datagrid({
//            queryParams: {
//                name: $("#role-name").textbox("getText"),
//                status: $("#role-status").combobox("getValue")
//            }
//        })
//    }
    function deleteUser() {
        var rows = $("#adminuser-table").datagrid("getChecked");
        var ids=new Array();
        $.each(rows,function(i,r){
            ids.push(r.id);
        })
        alert(ids)
    }
</script>
