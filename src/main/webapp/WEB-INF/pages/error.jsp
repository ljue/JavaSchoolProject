<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <jsp:include page="../templates/head.jsp"/>
</head>
<body>
<jsp:include page="../templates/navigation.jsp"/>
<jsp:include page="../templates/scripts.jsp"/>
<br>
<br>

<section class="content">
    <div class="container" align="center">
        <h2 align="center"style="color: lightseagreen">Something went wrong on our site</h2>
        <h3 align="center"style="color: dodgerblue">Keep calm and come back later</h3>
        <div style="margin-bottom: 20px"><img src="${pageContext.request.contextPath}/resources/Images/rasswet.jpg"></div>
    </div>
</section>

</body>
</html>
