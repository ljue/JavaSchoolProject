<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<title>Orders</title>--%>
</head>
<body>
<jsp:include page="../../templates/navigation.jsp"/>
<fmt:setLocale value="en_US" scope="session" />
<br>
<br>
<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <p class="lead"></p>
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/adminOrders" class="list-group-item active-list-group-item">Order list</a>
                <a href="${pageContext.request.contextPath}/statistics" class="list-group-item">Shop statistic</a>
                <a href="${pageContext.request.contextPath}/adminProducts" class="list-group-item">Goods management</a>
                <a href="${pageContext.request.contextPath}/editCategories" class="list-group-item">Catalog management</a>

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
                                <table class="table borderless" style="margin-left: 60px">
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
                                        <td class="text-center">
                                        <fmt:formatDate type="both" dateStyle="long" timeStyle="medium" value="${order.dateTimeOrder}"/>

                                        </td>
                                    </tr>
                                    <%--<tr>--%>
                                        <%--<td></td>--%>
                                        <%--<td class="text-right">--%>
                                            <%--&lt;%&ndash;<c:set var="orderId" value="${order.orderId}"/>&ndash;%&gt;--%>
                                            <%----%>
                                        <%--</td>--%>
                                    <%--</tr>--%>

                                    </tbody>
                                </table>
                                <a href="${pageContext.request.contextPath}/adminOrders/${order.orderId}"
                                   class="btn btn-primary right" style="margin-right:60px;">Edit</a>
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
