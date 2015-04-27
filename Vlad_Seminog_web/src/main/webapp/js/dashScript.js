/**
 * Created by Vlad on 14.04.2015.
 */
$(document).ready(init);

function init() {
    $('#showAll').bind('click', show);
    $('#showAllTaxists').bind('click', showAllTaxist);
    $('#showOnlineTaxists').bind('click', showOnlineTaxists);
    $('#showAllClients').bind('click', showAllClients);
    $('#showNewOrders').bind('click', showNewOrders);
    $('#showNewFreeOrders').bind('click', showNewFreeOrders);
    $('#showNewTakenOrders').bind('click', showNewTakenOrders);

}


function showNewOrders() {
    $.ajax({
        dataType: 'json',
        type: 'GET',
        url: '/showneworders',
        success: function (data) {
            var orders = data;
            $("#orderTable").find("tr:gt(0)").remove();
            orders.forEach(function (elem) {
                $('#orderTable').append("+<tr id=" + 'data' + "><td>" + elem.orderId + "</td><td>" + elem.client.clientName +
                "</td><td>" + elem.orderSum + "</td><td>" + new Date(elem.orderDate).toDateString() + "</td><td>"
                + elem.addressFrom + "</td><td>" + elem.addressTo + "</td></tr>");
            });
        },
        error: function (a, b, c) {
            console.log(a + " " + b + " " + c);
        }
    });
}


//function showAllClients(){
//    $.ajax({
//        dataType: 'json',
//        type: 'GET',
//        url: '/showAllClients',
//        success: function(data) {
//            var allClients = data;
//            $('#clientsTable').find("tr:gt(0)").remove();
//            allClients.forEach(function(elem){
//                $('#clientsTable').append("<tr><td>" + elem.clientID + "</td><td>" + elem.clientName + "</td><td>"
//                + elem.clientSurname + "</td><td>" + elem.clientAddress + "</td><td>"+ elem.clientPhone + "</td><td>"
//                + elem.spent + "</td><td>" + elem.clientOrderDate + "</td><td>");
//            });
//        },
//
//        error: function (a, b, c) {
//            console.log(a + " " + b + " " + c);
//        }
//
//    });
//
//}

function showAllClients() {
    $.ajax({
        dataType: 'json',
        type: 'GET',
        url: '/showAllClients',
        success: function (data) {
            var allClients = data;
            $('#clientsTable').find("tr:gt(0)").remove();
            allClients.forEach(function (elem) {
                $('#clientsTable').append("<tr><td>" + elem.clientID + "</td><td id='name'>" + elem.clientName + "</td><td>"
                + elem.clientSurname + "</td><td>" + elem.clientAddress + "</td><td>" + elem.clientPhone + "</td><td>"
                + elem.spent + "</td><td>" + new Date(elem.clientOrderDate).toDateString() + "</td><td><button type='button' id='btnAddNewOrder'  class='btn btn-default'  value='" + elem.clientName + "' >Add new order</button></td><td>");
            });
            $("button[id='btnAddNewOrder']").bind('click', function () {
                var clientName = this.value;
                $('#modalOrder').modal('show');
                var form = $('#clientNameOrderEdit');
                form.val(clientName);
                form.attr('readonly', true);
            });

        },

        error: function (a, b, c) {
            console.log(a + " " + b + " " + c);
        }

    });

}

function showOnlineTaxists() {
    $.ajax({
        dataType: 'json',
        type: 'GET',
        url: '/showOnlineTaxists',
        success: function (data) {
            var taxistsOnline = data;
            $('#taxistsTable').find("tr:gt(0)").remove();
            taxistsOnline.forEach(function (elem) {
                $('#taxistsTable').append("<tr><td>" + elem.id + "</td><td>" + elem.firstName + "</td><td>"
                + elem.secondName + "</td><td>" + elem.phone + "</td><td>");
            });
        },

        error: function (a, b, c) {
            console.log(a + " " + b + " " + c);
        }

    });
}

function showAllTaxist() {

    $.ajax({
        dataType: 'json',
        type: 'GET',
        url: '/showAllTaxists',
        success: function (data) {
            var taxists = data;
            $('#taxistsTable').find("tr:gt(0)").remove();
            taxists.forEach(function (elem) {
                $('#taxistsTable').append("<tr><td>" + elem.id + "</td><td>" + elem.firstName + "</td><td>"
                + elem.secondName + "</td><td>" + elem.phone + "</td><td>");
            });
        },

        error: function (a, b, c) {
            console.log(a + " " + b + " " + c);
        }

    });
}

function show() {
    $.ajax({
        dataType: 'json',
        type: 'GET',
        url: '/showallorders',
        success: function (data) {
            var orders = data;
            $("#orderTable").find("tr:gt(0)").remove();
            orders.forEach(function (elem) {
                $('#orderTable').append("+<tr id=" + 'data' + "><td>" + elem.orderId + "</td><td>" + elem.client.clientName +
                "</td><td>" + elem.orderSum + "</td><td>" + new Date(elem.orderDate).toDateString() + "</td><td>"
                + elem.addressFrom + "</td><td>" + elem.addressTo + "</td></tr>");
            });
        },
        error: function (a, b, c) {
            console.log(a + " " + b + " " + c);
        }
    });


}

function showNewFreeOrders() {
    $.ajax({
        dataType: 'json',
        type: 'GET',
        url: 'shownewfreeorders',
        success: function (data) {
            var orders = data;
            $("#orderTable").find("tr:gt(0)").remove();
            orders.forEach(function (elem) {
                $('#orderTable').append("+<tr id=" + 'data' + "><td>" + elem.orderId + "</td><td>" + elem.client.clientName +
                "</td><td>" + elem.orderSum + "</td><td>" + new Date(elem.orderDate).toDateString() + "</td><td>"
                + elem.addressFrom + "</td><td>" + elem.addressTo + "</td></tr>");
            });
        },
        error: function (a, b, c) {
            console.log(a + " " + b + " " + c);
        }
    });


}

function showNewTakenOrders() {
    $.ajax({
        dataType: 'json',
        type: 'GET',
        url: '/shownewtakenorders',
        success: function (data) {
            var orders = data;
            $("#orderTable").find("tr:gt(0)").remove();
            orders.forEach(function (elem) {
                $('#orderTable').append("+<tr id=" + 'data' + "><td>" + elem.orderId + "</td><td>" + elem.client.clientName +
                "</td><td>" + elem.orderSum + "</td><td>" + new Date(elem.orderDate).toDateString() + "</td><td>"
                + elem.addressFrom + "</td><td>" + elem.addressTo + "</td><td>" + elem.taxist.firstName + "</td><td>"
                + elem.taxist.phone + "</td></tr>");
            });
        },
        error: function (a, b, c) {
            console.log(a + " " + b + " " + c);
        }
    });
}

