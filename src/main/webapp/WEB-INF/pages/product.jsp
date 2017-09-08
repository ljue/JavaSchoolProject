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

        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-5 item-photo">
                <c:if test="${product.presentPic eq ''}">
                    <img src="${pageContext.request.contextPath}/resources/Images/default-copter.png"
                         alt="..." style="max-width:100%;">
                </c:if>
                <c:if test="${product.presentPic ne ''}">
                    <img src="${pageContext.request.contextPath}/resources/Images/${product.presentPic}"
                         alt="..." style="max-width:100%;">
                </c:if>

            </div>
            <div class="col-md-5" style="border:0px solid gray">
                <h3>${product.productName}</h3>
                <h6>
                    <%--<small>--%>
                    #Id: ${product.productId}
                    <%--</small>--%>
                </h6>

                <h3 style="margin-top:50px;">${product.cost}$</h3>

                <div style="margin-top:20px;">
                    <button class="btn btn-primary" value="${product.productId}"
                            onclick="addProductToCart(this)"> Add to cart
                    </button>
                </div>
            </div>
        </div>

        <%--<div class="row">--%>
        <%--<c:forEach items="${productTop}" var="top" varStatus="status">--%>
        <%--<div class="item">--%>
        <%--<div class="col-md-4">--%>
        <%--<a href="${pageContext.request.contextPath}/catalog/product/${top.productId}">--%>
        <%--<c:if test="${top.presentPic eq ''}">--%>
        <%--<img src="${pageContext.request.contextPath}/resources/Images/default-copter.png"--%>
        <%--class="img-responsive center-block img-250">--%>
        <%--</c:if>--%>
        <%--<c:if test="${top.presentPic ne ''}">--%>
        <%--<img src="${pageContext.request.contextPath}/resources/Images/${top.presentPic}"--%>
        <%--class="img-responsive center-block img-250">--%>
        <%--</c:if>--%>
        <%--</a>--%>
        <%--<div class="text-center">--%>
        <%--<span data-toggle="tooltip" title="${top.productName}">--%>
        <%--${top.productCartName}--%>
        <%--</span>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</c:forEach>--%>

        <%--</div>--%>


        <div class="row" style="margin-top: 10px; min-height: 250px">
            <div class="col-md-1"></div>
            <div class="col-md-10">

                <div class="col-md-3">
                    <ul class="nav nav-tabs tabs-left border-none">
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
                                            <c:if test="${status.index eq 0}">${property}</c:if><c:if
                                                test="${status.index gt 0}">, ${property}</c:if>
                                        </c:forEach>
                                    </span></p>
                                </c:forEach>

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

        <c:if test="${!empty productTop}">
            <hr>
            <div style="margin: 100px 0 50px 0;" class="text-center">
                <h3 style="color: #23527c">You can also like:</h3>
            </div>

            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-10">

                    <div class="span12" style="margin-bottom: 50px">
                            <%--<div class="well" style="background: #fff">--%>
                        <div id="myCarousel" class="carousel fdi-Carousel  slide">
                            <!-- Carousel items -->
                            <div class="carousel fdi-Carousel slide" id="eventCarousel" data-interval="0">
                                <div class="carousel-inner onebyone-carosel">

                                    <c:forEach items="${productTop}" var="top" varStatus="status">
                                    <c:if test="${status.count eq 1}">
                                    <div class="item active">

                                        </c:if>
                                        <c:if test="${status.count ne 1}">
                                        <div class="item">
                                            </c:if>
                                            <div class="col-md-4">
                                                <a href="${pageContext.request.contextPath}/catalog/product/${top.productId}">
                                                    <c:if test="${top.presentPic eq ''}">
                                                        <img src="${pageContext.request.contextPath}/resources/Images/default-copter.png"
                                                             class="img-responsive center-block img-250">
                                                    </c:if>
                                                    <c:if test="${top.presentPic ne ''}">
                                                        <img src="${pageContext.request.contextPath}/resources/Images/${top.presentPic}"
                                                             class="img-responsive center-block img-250">
                                                    </c:if>
                                                </a>
                                                <div class="text-center" style="color: #337ab7">
                                                    <a href="${pageContext.request.contextPath}/catalog/product/${top.productId}">
                                                        <span data-toggle="tooltip" title="${top.productName}">
                                                                ${top.presentProductName}
                                                        </span>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>

                                        </c:forEach>
                                    </div>
                                    <a class="left carousel-control" href="#eventCarousel" data-slide="prev"></a>
                                    <a class="right carousel-control" href="#eventCarousel" data-slide="next"></a>
                                </div>
                                <!--/carousel-inner-->
                            </div><!--/myCarousel-->
                                <%--</div><!--/well-->--%>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </div>


    <script>
        $(document).ready(function () {
            $('#myCarousel').carousel({
                interval: 10000
            })
            $('.fdi-Carousel .item').each(function () {
                var next = $(this).next();
                if (!next.length) {
                    next = $(this).siblings(':first');
                }
                next.children(':first-child').clone().appendTo($(this));

                if (next.next().length > 0) {
                    next.next().children(':first-child').clone().appendTo($(this));
                }
                else {
                    $(this).siblings(':first').children(':first-child').clone().appendTo($(this));
                }
            });
        });
    </script>


    <div id="message-success-add-to-cart-pr" class="my-message-success alert alert-success">
        <p style="font-size: 1.1em">Product was added to cart.</p>
    </div>

    <script>
        function addProductToCart(obj) {
            var idProduct = obj.value;
            $("#navbar-count-in-cart").text(Number($("#navbar-count-in-cart").text()) + 1);
            $("#message-success-add-to-cart-pr").fadeIn(500);
            setTimeout(function () {
                $("#message-success-add-to-cart-pr").fadeOut(1000)
            }, 2000);
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/addToCart/" + idProduct
            })
        }
    </script>
</body>
</html>
