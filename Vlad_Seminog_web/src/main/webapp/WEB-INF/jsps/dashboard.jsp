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
    <script src="js/jquery-2.1.3.min.js"></script>
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/bootstrap.js"></script>
    <script src="js/dashScript.js"></script>
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
                    <li><a href="#" data-toggle="modal" data-target="#modalClient">New Client</a></li>
                    <li><a href="#" data-toggle="modal" data-target="#modalOrder">New Order</a></li>
                    <li><a href="#" data-toggle="modal" data-target="#modalEditOrder">Edit Order</a></li>
                    <li><a href="#" data-toggle="modal" data-target="#modalNewTaxist">New Taxist</a></li>


                    <li><a href="#">About us</a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Operator login: <c:out value="${employee.employeeLogin}"/> <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="/logoutEmploee">Log out</a></li>
                        </ul>
                    </li>
                </ul>


            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <!-- Modal -->
    <div class="modal fade" id="modalClient" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span
                            class="sr-only">Закрити</span></button>
                    <h4 class="modal-title" id="myModalLabel">Registration new operator</h4>
                </div>


                <div class="modal-body">
                    <form role="form" action="registerClient" method="post">
                        <div class="form-group">
                            <label for="namereg">Name</label>
                            <input type="text" class="form-control" id="namereg" name="name" placeholder="Name">
                        </div>
                        <div class="form-group">
                            <label for="surnamereg">SurName</label>
                            <input type="text" class="form-control" id="surnamereg" name="surname"
                                   placeholder="SurName">
                        </div>
                        <div class="form-group">
                            <label for="phone">Phone</label>
                            <input type="number" class="form-control" id="phone" name="phone" placeholder="Phone">
                        </div>

                        <div class="form-group">
                            <label for="addressreg">Address</label>
                            <input type="text" class="form-control" id="addressreg" name="address"
                                   placeholder="Address">
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

    <!-- Modal -->
    <div class="modal fade" id="modalOrder" tabindex="-1" role="dialog" aria-labelledby="myModalLabelOrder"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span
                            class="sr-only">Закрити</span></button>
                    <h4 class="modal-title" id="myModalLabelOrder">Registration new Order</h4>
                </div>
                <div class="modal-body">


                    <form role="form" action="/registerOrder" method="post">
                        <div class="form-group">
                            <label for="clientNameOrderEdit">Client name</label>
                            <input type="text" class="form-control" id="clientNameOrderEdit" name="clientName"
                                   placeholder="Client name">
                        </div>
                        <div class="form-group">
                            <label for="orderPrice">Price</label>
                            <input type="number" class="form-control" id="orderPrice" name="orderPrice"
                                   placeholder="Price">
                        </div>

                        <div class="form-group">
                            <label for="addressFrom">Address</label>
                            <input type="text" class="form-control" id="addressFrom" name="addressFrom"
                                   placeholder="Address from">
                        </div>

                        <div class="form-group">
                            <label for="addressTo">Address</label>
                            <input type="text" class="form-control" id="addressTo" name="addressTo"
                                   placeholder="Address to">
                        </div>

                        <button type="submit" class="btn btn-default" >Create</button>
                    </form>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" id="clear">Close</button>
                </div>
            </div>
        </div>
    </div>


    <!-- Modal -->
    <div class="modal fade" id="modalEditOrder" tabindex="-1" role="dialog" aria-labelledby="myModalEditLabelOrder"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span
                            class="sr-only">Закрити</span></button>
                    <h4 class="modal-title" id="myModalEditLabelOrder">Edit Order</h4>
                </div>
                <div class="modal-body">


                    <form role="form" action="/editOrder" method="post">
                        <div class="form-group">
                            <label for="orderIdedit">Order id</label>
                            <input type="text" class="form-control" id="orderIdedit" name="orderId"
                                   placeholder="Order id">
                        </div>
                        <div class="form-group">
                            <label for="clientNameedit">Client name</label>
                            <input type="text" class="form-control" id="clientNameedit" name="clientName"
                                   placeholder="Client name">
                        </div>
                        <div class="form-group">
                            <label for="orderPriceedit">Price</label>
                            <input type="nmbr" class="form-control" id="orderPriceedit" name="orderPrice"
                                   placeholder="Price">
                        </div>

                        <div class="form-group">
                            <label for="addressFromedit">Address</label>
                            <input type="text" class="form-control" id="addressFromedit" name="addressFrom"
                                   placeholder="Address from">
                        </div>

                        <div class="form-group">
                            <label for="addressToedit">Address</label>
                            <input type="text" class="form-control" id="addressToedit" name="addressTo"
                                   placeholder="Address to">
                        </div>

                        <button type="submit" class="btn btn-default">Edit</button>
                        <span><c:out value="${message}"/></span>
                    </form>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>


    <div class="modal fade" id="modalNewTaxist" tabindex="-1" role="dialog" aria-labelledby="myModalLabelTaxist"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span
                            class="sr-only">Закрити</span></button>
                    <h4 class="modal-title" id="myModalNewTaxist">Registration new Taxist</h4>
                </div>
                <div class="modal-body">


                    <form role="form" action="/registerTaxist" method="post">
                        <div class="form-group">
                            <label for="taxistName">Name</label>
                            <input type="text" class="form-control" id="taxistName" name="taxistName"
                                   placeholder="Name">
                        </div>
                        <div class="form-group">
                            <label for="taxistSurName">Surname</label>
                            <input type="text" class="form-control" id="taxistSurName" name="taxistSurName"
                                   placeholder="Surname">
                        </div>
                        <div class="form-group">
                            <label for="taxistPhone">Phone</label>
                            <input type="text" class="form-control" id="taxistPhone" name="taxistPhone"
                                   placeholder="Phone">
                        </div>

                        <div class="form-group">
                            <label for="taxistPassword">Password</label>
                            <input type="password" class="form-control" id="taxistPassword" name="taxistPassword"
                                   placeholder="Password">
                        </div>

                        <button type="submit" class="btn btn-default">Create</button>
                        <span><c:out value="${message}"/></span>
                    </form>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>



    <div class="content">

        <div role="tabpanel">

            <!-- Навігаційні елементи вкладок -->
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                          data-toggle="tab">Clients</a></li>
                <li role="presentation"><a href="#profile" aria-controls="profile" role="tab"
                                           data-toggle="tab">Orders</a></li>

                <li role="presentation"><a href="#taxists" aria-controls="profile" role="tab"
                                           data-toggle="tab">Taxists</a></li>

            </ul>

            <!-- Вкладки панелі -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">
                    <div class="menu-left">

                        <div class="panel panel-default">
                            <div class="panel-heading">Client menu</div>
                            <div class="panel-body">
                                <div class="btn-group-vertical btn-block" role="group" aria-label="...">
                                    <a class="btn btn-default"  id="showAllClients" methods="get" role="button">Show all
                                        client</a>
                                    <a class="btn btn-default" href="/lastMonth" methods="get" role="button">Last
                                        month</a>

                                    <form action="/moreThan" method="get">
                                        <button class="btn btn-default">More than</button>
                                        <input type="number" class="form-control" name="sum" placeholder="Sum">
                                    </form>

                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="table-right">
                        <div class="panel panel-default">
                            <div class="panel-heading">Clients table</div>
                            <div class="panel-body">
                                <table class="table table-striped" id="clientsTable">
                                    <tr>
                                        <td>ID</td>
                                        <td>Name</td>
                                        <td>Sur name</td>
                                        <td>Address</td>
                                        <td>Phone</td>
                                        <td>Spent</td>
                                        <td>Last order date</td>
                                        <td></td>
                                    </tr>

                                </table>
                            </div>
                        </div>
                    </div>


                </div>
                <div role="tabpanel" class="tab-pane" id="profile">
                    <div class="menu-left">

                        <div class="panel panel-default">
                            <div class="panel-heading">Orders menu</div>
                            <div class="panel-body">
                                <div class="btn-group-vertical btn-block" role="group" aria-label="...">
                                    <button class="btn btn-default" id="showAll" role="button">Show all orders</button>
                                    <%--<button class="btn btn-default" id="showNewOrders" role="button">Show new orders</button>--%>
                                    <button class="btn btn-default" id="showNewFreeOrders" role="button">Show new free orders</button>
                                    <button class="btn btn-default" id="showNewTakenOrders" role="button">Show new taken orders</button>

                                    <form action="/fromto" method="get">
                                        <button class="btn btn-default">Range</button>
                                        <input type="number" class="form-control" name="from" placeholder="From">
                                        <input type="number" class="form-control" name="to" placeholder="To">
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="table-right">
                        <div class="panel panel-default">
                            <div class="panel-heading">Clients table</div>
                            <div class="panel-body">
                                <table class="table table-striped" id="orderTable">
                                    <tr>
                                        <td>ID</td>
                                        <td>Client name</td>
                                        <td>Sum</td>
                                        <td>Date</td>
                                        <td>Address from</td>
                                        <td>Address to</td>
                                        <td>Taxist name</td>
                                        <td>Taxist phone</td>

                                    </tr>

                                </table>
                            </div>
                        </div>
                    </div>

                </div>

                <div role="tabpanel" class="tab-pane" id="taxists">
                    <div class="menu-left">

                        <div class="panel panel-default">
                            <div class="panel-heading">Orders menu</div>
                            <div class="panel-body">
                                <div class="btn-group-vertical btn-block" role="group" aria-label="...">
                                    <button class="btn btn-default" id="showAllTaxists" role="button">Show all taxists</button>
                                    <button class="btn btn-default" id="showOnlineTaxists" role="button">Show online taxists</button>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="table-right">
                        <div class="panel panel-default">
                            <div class="panel-heading">Clients table</div>
                            <div class="panel-body">
                                <table class="table table-striped" id="taxistsTable">
                                    <tr>
                                        <td>ID</td>
                                        <td>Name</td>
                                        <td>Surname</td>
                                        <td>Phone</td>


                                    </tr>

                                </table>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </div>

    </div>

</div>


</body>
</html>
