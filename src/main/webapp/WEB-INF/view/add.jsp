<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<div align="center">
    <c:url value="/admin/add" var="add"/>
    <form action="${add}" method="POST">
        <label for="name">Name</label>
        <input type="text" name="name" id="name"><br>
        <label for="password">Password</label>
        <input type="text" name="password" id="password"><br>
        <label>
            <select name="role" size="2" multiple="multiple">
                <c:forEach var="roles" items="${roles}">
                    <option><c:if test="${roles.role}">selected</c:if>${roles.role}</option>
                </c:forEach>
            </select>
        </label>
        <input type="submit" value="Add user">
    </form>
</div>
</body>

</html>
<%--<label>--%>
<%--<select name="role">--%>
<%--<option value="ROLE_ADMIN">Admin</option>--%>
<%--<option value="ROLE_USER">User</option>--%>
<%--<option value="ROLE_USER ROLE_ADMIN">Admin_User</option>--%>
<%--</select>--%>
<%--</label>--%>