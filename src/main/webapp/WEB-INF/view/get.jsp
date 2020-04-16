<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get All Users</title>
</head>
<body>
<div align="center">
    <h1>All users</h1>
    <h2><a href="/admin/add">Add New User</a></h2><br>
    <table border="5" cellpadding="10">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Password</th>
            <th>Role</th>
        </tr>
        <c:forEach items="${get}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.password}</td>
                <td><c:forEach items="${user.roles}" var="role">  ${role.role}</c:forEach></td>
                <td>
                        <a href="${pageContext.servletContext.contextPath}/admin/edit?id=${user.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="${pageContext.servletContext.contextPath}/admin/delete/{id}?id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <br>
    <form action="/logout" method="post">
        <input type="submit" value="exit"/>
    </form>
</div>
</body>
</html>
