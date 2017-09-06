<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<jsp:include page="../templates/navigation.jsp"/>

<br><br><br>
<%--<style>--%>
<%--ul > li{margin-right:25px;font-weight:lighter;cursor:pointer}--%>
<%--li.active{border-bottom:3px solid silver;}--%>
<%--</style>--%>

<div class="container">
    <div class="row">
        <%--<div class="col-md-2"></div>--%>
        <%--<div class="col-md-12">--%>
        <%--<div class="row">--%>
            <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-5 item-photo">
            <img style="max-width:100%;"
                 src="${pageContext.request.contextPath}/resources/Images/${product.presentPic}" alt="..."/>
        </div>
        <div class="col-md-5" style="border:0px solid gray">
            <h3>${product.productName}</h3>
            <h6>
                <%--<small>--%>
                    #Id: ${product.productId}
                <%--</small>--%>
            </h6>

            <h3 style="margin-top:50px;">${product.cost}$</h3>


            <%--<div class="section" style="padding-bottom:20px;">--%>
            <%--<h6 class="title-attr"><small>CANTIDAD</small></h6>--%>
            <%--<div>--%>
            <%--<div class="btn-minus"><span class="glyphicon glyphicon-minus"></span></div>--%>
            <%--<input value="1" />--%>
            <%--<div class="btn-plus"><span class="glyphicon glyphicon-plus"></span></div>--%>
            <%--</div>--%>
            <%--</div>--%>

            <div  style="margin-top:20px;">
                <button class="btn btn-primary" value="${product.productId}"
                onclick="addProductToCart(this)"> Add to cart</button>
                <%--<h6><a href="#"> Add to cart</a></h6>--%>
            </div>
        </div>

        <%--<div class="col-xs-9">--%>
        <%--<ul class="menu-items">--%>
        <%--<li class="active">Description</li>--%>
        <%--<li>Details</li>--%>
        <%--</ul>--%>
        <%--<div style="width:100%;border-top:1px solid silver">--%>
        <%--<p style="padding:15px;">--%>
        <%--<small>--%>
        <%--${product.description}--%>
        <%--</small>--%>
        <%--</p>--%>
        <%--&lt;%&ndash;<small>&ndash;%&gt;--%>
        <%--&lt;%&ndash;${product.description}&ndash;%&gt;--%>
        <%--&lt;%&ndash;</small>&ndash;%&gt;--%>
        <%--</div>--%>

        <%--<div class="tabbable-panel">--%>
        <%--<div class="tabbable-line">--%>
            </div>
            <div class="row" style="margin-top: 10px;">
        <div class="col-md-1"></div>
        <div class="col-md-10">

            <div class="col-md-3">
                <ul class="nav nav-tabs tabs-left">
                    <li class="active">
                        <a href="#tab_default_1" data-toggle="tab">
                            Description </a>
                    </li>
                    <li>
                        <a href="#tab_default_2" data-toggle="tab">
                            Details </a>
                    </li>
                </ul>
            </div>
            <div class="col-md-9">
                <div class="tab-content">
                    <div class="tab-pane active" id="tab_default_1"
                         style="width:100%;border-top:1px solid silver">
                        <p style="padding:15px;">
                            <%--<small>--%>
                                ${product.description}
                            <%--</small>--%>
                        </p>
                    </div>
                    <div class="tab-pane" id="tab_default_2" style="width:100%;border-top:1px solid silver">
                        <div style="padding: 15px;">
                        <p>Category: <span>${product.category}</span></p>
                        <p>Battery: <span>${product.battery}</span></p>
                        <p>Fly time: <span>${product.flyTime} min</span></p>
                        <p>Distance: <span>${product.distance} m</span></p>
                        <c:forEach items="${product.properties}" var="propertyGroup">
                            <p>${propertyGroup.key}: <span>
                                        <c:forEach items="${propertyGroup.value}" var="property" varStatus="status">
                                            <c:if test="${status.index eq 0}">${property}</c:if><c:if test="${status.index gt 0}">, ${property}</c:if>
                                        </c:forEach>
                                    </span></p>
                        </c:forEach>


                            <%--<table>--%>
                                <%--<tr><td>Category:</td><td>${product.category}</td></tr>--%>
                                <%--<tr><td>Battery:</td><td>${product.battery}</td></tr>--%>
                                <%--<tr><td>Fly time:</td><td>${product.flyTime}</td></tr>--%>
                                <%--<tr><td>Distance:</td><td>${product.distance}</td></tr>--%>
<%--<c:forEach items="${product.properties}" var="propertyGroup">--%>
                                <%--<tr><td>${propertyGroup.key}:</td>--%>
                                    <%--<td>--%>
                                        <%--<c:forEach items="${propertyGroup.value}" var="property" varStatus="status">--%>
                                            <%--<c:if test="${status.index eq 0}">${property}</c:if><c:if test="${status.index gt 0}">, ${property}</c:if>--%>
                                        <%--</c:forEach>--%>
                                    <%--</td>--%>
                                <%--</tr>--%>
<%--</c:forEach>--%>
                            <%--</table>--%>

                        </div>

                    </div>
                </div>
            </div>
            <%--</div>--%>
            <%--</div>--%>
        </div>
            </div>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
    </div>
</div>
<script>
    function addProductToCart(obj) {
        var idProduct = obj.value;
        $("#navbar-count-in-cart").text(Number($("#navbar-count-in-cart").text())+1);
        $("#message-success-add-to-cart").fadeIn(500);
        setTimeout(function(){$("#message-success-add-to-cart").fadeOut(1000)}, 2000);
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/addToCart/" + idProduct
        })
    }
</script>
</body>
</html>
