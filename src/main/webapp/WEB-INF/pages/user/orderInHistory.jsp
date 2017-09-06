<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order in history</title>

    <jsp:include page="../../templates/head.jsp"/>
</head>
<body>
<jsp:include page="../../templates/navigation.jsp"/>
<jsp:include page="../../templates/scripts.jsp"/>


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

            <div class="row">
                <h3>#Order Id: <span id="order-id-in-order-in-history">${orderIn.orderId}</span></h3><br>
                <%--<h4>Delivery status: ${orderIn.deliveryStatus}</h4>--%>
                <%--<h4>Pay way: ${orderIn.payWay}</h4>--%>
                <%--<h4>Delivery way: ${orderIn.deliveryWay}</h4>--%>

                <%--<h4>Address: ${addressOrder.country}, ${addressOrder.region}, ${addressOrder.city},--%>
                <%--${addressOrder.streetAddress}, post code ${addressOrder.postIndex}</h4>--%>

                <div class="form-group">
                    <label class="col-md-3">Delivery status:</label>
                    <label class="col-md-3">${orderIn.deliveryStatus}</label>
                </div>
                <br>
                <div class="form-group">
                    <label class="col-md-3">Pay way:</label>
                    <label class="col-md-3">${orderIn.payWay}</label>
                </div>
                <br>
                <div class="form-group">
                    <label class="col-md-3">Delivery way:</label>
                    <label class="col-md-3">${orderIn.deliveryWay}</label>
                </div>
                <br>
                <div class="form-group">
                    <label class="col-md-3">Address:</label>
                    <label class="col-md-8">${addressOrder.country}, ${addressOrder.region}, ${addressOrder.city},
                        ${addressOrder.streetAddress}, post code ${addressOrder.postIndex}</h4>
                    </label>
                </div>
                <br><br><br>
                <br>

                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>#Id</th>
                        <th>Name</th>
                        <th>Count</th>
                        <th>Cost</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="product">
                        <c:forEach items="${buckets}" var="bucket" varStatus="status">
                            <c:if test="${product.productId eq bucket.productId}">
                                <tr data-toggle="modal" href="#productInOrder${product.productId}">
                                    <td>${bucket.productId}</td>
                                    <td>${product.productName}</td>
                                    <td>${bucket.countProduct}</td>
                                    <td>$${product.cost * bucket.countProduct}</td>
                                </tr>


                            </c:if>

                            <div class="modal fade product_view" id="productInOrder${product.productId}">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">

                                            <h3 class="modal-title">${product.productName}</h3>
                                        </div>
                                        <div class="modal-body">
                                            <div class="row">
                                                <div class="col-md-6 product_img">
                                                    <img src="../resources/Images/${product.presentPic}"
                                                         class="img-responsive">
                                                </div>
                                                <div class="col-md-6 product_content">
                                                    <h4>Product Id: <span>${product.productId}</span></h4>

                                                    <h5>Name: <span>${product.productName}</span></h5>
                                                    <h5>Category: <span>${product.category}</span></h5>
                                                    <h5>Battery: <span>${product.battery}</span></h5>
                                                    <h5>Fly time: <span>${product.flyTime} min</span></h5>
                                                    <h5>Distance: <span>${product.distance} m</span></h5>
                                                    <c:forEach items="${product.properties}" var="propertyGroup">
                                                        <h5>${propertyGroup.key}: <span>
                                                        <c:forEach items="${propertyGroup.value}" var="property" varStatus="status">
                                                            <c:if test="${status.index eq 0}">${property}</c:if>
                                                            <c:if test="${status.index gt 0}">, ${property}</c:if>
                                                        </c:forEach>
                                                    </span></h5>
                                                    </c:forEach>

                                                    <h3 class="cost"></span> $${product.cost}</h3>

                                                    <div class="space-ten"></div>
                                                    <div class="btn-ground">
                                                        <a href="${pageContext.request.contextPath}/catalog/product/${product.productId}"
                                                           class="btn btn-default" style="margin-top: 5px">
                                                            View details
                                                        </a>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>Total:</td>
                        <td>$${total}</td>
                    </tr>
                    </tbody>
                </table>

                <a class="btn btn-primary right"
                onclick="repeatOrder(this)">
                    Repeat order
                </a>

            </div>
        </div>
    </div>
</div>
<script>
    function repeatOrder(obj) {
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/orderInHistory/repeatOrder/" + $("#order-id-in-order-in-history").text(),
            success: function () {
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/getCountInCart",
                    success: function (resp) {
                        $("#navbar-count-in-cart").text(resp);
                    }
                })
            }
        });
        location.href = "/bucket";
    };
</script>

</body>
</html>
