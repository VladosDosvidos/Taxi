<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 27.01.15
  Time: 19:09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/jquery.js"></script>
</head>
<body>

<div class="all" style="width: 1200px; margin: 0 auto">
    <div class="menu" style="width: 200px">


        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" placeholder="Name">
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="nmbr" class="form-control" id="phone" placeholder="Phone">
        </div>
        <button id="btn" class="btn btn-default">Add</button>


    </div>

    <div class="table-right" style=" height: 400px; width: 400px; ">
        <table class="table" id="table-info">
            <tr>
                <td>Name</td>
                <td>Phone</td>
            </tr>


        </table>
    </div>


</div>

</table>
</body>
</html>
