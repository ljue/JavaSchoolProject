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
                <%--<c:if test="${user.roleByRole.idRole gt 0}">--%>
                    <li>
                        <a href="/room">Личный кабинет</a>
                    </li>
                <%--</c:if>--%>
                <%--<c:if test="${user.Role.IdRole gt 1}">--%>
                    <li>
                        <a href="/login">Log in</a>
                    </li>
                <%--</c:if>--%>
                <%--<c:if test="${user.roleByRole.idRole eq 0}">--%>
                    <li>
                        <a href="/statistics">Cтатистика</a>
                    </li>
                <%--</c:if>--%>
                <%--<c:if test="${user.roleByRole.idRole gt 0}">&ndash;%&gt;--%>
                    <li>
                        <a href="/room">Личный кабинет</a>
                    </li>
                <%--</c:if>&ndash;%&gt;--%>
                <li>
                    <a href="/countries">Tests</a>
                </li>

                <li>
                    <a href="/bucket">Корзина</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

