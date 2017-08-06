<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>

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
            <p class="lead"></p>
            <div class="list-group">
                <a href="/user" class="list-group-item">My Profile</a>
                <a href="/address" class="list-group-item">My Address</a>
                <a href="/history" class="list-group-item">My Orders</a>
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


                            <tr data-href="/orderInHistory/${order.orderId}">
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
