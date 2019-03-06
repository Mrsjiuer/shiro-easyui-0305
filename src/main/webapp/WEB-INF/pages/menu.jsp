<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="editMenu('')">添加</a>
<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="deleteMenu()">删除</a>

<ul id="menu-tree">
</ul>
<script type="text/javascript">
    $(function () {
        //动态初始化，选中之后，直接调用方法，方法名就是控件名
        $("#menu-tree").tree({
            url:"menu.html?act=tree",
            checkbox:true,//复选框
            cascadeCheck:false,//不级联选中
            onClick: function(node){
                editMenu(node.id)
            }
        })
    });
    function deleteMenu(){
        $.messager.confirm('Confirm','确定要删除吗?',function(r){
            if (r){
                var nodes = $('#menu-tree').tree('getChecked');
                var ids=new Array();
                $.each(nodes,function(i,obj){
                    ids.push(obj.id);
                })
                $.ajax({
                    url:"menu.html?act=delete",
                    data:"ids="+ids,
                    method:'post',
                    success:function( json){
                        if (json.status) {
                            $('#menu-tree').tree("reload")
                        }
                    }
                })
            }
        });
    }
    function editMenu(id){
        var div = $("<div></div>");
        $(div).dialog({
            title: '编辑菜单',
            width: 500,
            height: 400,
            closed: false,
            href: 'menu.html?act=go_edit&id='+id ,
            modal: true,
            onClose:function(){
                $(div).dialog("destroy");//dialog在关闭的时候必须销毁
            },
            buttons: [{
                iconCls: "icon-ok",
                text: '保存',
                handler: function () {
                    $.ajax({
                        url: 'menu.html?act=edit',
                        data: $("#edit-menu").serialize(),
                        method: 'post',
                        success: function (json) {
                            if (json.status) {
                                $('#menu-tree').tree("reload")
                                $(div).dialog("destroy");
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
</script>