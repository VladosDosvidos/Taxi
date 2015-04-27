<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 02.04.2015
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <%--<link rel="stylesheet" href="css/bootstrap-theme.css"/>--%>
    <script src="js/bootstrap.js"/>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"/>--%>
    <title>Authentication page</title>


</head>
<body>

<%--<script>--%>
<%--var  ajax = new XMLHttpRequest();--%>
<%--ajax.onreadystatechange = function(){--%>
<%--if(ajax.readyState == 4 && status == 200){--%>
<%--document.getElementById('send').innerHTML--%>
<%--}--%>
<%--}--%>

<%--ajax.open('GET','/ajax','true');--%>
<%--ajax.send();--%>
<%--<!----%>
<%--інфа сервера--%>
<%--1xx - інформація--%>
<%--2хх - успішно--%>
<%--3хх - перенаправлення--%>
<%--4хх - помилки--%>
<%--5ХХ - помилка сервера--%>
<%---->--%>

<%--</script>--%>

<%--<script>--%>


<%--function chek() {--%>
<%--var loginError = document.getElementById('loginError');--%>
<%--var passError = document.getElementById('passError');--%>
<%--var login = document.getElementById('login').value;--%>
<%--var password = document.getElementById('pass').value;--%>
<%--if (login == password) {--%>
<%--loginError.innerHTML = 'Ти не правий, мій юний падаван'--%>
<%--return false;--%>
<%--} else if (login === '') {--%>
<%--loginError.innerHTML = 'Ти не правий, мій юний падаван'--%>
<%--return false;--%>
<%--} else if (/\d/.test(login)) {--%>
<%--loginError.innerHTML = 'Ти не правий, мій юний падаван, не має бути цифер в логіні твоєму'--%>
<%--return false;--%>
<%--} else if (password.length < 8) {--%>
<%--passError.innerHTML = 'Складний занадто пароль твій'--%>
<%--return false;--%>
<%--} else {--%>
<%--var temp = password.charAt(0);--%>
<%--for (i = 0; i < password.length; i++) {--%>
<%--if (password.charAt(i) !== temp) {--%>
<%--passError.innerHTML = 'Складний занадто пароль твій'--%>
<%--return false;--%>
<%--}--%>
<%--}--%>
<%--return true;--%>
<%--}--%>
<%--}--%>


<%--</script>--%>
<%--<form onsubmit="return chek()">--%>
<%--<label style="margin: 10px">Введите свой логин--%>
<%--<input id="login" type="text" name="login">--%>
<%--</label> <span style="color: red" id="loginError"></span>--%>
<%--<br>--%>

<%--<label style="margin: 10px">Введите свой пароль--%>
<%--<input id="pass" type="password" name="pass">--%>
<%--</label> <span style="color: red" id="passError"></span>--%>
<%--<br>--%>

<%--<input type="submit" value="Sing in">--%>
<%--</form>--%>


<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Бренд та перемикач згруповані для кращого відображення на мобільних пристроях -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">BestTaxi</a>
        </div>

        <!-- Зібрано навігаційні лінки, форми, та інший вміст для переключення -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">Order</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Спадне
                        меню <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Дія</a></li>
                        <li><a href="#">Інша дія</a></li>
                        <li><a href="#">Тут ще щось</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Відокремлений лінк</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Ще один відокремлений лінк</a></li>
                    </ul>
                </li>
            </ul>
            <%--<form class="navbar-form navbar-left" role="search">--%>
            <form class="form-inline navbar-form navbar-left" action="/index.html" method="post">
                <div class="form-group">
                    <label for="exampleInputName2">Login</label>
                    <input type="text" class="form-control" id="exampleInputName2" name="login" placeholder="You login">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail2">Password</label>
                    <input type="password" class="form-control" id="exampleInputEmail2" name="pass"
                           placeholder="Password">
                </div>
                <button type="submit" class="btn btn-default">Sing in</button>
            </form>
            <%--</form>--%>
            <%--<p><c:out value="${message}"/></p>--%>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/register.html">Registration</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Спадне
                        меню <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Дія</a></li>
                        <li><a href="#">Інша дія</a></li>
                        <li><a href="#">Тут ще щось</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Відокремлений лінк</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<div class="slider">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Обгортка для слайдів -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="img/taxi1.jpg" alt="">
            </div>
            <div class="item">
                <img src="img/taxi2.jpg" alt="">
            </div>
            <div class="item">
                <img src="img/taxi3.jpg" alt="">
            </div>

        </div>

        <!-- Управління -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Попередній</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Наступний</span>
        </a>
    </div>


</div>


</body>
</html>
