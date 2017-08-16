<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OrdersList</title>
</head>
<body>
<jsp:include page="../templates/navigation.jsp"/>

<c:url var="editInfo" value="/my-webapp/user/editInfo"/>
<c:url var="editPass" value="/my-webapp/user/editPass"/>
<%--<jsp:include page="/countries" />--%>

<br>
<br>
<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <%--<p class="lead">Личный кабинет</p>--%>
            <p class="lead">   </p>
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/orderList" class="list-group-item">Order list</a>
                <a href="${pageContext.request.contextPath}/statistics" class="list-group-item">Shop statistic</a>
                <a href="${pageContext.request.contextPath}/adminProducts" class="list-group-item">Goods management</a>
            </div>
        </div>

        <div class="col-md-9">
            <div class="row">

                <!-- edit form column -->
                <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
                    <%--<div class="alert alert-info alert-dismissable">--%>
                    <%--<a class="panel-close close" data-dismiss="alert">×</a>--%>
                    <%--<i class="fa fa-coffee"></i>--%>
                    <%--This is an <strong>.alert</strong>. Use this to show important messages to the user.--%>
                    <%--</div>--%>
                    <h3>Order List</h3>





                </div>





            </div>
        </div>



    </div>
</div>

<!-- /.container -->

</body>
</html>
