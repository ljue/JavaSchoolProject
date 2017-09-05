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
    <c:forEach items="${productsInNavBar}" var="product">
        <li>
            <span class="item">
                <span class="item-left">
                    <img src="${pageContext.request.contextPath}/resources/Images/${product.key.presentPic}"
                         style="height: 50px; width: 50px">
                    <span class="item-info">
                        <span data-toggle="tooltip"
                              title="${product.key.productName}">${product.key.presentProductName}</span>
                        <span>${product.key.cost}$</span>
                    </span>
                </span>
                <span class="item-right">
                    <span>${product.value} items</span>
                </span>
            </span>
        </li>
    </c:forEach>
<c:if test="${empty productsInNavBar}">
    <li class="text-center">Cart is empty</li>
</c:if>
    <li><a href="${pageContext.request.contextPath}/bucket"  class="text-center">View Cart</a></li>

<%--</ul>--%>
<%--<c:if test="${!empty productsInNavBar}">--%>
<%--<li>--%>
<%--<a href="${pageContext.request.contextPath}/bucket">View Cart</a>--%>
<%--</li>--%>
<%--</c:if>--%>


