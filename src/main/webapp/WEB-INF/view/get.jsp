<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get All Users</title>
</head>
<body>
<div align="center">
    <h1>All users</h1>
    <h2><a href="/users/add/addUser">Add New User</a></h2><br>
    <%--<h2>Add</h2>--%>
    <%--<c:url value="/add" var="add"/>--%>
    <%--<a href="${add}">Add new film</a>--%>
    <table border="5" cellpadding="10">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
        </tr>
        <c:forEach items="${get}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>
                    <%--<a href="/edit/${user.id}">Edit</a>--%>
                    <%--&nbsp;&nbsp;&nbsp;&nbsp;--%>
                    <%--<a href="/delete/${user.id}">Delete</a>--%>
                        <a href="${pageContext.servletContext.contextPath}/users/edit?id=${user.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="${pageContext.servletContext.contextPath}/users/delete/{id}?id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
