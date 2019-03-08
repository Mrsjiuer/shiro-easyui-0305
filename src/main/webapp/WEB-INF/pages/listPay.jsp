<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="tb">
    <form class="easyui-form">
        名称: <input class="easyui-textbox" name="name" size="30" id="pay-name">
        起始时间： <input class="easyui-textbox" name="start" size="30" id="pay-start">
        结束时间： <input class="easyui-textbox" name="end" size="30" id="pay-end">
        状态：<select name="status" class="easyui-combobox" style="width: 100px" id="pay-status">
        <option value="">请选择</option>
        <option value="1">成功</option>
        <option value="0">失败</option>
    </select>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchPay()">查询</a>
    </form>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addGame()">添加</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="editGame()">修改</a>
</div>
<table id="game-table">
</table>
<script type="text/javascript">
    $(function () {
        $("#game-table").datagrid({
            toolbar: '#tb',
            url: 'tablePay.html',
            pagination: "true",
            singleSelect: true,
            pageSize: 4,//默认初始化尺寸是10，不管是几，pageSize必须是pageList中的值
            pageList: [4, 6, 8, 10],
            columns: [[
                {field: 'id', title: '编号', width: 100},
                {field: 'name', title: '渠道名称', width: 100},
                {field: 'alias', title: '支付方式', width: 100},
                {
                    field: 'status', title: '状态', width: 100, formatter: function (value, row) {
                        if (value == 1) {
                            return '<span style="color: #00ee00">成功</span>';
                        } else {
                            return '<span style="color: #ee1611">失败</span>';
                        }
                    }
                },
                {field: 'createdDate', title: '创建日期', width: 100},
                {field: 'type', title: '类型', width: 100},

            ]]
        })
    })

    function editGame() {
        var row = $("#game-table").datagrid("getSelected");
        if (row == null) {
            return;
        }
        var div = $("<div></div>");
        $(div).dialog({
            title: '编辑游戏',
            width: 500,
            height: 400,
            closed: false,
            href: 'go_updatePay.html?id=' + row.id,
            modal: true,
            onClose:function(){
                $(div).dialog("destroy");//dialog在关闭的时候必须销毁
            },
            buttons: [{
                iconCls: "icon-ok",
                text: '保存',
                handler: function () {
                    $.ajax({
                        url: 'updatePay.html',
                        data: $("#edit-form").serialize(),
                        method: 'post',
                        success: function (json) {
                            if (json == "ok") {
                                $("#game-table").datagrid("reload");
                                $(div).dialog("destroy");
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
    function searchPay(){
        $("#game-table").datagrid({
            queryParams: {
                name:$("#pay-name").textbox("getText"),
                start:$("#pay-start").textbox("getText"),
                end:$("#pay-end").textbox("getText"),
                status:$("#pay-status").combobox("getValue")
            }
        })
        var  st =$("#pay-start").textbox("getText");
        var  en =$("#pay-end").textbox("getText")
        if(st>en){
            $.messager.confirm('Confirm','起始时间不能大于结束时间?')
        }
    }
</script>