
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="myContext"/>
<head>
    <jsp:include page="head.jsp"/>

</head>

<jsp:include page="scripts.jsp" />
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
                <c:if test="${user.role ne 'ROLE_ANONYM'}">
                    <li>
                        <a href="${pageContext.request.contextPath}/user">My Room</a>
                    </li>
                </c:if>

                <c:if test="${user.role eq 'ROLE_MANAGER'}">
                    <li>
                        <a href="${pageContext.request.contextPath}/adminOrders">Administration</a>
                    </li>
                </c:if>


            </ul>
            <ul class="nav navbar-nav  navbar-right">

                <c:if test="${user.role eq 'ROLE_ANONYM'}">
                    <li>
                        <a href="${pageContext.request.contextPath}/login">Log in</a>
                    </li>
                </c:if>

                <li>
                    <a href="${pageContext.request.contextPath}/bucket">
                        <i class="fa fa-shopping-cart" style="font-size:16px"></i> Cart</a>
                </li>
                <c:if test="${user.role ne 'ROLE_ANONYM'}">
                    <li >
                        <a href="${pageContext.request.contextPath}/logout">Log out</a>
                    </li>
                </c:if>
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
            console.log(link);
            if (cur_url == link)
            {
                $(this).addClass('active');
            }
        });
    });
</script>