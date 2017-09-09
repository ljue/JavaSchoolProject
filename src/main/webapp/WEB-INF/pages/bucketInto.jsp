<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${empty productsInCart}">
    <h4>Your cart is empty =(.</h4>
</c:if>
<c:if test="${!empty productsInCart}">


    <table class="table table-hover" style="margin-bottom: 0">
        <thead>
        <tr>
            <th class="col-md-1">#Id</th>
            <th class="col-md-5">Name</th>
            <th class="col-md-1">Availability</th>
            <th class="col-md-2" style="text-align: center">Count</th>
            <th class="col-md-2" style="text-align: center">Cost $</th>
            <th class="col-md-1">Remove</th>
        </tr>
        </thead>
        <tbody>


        <c:forEach items="${productsInCart}" var="productInCart" varStatus="status">
            <%--<c:if test="${status.count }"--%>
            <tr id="tr-in-bucket-table${productInCart.key.productId}">
                <td class="col-md-1 cursor-default">
                        ${productInCart.key.productId}
                </td>
                <td data-toggle="modal" class="col-md-1" href="#productToBuy${productInCart.key.productId}">
                        ${productInCart.key.productName}
                </td>
                <td class="col-md-1 text-center" style="padding: 17px 0 17px 0" data-seq="${productInCart.key.count}"
                    id="check-count-product-${productInCart.key.productId}">
                    <c:if test="${productInCart.key.count > productInCart.value}">
                        <i class="fa fa-check" aria-hidden="true"></i>
                    </c:if>
                    <c:if test="${productInCart.key.count < productInCart.value}">
                        <i class="fa fa-times" aria-hidden="true"></i>
                    </c:if>
                </td>
                <td class="col-md-2 cursor-default">
                    <div class="input-group">
                                        <span class="input-group-btn">
                                            <button type="button" class="btn btn-default btn-number"
                                                    value="${productInCart.key.productId}"
                                                    min="0" step="1" onclick="minusProductFromCart(this)">
                                                <i class="fa fa-minus fa-2"></i>
                                            </button>
                                        </span>
                            <%--<input id="changeCountProducts${productInCart.key.productId}" type="text"--%>
                            <%--value="${productInCart.value}" data-seq="${productInCart.key.productId}"--%>
                            <%--class="form-control input-number"--%>
                            <%--onchange="changeCountProducts(this)" required/>--%>
                        <input type="number" id="changeCountProducts${productInCart.key.productId}"
                               value="${productInCart.value}" data-seq="${productInCart.key.productId}"
                               class="form-control input-number change-count-product-in-bucketInto" required/>
                        <span class="input-group-btn">
                                            <button type="button" class="btn btn-default btn-number"
                                                    value="${productInCart.key.productId}"
                                                    onclick="addProductToCart(this)">
                                                <i class="fa fa-plus fa-3"></i>
                                            </button>
                        </span>
                    </div>
                </td>
                <td class="col-md-2 cursor-default" style="text-align: center"
                    id="costProduct${productInCart.key.productId}">${productInCart.key.cost}
                </td>
                <td style="text-align: center" class="cursor-default">
                    <button type="button" class="btn btn-link btn-xs" value="${productInCart.key.productId}"
                            onclick="deleteProductFromCart(this)">
                        <span><i class="fa fa-trash-o fa-lg"></i> </span>
                    </button>
                </td>
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
                                    <c:if test="${productInCart.key.presentPic eq ''}">
                                        <img class="img-responsive"
                                             src="${pageContext.request.contextPath}/resources/Images/default-copter.png"
                                             alt="...">
                                    </c:if>
                                    <c:if test="${productInCart.key.presentPic ne ''}">
                                        <img class="img-responsive"
                                             src="${pageContext.request.contextPath}/resources/Images/${productInCart.key.presentPic}"
                                             alt="...">
                                    </c:if>
                                </div>
                                <div class="col-md-6 product_content">
                                    <h4>Product Id: <span>${productInCart.key.productId}</span></h4>

                                    <h5>Name: <span>${productInCart.key.productName}</span></h5>
                                    <h5>Category: <span>${productInCart.key.category}</span></h5>
                                    <h5>Battery: <span>${productInCart.key.battery}</span></h5>
                                    <h5>Fly time: <span>${productInCart.key.flyTime} min</span></h5>
                                    <h5>Distance: <span>${productInCart.key.distance} m</span></h5>
                                    <c:forEach items="${productInCart.key.properties}" var="propertyGroup">
                                        <h5>${propertyGroup.key}: <span>
                                        <c:forEach items="${propertyGroup.value}" var="property" varStatus="status">
                                            <c:if test="${status.index eq 0}">${property}</c:if>
                                            <c:if test="${status.index gt 0}">, ${property}</c:if>
                                        </c:forEach>
                                    </span></h5>
                                    </c:forEach>
                                        <%--<h5>${productInCart.key.description}</h5>--%>

                                    <h3 class="cost"></span> $${productInCart.key.cost}</h3>

                                    <div class="space-ten"></div>
                                    <div class="btn-ground">
                                        <a href="${pageContext.request.contextPath}/catalog/product/${productInCart.key.productId}"
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
        <tr class="cursor-default hover-tr-default">
            <td></td>
            <td></td>
            <td></td>
            <td style="text-align: center"><b>Total:</b></td>
            <td id="calc-total-price" style="text-align: center">${totalPrice}</td>
            <td></td>
        </tr>
        </tbody>
    </table>

    <div class="form-group">
        <label class="col-md-4 control-label"></label>
        <div class="col-md-8">
            <a href="${pageContext.request.contextPath}/checkout/" id="btn-go-checkout">
                <button type="button" class="btn btn-primary right"> CheckOut</button>
            </a>
        </div>
    </div>

</c:if>

<br>
<br>
<br>

<div id="message-empty-count-of-product-in-bucket" class="my-message-success alert alert-danger">
    <p style="font-size: 1.1em">Sorry, there are out of this products.</p>
</div>

<script>

    function checkOptions(count, idProduct) {
        if ($("#check-count-product-"+idProduct).data("seq")>count) {
            $("#check-count-product-"+idProduct).html("<i class='fa fa-check fa-lg' aria-hidden='true'></i>");
        } else {
            $("#check-count-product-"+idProduct).html("<i class='fa fa-times fa-lg' aria-hidden='true'></i>");
        }
    }


    function addProductToCart(obj) {
        var idProduct = obj.value;
        var count = Number($("#changeCountProducts" + idProduct).val());
        var cost = Number($('#costProduct' + idProduct).text());
        var total = Number($('#calc-total-price').text());
        $("#navbar-count-in-cart").text(Number($("#navbar-count-in-cart").text()) + 1);

        count = count + 1;
        total = total + cost;

        $("#changeCountProducts" + idProduct).val(count);
        $("#calc-total-price").text(total.toFixed(2));

        checkOptions(count, idProduct);

        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/addToCart/" + idProduct
        });
    };
    function minusProductFromCart(obj) {
        var idProduct = obj.value;
        var count = Number($("#changeCountProducts" + idProduct).val());
        if (count > 0) {
            var cost = Number($('#costProduct' + idProduct).text());
            var total = Number($('#calc-total-price').text());
            $("#navbar-count-in-cart").text(Number($("#navbar-count-in-cart").text()) - 1);

            count = count - 1;
            total = total - cost;

            $("#changeCountProducts" + idProduct).val(count);
            $("#calc-total-price").text(total.toFixed(2));

            checkOptions(count, idProduct);

            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/minusFromCart/" + idProduct
            })

        }
    };
    function deleteProductFromCart(obj) {
        var idProduct = obj.value;
        var count = 0;
        //$("#tr-in-bucket-table"+idProduct).slideUp();
        $.ajax({
            type: "POST",
            data: {count: count},
            url: "${pageContext.request.contextPath}/changeCountInCart/" + idProduct,
            success: function (page) {
                $("#products-in-bucket").html(page);
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/getCountInCart",
                    success: function (resp) {
                        $("#navbar-count-in-cart").text(resp);
                    }
                })
            }
        })
    };

    $("#btn-go-checkout").click(function (e) {
        if($(".fa-times").length) {
            e.preventDefault();
            $("#message-empty-count-of-product-in-bucket").fadeIn(500);
            setTimeout(function () {
                $("#message-empty-count-of-product-in-bucket").fadeOut(1000)
            }, 2000);
        }
    })

    $(".change-count-product-in-bucketInto").change(function () {
        var count = $(this).val();
        var idProduct = $(this).data("seq");
        if (count > 0) {
            $.ajax({
                type: "POST",
                data: {count: count},
                url: "${pageContext.request.contextPath}/changeCountInCart/" + idProduct,
                success: function (page) {
                    $("#products-in-bucket").html(page);
                    checkOptions(count, idProduct);
                    $.ajax({
                        type: "POST",
                        url: "${pageContext.request.contextPath}/getCountInCart",
                        success: function (resp) {
                            $("#navbar-count-in-cart").text(resp);
                        }
                    })
                }
            })
        } else {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/changeCountInCart/getCurrentVal/" + idProduct,
                success: function (resp) {
                    $("#changeCountProducts" + idProduct).val(resp);
                    checkOptions(count, idProduct);
                }
            })
        }
    })

</script>
