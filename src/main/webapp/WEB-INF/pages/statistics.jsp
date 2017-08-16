<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistic</title>
</head>
<body>
<jsp:include page="../templates/navigation.jsp"/>

<br>
<br>
<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <%--<p class="lead">Личный кабинет</p>--%>
            <p class="lead"></p>
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/adminOrders" class="list-group-item">Order list</a>
                <a href="${pageContext.request.contextPath}/statistics" class="list-group-item">Shop statistic</a>
                <a href="${pageContext.request.contextPath}/adminProducts" class="list-group-item">Goods management</a>
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

                        <c:if test="${!empty topClients}"> <br>
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>#Id</th>
                                    <th>Name</th>
                                    <th>Surname</th>
                                    <th>Count goods</th>
                                    <th>Total</th>
                                </tr>
                                </thead>
                                <tbody>


                                <c:forEach items="${topClients}" var="client" varStatus="status">
                                    <tr>
                                        <td>${client.id}</td>
                                        <td>${client.firstName}</td>
                                        <td>${client.secondName}</td>
                                        <td>${client.sumCountProducts}</td>
                                        <td>${client.sumTotal}</td>

                                    </tr>

                                </c:forEach>

                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty topClients}"> <br>
                            You haven`t got clients statistic.
                        </c:if>

                    </div>

                    <div id="panelTopGoods" class="tab-pane fade">

                        <c:if test="${empty topProducts}"> <br>
                            You haven`t got goods statistic.
                        </c:if>
                        <c:if test="${!empty topProducts}"> <br>
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>#Id</th>
                                    <th>Name</th>
                                    <th>Cost</th>
                                    <th>Sales</th>
                                </tr>
                                </thead>
                                <tbody>


                                <c:forEach items="${topProducts}" var="product">
                                    <tr>
                                        <td>${product.productId}</td>
                                        <td>${product.productName}</td>
                                        <td>${product.cost}</td>
                                        <td>${product.sumCount}</td>

                                    </tr>

                                </c:forEach>

                                </tbody>
                            </table>
                        </c:if>

                    </div>

                    <div id="panelProceed" class="tab-pane fade"> <br>

                        <div class="form-group">
                            <label class="col-md-3">Proceed for a week:</label>
                            <label class="col-md-8">
                                <%--<c:if test="${weekProceed eq 0}">--%>
                                    <%--You haven`t got week proceed statistic.--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${weekProceed ne 0}">--%>
                                    ${weekProceed}
                                <%--</c:if>--%>
                            </label> <br>
                        </div>
                        <br>
                        <div class="form-group">
                            <label class="col-md-3">Proceed for a month:</label>
                            <label class="col-md-8">
                                <%--<c:if test="${monthProceed eq 0}">--%>
                                    <%--You haven`t got month proceed statistic.--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${monthProceed ne 0}">--%>
                                    ${monthProceed}
                                <%--</c:if>--%>
                            </label><br>
                        </div>


                    </div>
                </div>
            </div>
        </div>


    </div>
</div>

</body>
</html>
