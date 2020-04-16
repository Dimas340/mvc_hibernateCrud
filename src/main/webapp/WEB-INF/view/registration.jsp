
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/registration">
    <label for="name">Name</label>
    <input type="text" name="name" id="name"><br>
    <label for="password">Password</label>
    <input type="text" name="password" id="password"><br>
    <input type="submit"/><br>
    <h4><a href="/login">Login</a></h4>
</form>
</body>
</html>
