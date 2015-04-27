<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 09.04.2015
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="js/jquery-2.1.3.min.js"></script>

    <title>Best Taxi in NY</title>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/bootstrap.js"></script>


</head>
<body>


<div class="all">

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
                <a class="navbar-brand" href="#">Best taxi in NY</a>
            </div>

            <!-- Зібрано навігаційні лінки, форми, та інший вміст для переключення -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="#" data-toggle="modal" data-target="#myModal">Registration operator</a></li>
                    <li><a href="#">About us</a></li>


                </ul>
                <form role="form" class="navbar-form navbar-right form-inline" action="/index.html" method="post">
                    <div class="form-group">
                        <label for="login">Login</label>
                        <input type="text" class="form-control" id="login" name="login" placeholder="Login">
                    </div>
                    <div class="form-group">
                        <label for="Password">Password</label>
                        <input type="password" class="form-control" id="Password" name="pass" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-default">Sign in</button>
                </form>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span
                            class="sr-only">Закрити</span></button>
                    <h4 class="modal-title" id="myModalLabel">Registration new operator</h4>
                </div>
                <div class="modal-body">


                    <form role="form" action="/register.html" method="post">
                        <div class="form-group">
                            <label for="loginreg">Login</label>
                            <input type="text" class="form-control" id="loginreg" name="login" placeholder="Login">
                        </div>
                        <div class="form-group">
                            <label for="id">Identification nmbr</label>
                            <input type="text" class="form-control" id="id" name="id" placeholder="ID">
                        </div>
                        <div class="form-group">
                            <label for="pass">Password</label>
                            <input type="password" class="form-control" id="pass" name="pass" placeholder="Password">
                        </div>

                        <div class="form-group">
                            <label for="cpass">Confirm password</label>
                            <input type="password" class="form-control" id="cpass" name="confirmPass"
                                   placeholder="Confirm password">
                        </div>

                        <button type="submit" class="btn btn-default">Registration</button>
                    </form>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <div class="taxi-slider">

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
                    <img src="img/1.jpg">

                </div>
                <div class="item">
                    <img src="img/2.jpg">

                </div>
                <div class="item">
                    <img src="img/3.jpg">

                </div>


            </div>

            <!-- Управління -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <%--<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>--%>
                <span class="sr-only">Попередній</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <%--<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>--%>
                <span class="sr-only">Наступний</span>
            </a>
        </div>

    </div>


</div>

</body>
</html>
