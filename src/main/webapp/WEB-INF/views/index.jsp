<%@ page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" content="text/html">
</head>
<body onload="goPage('<%= application.getContextPath() %>/employee/list');">
    <table>
        <tr>
            <td><a href="#" onclick="goPage('<%= application.getContextPath() %>/employee/list')">首頁</a></td>
            <td><a href="#" onclick="goPage('<%= application.getContextPath() %>/employee/toRegistered')">註冊</a></td>
            <td><a href="#" onclick="goPage('<%= application.getContextPath() %>/employee/toModify')">管理</a></td>
        </tr>
    </table>
    <iframe id="content" style="border-width: 0; width: 100%;">

    </iframe>
    <script type="text/javascript" src="<%= application.getContextPath() %>/resources/controller.js" ></script>
</body>
</html>
