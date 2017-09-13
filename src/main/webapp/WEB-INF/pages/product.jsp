<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

            <div class="col-md-5 item-photo" style="min-height: 400px; min-width: 400px">
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
                    #Id: <span id="product-id-edit-info">${product.productId}</span>
                </h6>

                <h3 style="margin-top:50px;">${product.cost}$</h3>
                <div style="padding-top: 50px; margin-left: 2px">
                    <c:if test="${product.count>0}">
                        <span><i class="fa fa-check" aria-hidden="true"></i> In stock</span>
                    </c:if>
                    <c:if test="${product.count==0}">
                        <span><i class="fa fa-times" aria-hidden="true"></i> Out of</span>
                    </c:if>
                </div>
                <div style="margin-top:20px;" class="form-group">
                    <button class="btn btn-primary" value="${product.productId}"
                            onclick="addProductToCart(this)"> Add to cart
                    </button>
                    <sec:authorize access="hasRole('ROLE_MANAGER')">
                        <button id="btn-show-edit-product-panel" class="btn btn-default"
                                value="${product.productId}"> Edit product </button>
                    </sec:authorize>
                </div>
            </div>
        </div>


        <div id="product-in-catalog-info">
            <jsp:include page="productInfo.jsp"/>
        </div>
        <sec:authorize access="hasRole('ROLE_MANAGER')">
            <div id="product-edit-info-panel" style="display: none;">
                <jsp:include page="productEditInfo.jsp"/>
            </div>
        </sec:authorize>

        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>

        <c:if test="${!empty productTop}">
            <hr>
            <div style="margin: 100px 0 50px 0;" class="text-center">
                <h3 style="color: #23527c">You may also like:</h3>
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
</div>
    <div id="message-success-add-to-cart-pr" class="my-message-success alert alert-success">
        <p style="font-size: 1.1em">Product was added to cart.</p>
    </div>
    <div id="message-success-edit-product" class="my-message-success alert alert-success">
        <p style="font-size: 1.1em; padding-left: 30px; padding-bottom: 5px"> Success.</p>
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

        $("#btn-show-edit-product-panel").click(function (e) {
            e.preventDefault();
            $("#product-edit-info-panel").slideDown();
            var top = $("#product-edit-info-panel").offset().top;
            $('body,html').animate({scrollTop: top}, 400);
        })

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
