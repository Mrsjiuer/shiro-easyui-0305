<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul id="user-role">
</ul>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url: "adminuser.html?act=user_role",
            method: "post",
            data: "userId=${param.userId}",
            success: function (json) {
                $("#user-role").tree({
                    url: "adminuser.html?act=role_tree",
                    checkbox: true,//复选框
                    formatter:function(node){
                        return node.name;
                    },
                    onLoadSuccess: function (node, data) {
                        $.each(json, function (i, id) {
                            var tree = $("#user-role");
                            var n = tree.tree("find", id);
                            tree.tree("check", n.target);
                        })

                    }
                })
            }
        })


    });
</script>
