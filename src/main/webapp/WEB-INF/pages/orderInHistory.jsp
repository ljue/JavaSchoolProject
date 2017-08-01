<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Людмила
  Date: 01.08.2017
  Time: 2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order in history</title>

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

            <div class="row">
                <h3>#Order Id: ${orderIn.orderId}</h3><br>
                    <h4>Delivery status: ${orderIn.deliveryStatus}</h4>
                    <h4>Pay way: ${orderIn.payWay}</h4>
                    <h4>Delivery way: ${orderIn.deliveryWay}</h4>


                <br>

                <div class="col-lg-4 col-sm-3 text-center">
                    <div class="well">
                        <strong class="pull-left primary-font">Address</strong>
                        <ul class="list-unstyled ui-sortable">
                            <hr>
                            <li class="ui-state-default">
                                ${addressOrder.country},<br>
                                ${addressOrder.region},<br>
                                ${addressOrder.city},<br>
                                ${addressOrder.streetAddress},<br>
                                Post code: ${addressOrder.postIndex}<br>
                            </li>
                        </ul>
                    </div>
                </div>

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
                                                    <h5>Category: <span>${product.productCategoryByCategory}</span></h5>
                                                    <h5>Battery: <span>${product.battery}</span></h5>
                                                    <h5>Fly time: <span>${product.flyTime}</span></h5>
                                                    <h5>Distance: <span>${product.distance}</span></h5>
                                                    <h5>${product.description}</h5>

                                                    <h3 class="cost"></span> $${product.cost}</h3>



                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
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


            </div>
        </div>
    </div>
</div>

</body>
</html>
