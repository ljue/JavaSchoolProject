<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <jsp:include page="../templates/head.jsp"/>
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
<jsp:include page="../templates/navigation.jsp"/>
<jsp:include page="../templates/scripts.jsp"/>
<br>
<br>

<section class="content">
    <div class="container" align="center">
        <%--lightseagreen dodgerblue--%>
        <h2 align="center"style="color: white">Something went wrong on our site</h2>
        <h3 align="center"style="color: white">Keep calm and come back later</h3>
        <%--<div style="margin-bottom: 20px"><img src="${pageContext.request.contextPath}/resources/Images/rasswet.jpg"></div>--%>
    </div>
</section>

</body>
</html>
