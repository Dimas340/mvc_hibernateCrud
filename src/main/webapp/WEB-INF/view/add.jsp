<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<div align="center">
    <c:url value="/users/add" var="var"/>
    <form action="${var}" method="POST">
        <label for="name">Name</label>
        <input type="text" name="name" id="name"><br>
        <label for="surname">Surname</label>
        <input type="text" name="surname" id="surname"><br>
        <input type="submit" value="Add user">
    </form>
</div>
</body>

</html>
