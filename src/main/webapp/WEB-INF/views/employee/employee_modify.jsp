<%--
  Created by IntelliJ IDEA.
  User: guilinzhu
  Date: 2017/10/21
  Time: 下午12:43
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
                <th width="150px" >
                    Username
                </th>
                <th width="150px">
                    Password
                </th>
                <th width="50px"></th>
                <th width="50px"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <form action="<%= application.getContextPath() %>/employee/update" method="post">
                        <input type="hidden" name="id" value="${employee.id}">
                        <input type="hidden" name="username" value="${employee.username}">
                        <td>${employee.username}</td>
                        <td><input type="password" name="password" value="${employee.password}"></td>
                        <td><button type="submit">Update</button></td>
                        <td><a href="<%= application.getContextPath() %>/employee/delete?id=${employee.id}">Delete</a></td>
                    </form>
                </tr>

            </c:forEach>
        </tbody>
    </table>
</body>
</html>
