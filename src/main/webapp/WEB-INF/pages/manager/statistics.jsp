<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistic</title>
</head>
<body>
<jsp:include page="../../templates/navigation.jsp"/>

<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <%--<p class="lead">Личный кабинет</p>--%>
            <p class="lead"></p>
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/adminOrders" class="list-group-item">Order list</a>
                <a href="${pageContext.request.contextPath}/statistics" class="list-group-item">Shop statistic</a>
                <a href="${pageContext.request.contextPath}/adminProducts" class="list-group-item">Goods management</a>
            </div>
        </div>

        <div class="col-md-9">
            <div class="row">
                <br>
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#panelTopClients">Top clients</a></li>
                    <li><a data-toggle="tab" href="#panelTopGoods">Top goods</a></li>
                    <li><a data-toggle="tab" href="#panelProceed">Proceed</a></li>

                </ul>

                <div class="tab-content">
                    <div id="panelTopClients" class="tab-pane fade in active">

                        <c:if test="${!empty topClients}"> <br>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>#Id</th>
                                    <th>Name</th>
                                    <th>Surname</th>
                                    <th>Count goods</th>
                                    <th>Total</th>
                                </tr>
                                </thead>
                                <tbody>


                                <c:forEach items="${topClients}" var="client" varStatus="status">
                                    <tr>
                                        <td>${client.id}</td>
                                        <td>${client.firstName}</td>
                                        <td>${client.secondName}</td>
                                        <td>${client.sumCountProducts}</td>
                                        <td>${client.sumTotal}</td>

                                    </tr>

                                </c:forEach>

                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty topClients}"> <br>
                            You haven`t got clients statistic.
                        </c:if>

                    </div>

                    <div id="panelTopGoods" class="tab-pane fade">

                        <c:if test="${empty topProducts}"> <br>
                            You haven`t got goods statistic.
                        </c:if>
                        <c:if test="${!empty topProducts}"> <br>
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>#Id</th>
                                    <th>Name</th>
                                    <th>Cost</th>
                                    <th>Sales</th>
                                </tr>
                                </thead>
                                <tbody>


                                <c:forEach items="${topProducts}" var="product">
                                    <tr data-toggle="modal"
                                        href="#product-in-top-modal${product.productId}">

                                        <td>${product.productId}</td>
                                        <td>${product.productName}</td>
                                        <td>${product.cost}</td>
                                        <td>${product.sumCount}</td>

                                    </tr>

                                    <div class="modal fade product_view"
                                         id="product-in-top-modal${product.productId}">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">

                                                    <h3 class="modal-title">${product.productName}</h3>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="row">
                                                        <div class="col-md-6 product_img">
                                                            <img src="${pageContext.request.contextPath}/resources/Images/${product.presentPic}"
                                                                 class="img-responsive">
                                                        </div>
                                                        <div class="col-md-6 product_content">
                                                            <h4>Product Id: <span>${product.productId}</span></h4>

                                                            <h5>Name: <span>${product.productName}</span></h5>
                                                            <h5>Category: <span>${product.category}</span></h5>
                                                            <h5>Battery: <span>${product.battery}</span></h5>
                                                            <h5>Fly time: <span>${product.flyTime} min</span></h5>
                                                            <h5>Distance: <span>${product.distance} m</span></h5>
                                                            <c:forEach items="${product.properties}"
                                                                       var="propertyGroup">
                                                                <h5>${propertyGroup.key}:
                                                                    <span>
                                                                    <c:forEach items="${propertyGroup.value}"
                                                                               var="property" varStatus="status">
                                                                        <c:if test="${status.index eq 0}">${property}</c:if>
                                                                        <c:if test="${status.index gt 0}">, ${property}</c:if>
                                                                    </c:forEach>
                                                                    </span>
                                                                </h5>
                                                            </c:forEach>
                                                            <%--<h5>${product.description}</h5>--%>

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

                                </tbody>
                            </table>
                        </c:if>

                    </div>

                    <div id="panelProceed" class="tab-pane fade"><br>

                        <div class="form-group">
                            <label class="col-md-3">Proceed for a week:</label>
                            <label class="col-md-8">
                                <%--<c:if test="${weekProceed eq 0}">--%>
                                <%--You haven`t got week proceed statistic.--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${weekProceed ne 0}">--%>
                                ${weekProceed}
                                <%--</c:if>--%>
                            </label> <br>
                        </div>
                        <br>
                        <div class="form-group">
                            <label class="col-md-3">Proceed for a month:</label>
                            <label class="col-md-8">
                                <%--<c:if test="${monthProceed eq 0}">--%>
                                <%--You haven`t got month proceed statistic.--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${monthProceed ne 0}">--%>
                                ${monthProceed}
                                <%--</c:if>--%>
                            </label><br>
                        </div>


                    </div>
                </div>
            </div>
        </div>


    </div>
</div>

</body>
</html>
