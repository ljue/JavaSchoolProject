<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>

<head>
    <%--<meta charset="utf-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>

    <title>Countries</title>

        <jsp:include page="../templates/head.jsp" />
</head>
<body>
<jsp:include page="../templates/navigation.jsp" />
<jsp:include page="../templates/scripts.jsp" />


<table class="tg">

    <br>${product.productName}<br>
    <br>${product.productId}<br>
    <br>${product.cost}<br>
    <br>${product.count}<br>
    <br>${product.size}<br>
    <br>${product.distance}<br>
    <%--<br>${product.productCategoryByCategory.categoryName}<br>--%>
    <br>${product.battery}<br>
    <br>${product.flyTime}<br>
    <br>${product.description}<br>

    <c:forEach items="${product.picturesByProductId}" var="pict">
    <img src="../resources/Images/${pict.picName}" class="img-responsive">
    </c:forEach>


    <%--<c:out value="${user.roleByRole.idRole}"></c:out>--%>

    <c:forEach items="${countries}" var="country">
        <tr>
            <td>${country.id}</td>

            <td>${country.name}</td>

        </tr>
    </c:forEach>
</table>


</body>
</html>