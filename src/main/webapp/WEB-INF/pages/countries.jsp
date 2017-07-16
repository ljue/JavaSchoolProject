<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>


</head>
<body>

<table class="tg">

    <c:forEach items="${countries}" var="country">
        <tr>
            <td>${country.id}</td>

            <td>${cointry.name}</td>

        </tr>
    </c:forEach>
</table>


</body>
</html>