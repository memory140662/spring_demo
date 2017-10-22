<%--
  Created by IntelliJ IDEA.
  User: guilinzhu
  Date: 2017/10/21
  Time: 下午12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
</head>
<body>

<table border="1">
    <thead>
        <tr>
            <th width="50px" >
                Id
            </th>
            <th width="150px" >
                Username
            </th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td style="text-align: center">
                ${employee.id}
            </td>
            <td>
                ${employee.username}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
