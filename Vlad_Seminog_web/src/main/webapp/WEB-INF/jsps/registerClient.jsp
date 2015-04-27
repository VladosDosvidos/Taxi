<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 06.04.2015
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register new client</title>
</head>
<body>

<form action="registerClient.html" method="post">
    <input type="text" name="name">
    <input type="text" name="surname">
    <input type="text" name="phone">
    <input type="text" name="address">
    <input type="submit">

</form>

<p><c:out value="${message}"/></p>

</body>
</html>
