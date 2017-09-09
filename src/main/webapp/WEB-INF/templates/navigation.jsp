<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<head>
    <title>FavCopters</title>
    <link rel="shortcut icon"
          href="${pageContext.request.contextPath}/resources/Images/favicon.ico"
          >
    <jsp:include page="head.jsp"/>
</head>

<jsp:include page="scripts.jsp"/>
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="collapse navbar-collapse" id="my-menu-navbar">
            <ul class="nav navbar-nav">
                <li>
                    <a href="${pageContext.request.contextPath}/">Home</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/catalog">Catalog</a>
                </li>
                <%--<c:if test="${user.role ne 'ROLE_ANONYM'}">--%>
                <sec:authorize access="hasRole('ROLE_CLIENT') or hasRole('ROLE_MANAGER')">
                    <li>
                        <a href="${pageContext.request.contextPath}/profile/">My Room</a>
                    </li>
                </sec:authorize>
                <%--</c:if>--%>

                <%--<c:if test="${user.role eq 'ROLE_MANAGER'}">--%>
                <sec:authorize access="hasRole('ROLE_MANAGER')">
                    <li>
                        <a href="${pageContext.request.contextPath}/management/adminOrders">Administration</a>
                    </li>
                </sec:authorize>
                <%--</c:if>--%>


            </ul>
            <ul class="nav navbar-nav navbar-right ">

                <li class="dropdown" id="dropdown-click-navbar-cart">
                    <a class="dropdown-toggle"  data-toggle="dropdown" role="button" aria-expanded="false">
                        <i class="fa fa-shopping-cart dropdown" style="font-size:16px"></i>
                        <span id="navbar-count-in-cart" style="width: 30px"></span> - Cart</a>
                    <ul class="dropdown-menu" role="menu" style="padding: 18px">
                        <div id="dropdown-cart">
                            <jsp:include page="cartDown.jsp"/>
                        </div>
                    </ul>
                </li>
                <%--<c:if test="${user.role eq 'ROLE_ANONYM'}">--%>
                    <sec:authorize access="!hasRole('ROLE_CLIENT') and !hasRole('ROLE_MANAGER')">
                    <li>
                        <a href="${pageContext.request.contextPath}/login">Log in</a>
                    </li>
                    </sec:authorize>
                <%--</c:if>--%>

                <%--<c:if test="${user.role ne 'ROLE_ANONYM'}">--%>
                <sec:authorize access="hasRole('ROLE_CLIENT') or hasRole('ROLE_MANAGER')">
                    <li>
                        <a href="${pageContext.request.contextPath}/logout">Log out</a>
                    </li>
                </sec:authorize>
                <%--</c:if>--%>
            </ul>

        </div>
    </div>
</nav>
<script>
    $(function () {
        var location = window.location.href;
        var cur_url = '${pageContext.request.contextPath}/' + location.split('/').pop();
        $('#my-menu-navbar li').each(function () {
            var link = $(this).find('a').attr('href');
            if (cur_url == link) {
                $(this).addClass('active');
            }
        });
    });

     $(document).ready(function () {
         $.ajax({
             type: "POST",
             url: "${pageContext.request.contextPath}/getCountInCart",
             success: function (resp) {
                 $("#navbar-count-in-cart").text(resp);
             }
         })
     });

    $("#dropdown-click-navbar-cart").click(function () {

        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/getProductsInCart",
            success: function (resp) {
                console.log("dropdown was opened");
                $("#dropdown-cart").html(resp);
                $(".shopping-cart").fadeToggle( "fast");
            }
        })
    })



</script>