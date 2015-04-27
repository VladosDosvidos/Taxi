<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 05.04.2015
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="/register.html" method="post">
    <input type="text" name="login">
    <input type="text" name="id">
    <input type="password" name="pass">
    <input type="password" name="confirmPass">
    <input type="submit">

</form>

<p><c:out value="${loginError}"/></p>

<p><c:out value="${idError}"/></p>

<p><c:out value="${idError}"/></p>

<p><c:out value="${passError}"/></p>

<p><c:out value="${passConfirmError}"/></p>

<p><c:out value="${message}"/></p>

</body>
</html>
