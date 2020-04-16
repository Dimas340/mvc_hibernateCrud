<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<div align="center">
    <c:url value="/admin/edit/*" var="edit"/>
    <form action="${edit}" method="POST">
        <input type="hidden" name="id" value="${user.id}">
        <label for="name">Name</label>
        <input type="text" name="name" id="name" value="${user.name}"><br>
        <label for="password">Password</label>
        <input type="text" name="password" id="password" value="${user.password}"><br>
            <label>
                <select name="role">
                    <option value="ROLE_ADMIN">Admin</option>
                    <option value="ROLE_USER">User</option>
                    <option value="ROLE_USER ROLE_ADMIN">Admin_User</option>
                </select>
            </label>
        <input type="submit" value="Edit user">
    </form>
</div>
</body>
</html>
