<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<title>Check Order</title>--%>
</head>
<body>
<jsp:include page="../../templates/navigation.jsp"/>

<%--<c:url var="editInfo" value="/my-webapp/user/editInfo"/>--%>
<%--<c:url var="editPass" value="/my-webapp/user/editPass"/>--%>
<%--<jsp:include page="/countries" />--%>

<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <p class="lead"></p>
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/management/adminOrders" class="list-group-item active-list-group-item">Order list</a>
                <a href="${pageContext.request.contextPath}/management/statistics" class="list-group-item">Shop statistic</a>
                <a href="${pageContext.request.contextPath}/management/adminProducts" class="list-group-item">Goods management</a>
                <a href="${pageContext.request.contextPath}/management/editCategories" class="list-group-item">Catalog management</a>

            </div>
        </div>

        <div class="col-md-9">
            <br>
            <div class="panel panel-default">
                <div class="panel-heading text-center"><h4>Order #${orderIn.orderId}</h4></div>
                <div class="panel-body">
                    <%--<table class="table borderless">--%>
                    <div class="row">
                        <div class="form-group">
                            <label class="col-md-3">#User Id:</label>
                            <label class="col-md-3">${orderIn.userId}</label>
                        </div><br>
                        <div class="form-group">
                            <label class="col-md-3">Delivery status:</label>
                            <label class="col-md-3">${orderIn.deliveryStatus}</label>
                        </div><br>
                        <%--<h4>#User Id: ${orderIn.userId}</h4><br>--%>
                        <%--<h4>Delivery status: ${orderIn.deliveryStatus}</h4>--%>
                        <form:form modelAttribute="editDeliveryStatus" method="post"
                                   action="${pageContext.request.contextPath}/management/editDeliveryStatus">
                            <div class="form-group">
                                <label class="col-md-3">Edit delivery status:</label>
                                <div class="col-md-5">
                                    <form:select path="deliveryStatus" class="form-control">
                                        <c:if test="${!empty deliveryStatuses}">
                                            <c:forEach items="${deliveryStatuses}" var="dStat">
                                                <form:option value="${dStat}" label="${dStat}"></form:option>
                                            </c:forEach>
                                        </c:if>
                                    </form:select>
                                </div>
                                <div class="col-md-3">
                                    <input class="btn btn-primary" value="Edit" type="submit">
                                </div>

                            </div>
                        </form:form><br><br><br>
                        <div class="form-group">
                            <label class="col-md-3">Pay way:</label>
                            <label class="col-md-3">${orderIn.payWay}</label>
                        </div><br>
                        <div class="form-group">
                            <label class="col-md-3">Delivery way:</label>
                            <label class="col-md-3">${orderIn.deliveryWay}</label>
                        </div><br>
                        <div class="form-group">
                            <label class="col-md-3">Address:</label>
                            <label class="col-md-8">${addressOrder.country}, ${addressOrder.region}, ${addressOrder.city},
                                ${addressOrder.streetAddress}, post code ${addressOrder.postIndex}</h4>
                            </label>
                        </div><br><br><br>

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
                                        <tr data-toggle="modal" href="#productInOrder${product.productId}" class="cursor-pointer">
                                            <td>${bucket.productId}</td>
                                            <td>${product.productName}</td>
                                            <td>${bucket.countProduct}</td>
                                            <td>$${product.cost}</td>
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
                                                            <c:if test="${product.presentPic eq ''}">
                                                                <img class="img-responsive"
                                                                     src="${pageContext.request.contextPath}/resources/Images/default-copter.png" alt="...">
                                                            </c:if>
                                                            <c:if test="${product.presentPic ne ''}">
                                                                <img class="img-responsive"
                                                                     src="${pageContext.request.contextPath}/resources/Images/${product.presentPic}" alt="...">
                                                            </c:if>
                                                        </div>
                                                        <div class="col-md-6 product_content">
                                                            <h4>Product Id: <span>${product.productId}</span></h4>

                                                            <h5>Name: <span>${product.productName}</span></h5>
                                                            <h5>Category:
                                                                <span>${product.category}</span>
                                                            </h5>
                                                            <h5>Battery: <span>${product.battery}</span></h5>
                                                            <h5>Fly time: <span>${product.flyTime} min</span></h5>
                                                            <h5>Distance: <span>${product.distance} m</span></h5>
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
                            <tr class="cursor-default hover-tr-default">
                                <td></td>
                                <td></td>
                                <td>Total:</td>
                                <td>$${total}</td>
                            </tr>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>

        </div>

    </div>
</div>

</body>
</html>
