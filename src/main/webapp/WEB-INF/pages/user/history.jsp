<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>

</head>
<body>
<jsp:include page="../../templates/navigation.jsp"/>

<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <p class="lead"></p>
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/user" class="list-group-item">My Profile</a>
                <a href="${pageContext.request.contextPath}/address" class="list-group-item">My Address</a>
                <a href="${pageContext.request.contextPath}/history" class="list-group-item">My Orders</a>
            </div>
        </div>

        <div class="col-md-9">
            <div class="row"><br>

                <c:if test="${empty ordersHistory}">
                    <h4>You haven`t got orders.</h4>
                </c:if>
                <c:if test="${!empty ordersHistory}">


                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>#Order Id</th>
                            <th>Delivery Status</th>
                            <th>Time</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach var="order" items="${ordersHistory}">
                            <tr data-href="${pageContext.request.contextPath}/orderInHistory/${order.orderId}">
                                <td>${order.orderId}</td>
                                <td>${order.deliveryStatus}</td>
                                <td>${order.dateTimeOrder}</td>
                            </tr>
                            <script>
                                jQuery( function($) {
                                    $('tbody tr[data-href]').addClass('clickable').click( function() {
                                        window.location = $(this).attr('data-href');
                                    });
                                });
                            </script>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>
    </div>
</div>

</body>
</html>