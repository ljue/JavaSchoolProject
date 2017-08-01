<%--
  Created by IntelliJ IDEA.
  User: Людмила
  Date: 29.07.2017
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check Order</title>
    <jsp:include page="../templates/head.jsp"/>
</head>
<body>
<jsp:include page="../templates/navigation.jsp"/>
<jsp:include page="../templates/scripts.jsp"/>

<c:url var="editInfo" value="/user/editInfo"/>
<c:url var="editPass" value="/user/editPass"/>
<%--<jsp:include page="/countries" />--%>

<br>
<br>
<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <%--<p class="lead">Личный кабинет</p>--%>
            <p class="lead"></p>
            <div class="list-group">
                <a href="/adminOrders" class="list-group-item">Order list</a>
                <a href="/statistics" class="list-group-item">Shop statistic</a>
                <a href="/adminProducts" class="list-group-item">Goods management</a>
            </div>
        </div>

        <div class="col-md-9">
            <br>
            <div class="panel panel-default">
                <div class="panel-heading text-center"><h4>Order #${order.orderId}</h4></div>
                <div class="panel-body">
                    <table class="table borderless">
                        <thead>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td  class="text-left">User Id:</td>
                            <td class="text-center">${order.userId}</td>
                        </tr>
                        <tr>
                            <td  class="text-left">Delivery status:</td>
                            <td class="text-center">${order.deliveryStatus}</td>
                        </tr>
                        <tr>
                            <td  class="text-left">Time:</td>
                            <td class="text-center">${order.dateTimeOrder}</td>
                        </tr>
                        
                        <tr>
                            <td></td>
                            <td class="text-right">
                                <button type="button" class="btn btn-danger">Edit</button>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </div>
            </div>

        </div>

    </div>
</div>

</body>
</html>
