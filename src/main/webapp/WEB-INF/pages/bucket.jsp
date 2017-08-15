<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bucket</title>
    <jsp:include page="../templates/head.jsp"/>

    <style>
        @import url(//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css);

        tbody > tr {
            cursor: pointer;
        }

        .result {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<jsp:include page="../templates/navigation.jsp"/>
<jsp:include page="../templates/scripts.jsp"/>


</div>
<!-- /.container -->
<div class="container">

    <br>
    <br>

    <h1><i class="fa fa-shopping-cart"></i> Shopping Cart </h1>

    <hr>
    <c:if test="${empty productsInCart}">
        <h4>You haven`t add any goods to shopping cart yet.</h4>
    </c:if>
    <c:if test="${!empty productsInCart}">
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


            <c:forEach items="${productsInCart}" var="productInCart" varStatus="status">
                <%--<c:if test="${status.count }"--%>
                <tr data-toggle="modal" href="#productToBuy${productInCart.key.productId}">
                    <td>${productInCart.key.productId}</td>
                    <td>${productInCart.key.productName}</td>
                    <td>${productInCart.value}</td>
                    <td>${productInCart.key.cost}</td>
                </tr>


                <div class="modal fade product_view" id="productToBuy${productInCart.key.productId}">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">

                                <h3 class="modal-title">${productInCart.key.productName}</h3>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-md-6 product_img">
                                        <img src="../resources/Images/${productInCart.key.presentPic}"
                                             class="img-responsive">
                                    </div>
                                    <div class="col-md-6 product_content">
                                        <h4>Product Id: <span>${productInCart.key.productId}</span></h4>

                                        <h5>Name: <span>${productInCart.key.productName}</span></h5>
                                        <h5>Category: <span>${productInCart.key.category}</span></h5>
                                        <h5>Battery: <span>${productInCart.key.battery}</span></h5>
                                        <h5>Fly time: <span>${productInCart.key.flyTime}</span></h5>
                                        <h5>Distance: <span>${productInCart.key.distance}</span></h5>
                                        <h5>${productInCart.key.description}</h5>

                                        <h3 class="cost"></span> $${productInCart.key.cost}</h3>

                                        <div class="space-ten"></div>
                                        <div class="form-group">
                                                <%--<label class="col-md-4 control-label"></label>--%>
                                            <div class="col-md-8">
                                                <button type="button" value="${productInCart.key.productId}"
                                                        onclick="addProductToCart(this)" class="btn btn-primary"> Add
                                                </button>
                                                <span>  </span><span>  </span>
                                                <button type="button" value="${productInCart.key.productId}"
                                                        onclick="deleteProductFromCart(this)" class="btn btn-default">
                                                    Delete
                                                </button>
                                            </div>
                                        </div>


                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </c:forEach>

            <td></td>
            <td></td>
            <td><b>Total:</b></td>
            <td>${commonPrice}</td>
            </tbody>
        </table>

        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-8">
                <a href="/checkout">
                    <button type="button" class="btn btn-primary right"> CheckOut</button>
                </a>
                    <%--<span>  </span><span>  </span>--%>
                    <%--<a href="/bucket">--%>
                    <%--<button type="button" class="btn btn-default right"  > Reload </button>--%>
                    <%--</a>--%>
            </div>
        </div>

        <%--<div class="btn-ground">--%>
        <%--<form action="/checkout">--%>
        <%--<input type="submit" value="CheckOut" class="btn btn-primary right">--%>
        <%--</form>--%>
        <%--&lt;%&ndash;<button type="button" onclick="${checkout}" >  </button>&ndash;%&gt;--%>
        <%--</div>--%>

        <%--<div class="btn-ground">--%>
        <%--<form >--%>
        <%--<input type="button" value="CheckOut" class="btn btn-primary right" onClick='location.href="/checkout"'>--%>
        <%--</form>--%>
        <%--<button type="button" onclick="${checkout}" >  </button>--%>
        <%--</div>--%>

    </c:if>

    <br>
    <br>
    <br>
    <script>
        <%--#productToBuy${productInCart.key.productId}--%>
        $('.product_view').on('hidden.bs.modal', function (e) {
            window.location.reload();
        })
    </script>


    <%--<div class="col-sm-12 ">--%>
    <%--<div class="result pull-left"><strong>Mostrando 1 até 6 de 5000</strong></div>--%>

    <%--<ul class="pagination pull-right">--%>
    <%--<li><a href="#">«</a></li>--%>
    <%--<li><a href="#">1</a></li>--%>
    <%--<li><a href="#">2</a></li>--%>
    <%--<li><a href="#">3</a></li>--%>
    <%--<li><a href="#">4</a></li>--%>
    <%--<li><a href="#">5</a></li>--%>
    <%--<li><a href="#">»</a></li>--%>
    <%--</ul>--%>

    <%--</div>--%>
    <%--странички--%>


</div>

<script>
    function addProductToCart(obj) {
        var idProduct = obj.value;
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/addToCart/" + idProduct
        })
    };
    function deleteProductFromCart(obj) {
        var idProduct = obj.value;
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/deleteFromCart/" + idProduct
        })
    };

    //    close.click(function () {
    //        $.ajax({
    //            type: "GET",
    //            url: "/reloadCart/"
    //        })
    //    })
</script>


</body>
</html>
