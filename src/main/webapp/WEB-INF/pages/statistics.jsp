<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Людмила
  Date: 19.07.2017
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistic</title>
    <jsp:include page="../templates/head.jsp"/>
</head>
<body>
<jsp:include page="../templates/navigation.jsp"/>
<jsp:include page="../templates/scripts.jsp"/>

<br>
<br>
<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <%--<p class="lead">Личный кабинет</p>--%>
            <p class="lead"></p>
            <div class="list-group">
                <a href="/adminOrders" class="list-group-item">Order list</a>
                <a href="/statistics" class="list-group-item">Shop statistic</a>
                <a href="/adminProducts" class="list-group-item">Goods management</a>
            </div>
        </div>

        <div class="col-md-9">
            <div class="row">
                <br>
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#panelTopClients">Top clients</a></li>
                    <li><a data-toggle="tab" href="#panelTopGoods">Top goods</a></li>
                    <li><a data-toggle="tab" href="#panelProceed">Proceed</a></li>

                </ul>

                <div class="tab-content">
                    <div id="panelTopClients" class="tab-pane fade in active">

                        <c:if test="${!empty topClients}">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>#Id</th>
                                    <th>Name</th>
                                    <th>Surname</th>
                                    <th>Count</th>
                                    <th>Sum</th>
                                </tr>
                                </thead>
                                <tbody>


                                <c:forEach items="${topClients}" var="client" varStatus="status">
                                    <tr>
                                        <td>${client}</td>
                                        <td>${client}</td>
                                        <td>${client}</td>
                                        <td>${client}</td>
                                        <td>${client}</td>

                                    </tr>

                                </c:forEach>

                                <td></td>
                                <td></td>
                                <td><b>Total:</b></td>
                                <td>${commonPrice}</td>
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty clients}">
                            You haven`t got clients statistic.
                        </c:if>

                    </div>

                    <div id="panelTopGoods" class="tab-pane fade in active">

                        <c:if test="${empty goods}">
                            You haven`t got goods statistic.
                        </c:if>

                    </div>

                    <div id="panelProceed" class="tab-pane fade in active">

                        <c:if test="${empty proceed}">
                            You haven`t got proceed statistic.
                        </c:if>

                    </div>
                </div>
            </div>
        </div>


    </div>
</div>

</body>
</html>
