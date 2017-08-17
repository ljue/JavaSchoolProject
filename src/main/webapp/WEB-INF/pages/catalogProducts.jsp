<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${!empty allProducts}">
    <c:forEach items="${allProducts}" var="product">
        <div class="col-md-4 col-sm-3">
                <span class="thumbnail">
                    <a role="button" data-toggle="modal" href="#product${product.productId}">
                    <img src="resources/Images/${product.presentPic}" alt="...">
                    </a>

                    <div class="size-div-name" data-toggle="tooltip" title="${product.productName}"><h5>${product.presentProductName}</h5></div>
                    <hr class="line">
                    <div class="row">
                        <div class="col-md-6 col-sm-6">
                            <p class="price">   $${product.cost}</p>
                        </div>
                        <div class="col-md-6 col-sm-6">
                         <button value="${product.productId}" onclick="addProductToCart(this)"
                                 class="btn btn-info right"> Add to Cart </button>
                        </div>

                    </div>
                </span>

        </div>
        <div class="modal fade product_view" id="product${product.productId}">
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
                                <h5>Fly time: <span>${product.flyTime}</span></h5>
                                <h5>Distance: <span>${product.distance}</span></h5>
                                <c:forEach items="${product.properties}" var="propertyGroup">
                                    <h5>${propertyGroup.key}: <span>
                                        <c:forEach items="${propertyGroup.value}" var="property" varStatus="status">
                                            <c:if test="${status.index eq 0}">${property}</c:if>
                                            <c:if test="${status.index gt 0}">, ${property}</c:if>
                                            <%--${property},--%>
                                        </c:forEach>
                                    </span></h5>
                                </c:forEach>
                                <h5>Description: <span>${product.description}</span></h5>

                                <h3 class="cost"></span> $${product.cost}</h3>


                                <div class="space-ten"></div>
                                <div class="btn-ground">
                                    <button type="button" value="${product.productId}"
                                            onclick="addProductToCart(this)" class="btn btn-primary">
                                        Add To Cart
                                    </button>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</c:if>
<c:if test="${empty allProducts}"> <h4>We don`t have goods such category. </h4></c:if>

<script>
    function addProductToCart(obj) {
        var idProduct = obj.value;
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/addToCart/" + idProduct
        })
    }
</script>

<script>
    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>