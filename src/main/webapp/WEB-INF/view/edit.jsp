<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <select name="role" size="2" multiple="multiple">
                <c:forEach var="roles" items="${roles}">
                    <option><c:if test="${roles.role}">selected</c:if>${roles.role}</option>
                </c:forEach>
            </select>
        </label>
        <input type="submit" value="Edit user">
    </form>
</div>
</body>
</html>
