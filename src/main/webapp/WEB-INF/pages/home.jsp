<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start page</title>
<style>
    body {
    background: url(${pageContext.request.contextPath}/resources/Images/zakat.jpg) no-repeat;
    -moz-background-size: 100%; /* Firefox 3.6+ */
    -webkit-background-size: 100%; /* Safari 3.1+ и Chrome 4.0+ */
    -o-background-size: 100%; /* Opera 9.6+ */
    background-size: 100%; /* Современные браузеры */
    }
</style>
</head>
<body>
<jsp:include page="../templates/navigation.jsp" />
<div class="page-flexbox-wrapper">
    <%--<div class="parallax-container">--%>
        <%--<div class="parallax"><img src="resources/Images/zakat.jpg" class="img-responsive"></div>--%>
    <%--</div>--%>
    <div class="row">



    </div>
</div>
<%--<script>$(document).ready(function () {--%>
    <%--$('.parallax').parallax();--%>
<%--});</script>--%>
</body>
</html>
