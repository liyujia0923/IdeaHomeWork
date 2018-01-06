<%--
  Created by IntelliJ IDEA.
  User: 佳
  Date: 2017/12/26
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/jquery-easyui-1.5.1/themes/default/easyui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/jquery-easyui-1.5.1/themes/icon.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/statics/jquery-easyui-1.5.1/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/statics/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/statics/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
    <div class="easyui-window"
         style="width: 500px;height: 300px;padding: 60px 110px" title="登录">
        <form action="${pageContext.request.contextPath}/user/login" method="post">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input class="easyui-textbox" name="userName"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input class="easyui-passwordbox" name="password"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="登录">
                        <input type="reset" value="重置">
                    </td>

                </tr>
            </table>
        </form>
    </div>

</body>
</html>
