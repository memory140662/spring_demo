<%--
  Created by IntelliJ IDEA.
  User: guilinzhu
  Date: 2017/10/21
  Time: 下午12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<form action="/employee/registered" method="post">
    <table>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"/></td>
        </tr>
    </table>
    <button type="submit">Sign Up</button>
</form>

</body>
</html>
