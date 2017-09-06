<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<div style="margin: auto; width: 80%">--%>
<%--<div class="shopping-cart">--%>
<%--<div class="shopping-cart-header">--%>
<%--<i class="fa fa-shopping-cart cart-icon"></i>--%>
<%--<div class="shopping-cart-total">--%>
<%--<span class="lighter-text">Total:</span>--%>
<%--<span class="main-color-text">${totalInNavBar}</span>--%>
<%--</div>--%>
<%--</div>--%>

<%--<ul class="shopping-cart-items">--%>
<%--<c:forEach items="${productsInNavBar}" var="product">--%>
<%--<li class="clearfix">--%>
<%--<img src="${pageContext.request.contextPath}/resources/Images/${product.key.presentPic}" alt="..." style="height: 50px; width: 50px"/>--%>
<%--<span class="item-name" data-toggle="tooltip" title="${product.key.productName}">${product.key.presentProductName}</span>--%>
<%--<span class="item-price">${product.key.cost}$</span>--%>
<%--<span class="item-quantity">Quantity: ${product.value}</span>--%>
<%--</li>--%>
<%--</c:forEach>--%>
<%--<c:if test="${empty productsInNavBar}">--%>
<%--<li class="clearfix text-center">Cart is empty</li>--%>
<%--</c:if>--%>
<%--</ul>--%>


<%--<a href="${pageContext.request.contextPath}/bucket" class="button">View Cart</a>--%>
<%--</div>--%>
<%--</div>--%>
<%--<ul class="dropdown-menu dropdown-cart" role="menu">--%>

<%--<ul class="dropdown-menu" role="menu">--%>
<%--<div id="dropdown-cart">--%>
<div class="shopping-cart-header">
    <span class="icon-cart"><i class="fa fa-shopping-cart" style="font-size: 18px"></i>
        <span style="margin-bottom: 5px">
            <span id="count-in-cart-dropdown"></span>
        </span>
    </span>

    <div class="shopping-cart-total">
        <span class="lighter-text">Total:</span>
        <span class="main-color-text">${totalInNavBar}$</span>
    </div>
</div>
<c:forEach items="${productsInNavBar}" var="product">
    <li class="li-in-cart">
        <img src="${pageContext.request.contextPath}/resources/Images/${product.key.presentPic}" class="img-in-cart">
        <a href="${pageContext.request.contextPath}/catalog/product/${product.key.productId}">
            <span class="item-name" data-toggle="tooltip" title="${product.key.productName}">
                    ${product.key.productCartName}
            </span>
        </a>
        <span class="item-price">${product.key.cost}$</span>
        <span class="item-quantity">Quantity: ${product.value}</span>
    </li>
</c:forEach>
<c:if test="${empty productsInNavBar}">
    <li class="divider-empty-cart"></li>
</c:if>
<c:if test="${!empty productsInNavBar}">
    <li class="divider"></li>
</c:if>
<li class="text-center"><a href="${pageContext.request.contextPath}/bucket">View Cart</a></li>
<%--</div>--%>
<%--</ul>--%>
<%--</ul>--%>
<%--<c:if test="${!empty productsInNavBar}">--%>
<%--<li>--%>
<%--<a href="${pageContext.request.contextPath}/bucket">View Cart</a>--%>
<%--</li>--%>
<%--</c:if>--%>
<script>
    $(document).ready(function () {
        $("#count-in-cart-dropdown").text($("#navbar-count-in-cart").text());
    });
</script>

