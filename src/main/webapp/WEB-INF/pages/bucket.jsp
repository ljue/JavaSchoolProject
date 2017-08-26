<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bucket</title>
    <style>
        tbody > tr {
            cursor: pointer;
        }
    </style>
</head>
<body>
<jsp:include page="../templates/navigation.jsp"/>
</div>
<div class="container">

    <br>
    <br>

    <h1><i class="fa fa-shopping-cart"></i> Shopping Cart </h1>

    <hr>
    <div id="products-in-bucket">
        <jsp:include page="bucketInto.jsp"/>
    </div>


</div>


</body>
</html>
