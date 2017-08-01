<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
    <jsp:include page="../templates/head.jsp"/>
</head>
<body>
<jsp:include page="../templates/navigation.jsp"/>
<jsp:include page="../templates/scripts.jsp"/>

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
            <div class="row">
                <br>
                <c:if test="${!empty orders}">
                    <c:forEach var="order" items="${orders}">

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
                                            <c:set var="orderId" value="${order.orderId}"/>
                                            <a href="/adminOrders/${orderId}">
                                                <button type="button" class="btn btn-danger">Edit</button>
                                            </a>
                                        </td>
                                    </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>



                    </c:forEach>
                </c:if>
            </div>
        </div>
    </div>
</div>


</body>
</html>
