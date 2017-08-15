<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Catalog</title>
    <jsp:include page="../templates/head.jsp"/>
</head>
<body>
<jsp:include page="../templates/navigation.jsp"/>
<jsp:include page="../templates/scripts.jsp"/>

<div class="container">
    <br>
    <br>
    <br>
    <div class="row">

        <div class="col-md-3">
            <div class="row">
                <div class="list-group">

                    <a href="${pageContext.request.contextPath}/catalog/All" class="list-group-item">All goods</a>

                    <c:if test="${!empty categories}">
                        <c:forEach var="category" items="${categories}">
                            <a href="/catalog/${category}"
                               class="list-group-item">${category}</a>
                        </c:forEach>
                    </c:if>
                </div>

                <sping:form modelAttribute="filter" action="${pageContext.request.contextPath}/catalog/doFilter" method="post"
                class="form-horizontal">
                    <label>Cost:</label>
                    <div class="form-group">
                        <div class="col-lg-5">
                            <form:input path="costFROM" class="form-control"></form:input>
                        </div>
                        <label class="col-lg-1">-</label>
                        <div class="col-lg-5">
                            <form:input path="costTO" class="form-control"></form:input>
                        </div>
                    </div>

                    <label>Fly time:</label>
                    <div class="form-group">
                        <div class="col-lg-5">
                        <form:input path="flyTimeFROM" class="form-control"></form:input>
                        </div>
                        <label class="col-lg-1">-</label>
                        <div class="col-lg-5">
                        <form:input path="flyTimeTO" class="form-control"></form:input>
                        </div>
                    </div>

                    <label>Distance:</label>
                    <div class="form-group">
                        <div class="col-lg-5">
                        <form:input path="distanceFROM" class="form-control"></form:input>
                        </div>
                        <label class="col-lg-1">-</label>
                        <div class="col-lg-5">
                        <form:input path="distanceTO" class="form-control"></form:input>
                        </div>
                    </div>

                    <c:forEach items="${allProperties}" var="propertyGroup">

                            <label>${propertyGroup.key}:</label><br>
                        <div class="form-group">
                            <div class="col-lg-8">
                                <c:forEach items="${propertyGroup.value}" var="currentProperty">
                                <form:checkbox path="properties"
                                               value="${currentProperty}" label="  ${currentProperty}"
                                ></form:checkbox><br>
                                </c:forEach>
                            <br>
                            </div>
                            </div>
                        </c:forEach>

                    <div class="form-group">
                        <div class="col-md-8">
                            <input class="btn btn-primary" value="Apply" type="submit">
                            <input class="btn btn-default" value="Cancel" type="reset">
                        </div>
                    </div>

                </sping:form>

            </div>
        </div>


        <div class="col-md-9">

            <div class="row">
                <div class="catalog-products-by-category">
                    <div class="container-my-mini">
                    <div class="row">
                        <jsp:include page="${pageContext.request.contextPath}/catalogProducts.jsp"/>
                    </div>
                    </div>
                </div>
            </div>
        </div>


    </div><!-------container----->

    <%--<script>--%>
    <%--$(".changeListProducts").click(--%>
    <%--function sortProducts(obj) {--%>
    <%--var cat = obj.value;--%>
    <%--$.ajax({--%>
    <%--type: "POST",--%>
    <%--url: "/catalog/" + cat,--%>
    <%--success: function (response) {--%>
    <%--alert(response);--%>
    <%--$(".catalog-products-by-category").html(response);--%>

    <%--}--%>
    <%--})--%>
    <%--})--%>
    <%--</script>--%>
</body>
</html>
