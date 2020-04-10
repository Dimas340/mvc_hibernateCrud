<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<div align="center">
    <c:url value="/admin/edit/*" var="var"/>
    <form action="${var}" method="POST">
        <input type="hidden" name="id" value="${user.id}">
        <label for="name">Name</label>
        <input type="text" name="name" id="name"><br>
        <label for="password">Password</label>
        <input type="text" name="password" id="password"><br>
        <label for="role">Role</label>
        <input type="text" name="role" id="role"><br>
        <input type="submit" value="Edit user">
    </form>
</div>
</body>

</html>
