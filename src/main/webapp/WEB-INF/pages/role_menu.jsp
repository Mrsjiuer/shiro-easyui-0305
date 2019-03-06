<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul id="role-menu">
</ul>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url: "role.html?act=role_menu",
            method: "post",
            data: "roleId=${param.roleId}",
            success: function (json) {
                $("#role-menu").tree({
                    url: "role.html?act=menu_tree",
                    checkbox: true,//复选框
                    onLoadSuccess: function (node, data) {
                        $.each(json, function (i, id) {
                            var tree = $("#role-menu");
                            var n = tree.tree("find", id);
                            if (tree.tree("isLeaf", n.target)) {
                                tree.tree("check", n.target);
                            }
                        })

                    }
                })
            }
        })


    });
</script>