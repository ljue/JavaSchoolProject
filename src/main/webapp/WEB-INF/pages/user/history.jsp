<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<title>History</title>--%>
</head>
<body>
<jsp:include page="../../templates/navigation.jsp"/>
<fmt:setLocale value="en_US" scope="session" />
<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <p class="lead"></p>
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/profile/" class="list-group-item">My Profile</a>
                <a href="${pageContext.request.contextPath}/profile/address" class="list-group-item">My Address</a>
                <a href="${pageContext.request.contextPath}/profile/history"
                   class="list-group-item active-list-group-item">My Orders</a>
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
                        <tbody class="cursor-pointer">

                        <c:forEach var="order" items="${ordersHistory}" varStatus="status">
                            <tr data-href="${pageContext.request.contextPath}/profile/orderInHistory/${order.orderId}">
                                <td>${order.orderId}</td>
                                <td>${order.deliveryStatus}</td>
                                <td><fmt:formatDate type="both" dateStyle="long" timeStyle="medium" value="${order.dateTimeOrder}"/></td>
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
