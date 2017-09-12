<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<title>Order</title>--%>
</head>
<body>
<jsp:include page="../../templates/navigation.jsp"/>
<br>
<br>

<div class="container">

    <div class="row text-center">
        <br><br>
        <h2 style="color: #337ab7">Success</h2>
        <br>
        <p style="font-size:20px">Thank you for your order.</p>
        <p style="font-size:20px">You could show details in your order history.</p>
        <br>
        <br>


        <div class="form-group">
            <a href="${pageContext.request.contextPath}/catalog" class="btn btn-primary">
                Continue shopping
            </a>
            <a href="${pageContext.request.contextPath}/profile/history" class="btn btn-default">
                Order history
            </a>
        </div>
    </div>
</div>
</body>
</html>
