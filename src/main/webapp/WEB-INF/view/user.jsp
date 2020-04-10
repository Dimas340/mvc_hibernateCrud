<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Information User</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Password</th>
            <th>Role</th>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td><c:forEach items="${user.roles}" var="role">${role.role}</c:forEach></td>
        </tr>
        </tr>
    </table>
    <br>
    <br>
    <form action="/logout" method="post">
        <input type="submit" value="exit"/>
    </form>
</div>
</body>
</html>
