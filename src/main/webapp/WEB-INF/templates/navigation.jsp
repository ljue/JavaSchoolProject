<%--
  Created by IntelliJ IDEA.
  User: Людмила
  Date: 19.07.2017
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="/home">Home</a>
                </li>
                <%--<c:if test="${user.role ne 'ROLE_ANONYM'}">--%>
                    <li>
                        <a href="/user">My Room</a>
                    </li>
                <%--</c:if>--%>
                <%--<c:if test="${user.role eq 'ROLE_ANONYM'}">--%>
                    <li>
                        <a href="/login">Log in</a>
                    </li>
                <%--</c:if>--%>
                <%--<c:if test="${user.role eq 'ROLE_MANAGER'}">--%>
                    <li>
                        <a href="/orderList">Administration</a>
                    </li>
                <%--</c:if>--%>
                <li>
                    <a href="/countries">Tests</a>
                </li>

                <li>
                    <a href="/bucket">Shopping cart</a>
                </li>
                <%--<c:if test="${user.role ne 'ROLE_ANONYM'}">--%>
                    <li>
                        <a href="/logout">Log out</a>
                    </li>
                <%--</c:if>--%>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>