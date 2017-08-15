<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start page</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}../templates/navigation.jsp" />
<br>
<div class="page-flexbox-wrapper">
    <div class="parallax-container">
        <div class="parallax"><img src="${pageContext.request.contextPath}/../resources/Images/zakat.jpg" class="img-responsive"></div>
    </div>
    <div class="row">



    </div>
</div>
<c:out value="${pageContext.request.contextPath}">${pageContext.request.contextPath}</c:out>
<c:out value="${request.contextPath}">${request.contextPath}</c:out>


<p>я здесь${pageContext.request.contextPath}</p>
<p> и здесь ${request.contextPath}</p>

<%--<script>$(document).ready(function () {--%>
    <%--$('.parallax').parallax();--%>
<%--});</script>--%>
</body>
</html>
