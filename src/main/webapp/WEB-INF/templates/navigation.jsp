
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="myContext"/>
<jsp:include page="${pageContext.request.contextPath}/../templates/scripts.jsp"/>
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="${pageContext.request.contextPath}/home">Home</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/catalog">Catalog</a>
                </li>
                <c:if test="${user.role ne 'ROLE_ANONYM'}">
                    <li>
                        <a href="${pageContext.request.contextPath}/user">My Room</a>
                    </li>
                </c:if>
                <c:if test="${user.role eq 'ROLE_ANONYM'}">
                    <li>
                        <a href="${pageContext.request.contextPath}/login">Log in</a>
                    </li>
                </c:if>
                <c:if test="${user.role eq 'ROLE_MANAGER'}">
                    <li>
                        <a href="${pageContext.request.contextPath}/adminOrders">Administration</a>
                    </li>
                </c:if>
                <li>
                    <a href="${pageContext.request.contextPath}/bucket">Shopping cart</a>
                </li>
                <c:if test="${user.role ne 'ROLE_ANONYM'}">
                    <li>
                        <a href="${pageContext.request.contextPath}/logout">Log out</a>
                    </li>
                </c:if>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>