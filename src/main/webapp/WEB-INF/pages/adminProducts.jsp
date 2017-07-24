<%--
  Created by IntelliJ IDEA.
  User: Людмила
  Date: 22.07.2017
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>Goods management</title>
    <jsp:include page="../templates/head.jsp" />
</head>
<body>
<jsp:include page="../templates/navigation.jsp" />
<jsp:include page="../templates/scripts.jsp" />
<br>
<br>


<%--<jsp:include page="/countries" />--%>
<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-md-3">
            <p class="lead">  </p>
            <div class="list-group">
                <a href="/orderList" class="list-group-item">Order list</a>
                <a href="/statistics" class="list-group-item">Shop statistic</a>
                <a href="/adminProducts" class="list-group-item">Goods management</a>
            </div>
        </div>

        <div class="col-md-9">
            <div class="row">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="/adminProducts">Add new goods</a></li>
                    <li><a  href="/editCategories">Control categories</a></li>
                    <%--<li><a data-toggle="tab" href="/editCategories">Control categories</a></li>--%>

                </ul>

                <div class="tab-content">


                    <%--<div id="panel1" class="tab-pane fade in active">--%>
                        <br>
                        <form:form method="POST" enctype="multipart/form-data" modelAttribute="productForm" action="${addProduct}"  class="form-horizontal">

                            <spring:bind path="productName">
                                <div class="form-group ${status.error ? 'has-error' : ''}" >
                                    <label class="col-lg-3 control-label">Goods name:</label>
                                    <div class="col-lg-8">
                                        <form:input type="text" path="productName" class="form-control" placeholder="Goods name"
                                        ></form:input>
                                    </div>
                                    <form:errors path="productName"></form:errors>
                                </div>
                            </spring:bind>

                            <spring:bind path="cost">
                                <div class="form-group ${status.error ? 'has-error' : ''}" >
                                    <label class="col-lg-3 control-label">Cost:</label>
                                    <div class="col-lg-8">
                                        <form:input type="text" path="cost" class="form-control" placeholder="Cost"
                                        ></form:input>
                                    </div>
                                    <form:errors path="cost"></form:errors>
                                </div>
                            </spring:bind>

                            <spring:bind path="count">
                                <div class="form-group ${status.error ? 'has-error' : ''}" >
                                    <label class="col-lg-3 control-label">Count:</label>
                                    <div class="col-lg-8">
                                        <form:input type="text" path="count" class="form-control" placeholder="Count"
                                        ></form:input>
                                    </div>
                                    <form:errors path="count"></form:errors>
                                </div>
                            </spring:bind>


                            <spring:bind path="productCategoryByCategory">
                                <div class="form-group ${status.error ? 'has-error' : ''}" >
                                    <label class="col-lg-3 control-label">Category:</label>
                                    <div class="col-lg-8">
                                        <form:select path="productCategoryByCategory" class="form-control">
                                            <c:forEach items="${categories}" var="cat">
                                                <form:option value="${cat.categoryName}" label="${cat.categoryName}"></form:option>
                                            </c:forEach>
                                            <%--<form:options items="${categories}" itemValue="categoryId"--%>
                                                          <%--itemLabel="categoryName"></form:options>--%>
                                        </form:select>
                                    </div>
                                    <form:errors path="productCategoryByCategory"></form:errors>
                                </div>
                            </spring:bind>
                            <%--itemValue="categoryId"--%>

                            <spring:bind path="size">
                                <div class="form-group ${status.error ? 'has-error' : ''}" >
                                    <label class="col-lg-3 control-label">Size:</label>
                                    <div class="col-lg-8">
                                        <form:input type="text" path="size" class="form-control" placeholder="Size (sm)"
                                        ></form:input>
                                    </div>
                                    <form:errors path="size"></form:errors>
                                </div>
                            </spring:bind>

                            <spring:bind path="battery">
                                <div class="form-group ${status.error ? 'has-error' : ''}" >
                                    <label class="col-lg-3 control-label">Battery:</label>
                                    <div class="col-lg-8">
                                        <form:input type="text" path="battery" class="form-control" placeholder="Battery type, value"
                                        ></form:input>
                                    </div>
                                    <form:errors path="battery"></form:errors>
                                </div>
                            </spring:bind>

                            <spring:bind path="flyTime">
                            <div class="form-group ${status.error ? 'has-error' : ''}" >
                                <label class="col-lg-3 control-label">Fly time:</label>
                                <div class="col-lg-8">
                                    <form:input type="text" path="flyTime" class="form-control" placeholder="Fly time (min)"
                                    ></form:input>
                                </div>
                                <form:errors path="flyTime"></form:errors>
                            </div>
                        </spring:bind>

                            <spring:bind path="distance">
                                <div class="form-group ${status.error ? 'has-error' : ''}" >
                                    <label class="col-lg-3 control-label">Distance:</label>
                                    <div class="col-lg-8">
                                        <form:input type="text" path="distance" class="form-control" placeholder="Distance (m)"
                                        ></form:input>
                                    </div>
                                    <form:errors path="distance"></form:errors>
                                </div>
                            </spring:bind>

                            <c:forEach items="${propertiesMany}" var="property">
                                <div class="form-group" >
                                    <label class="col-lg-3 control-label">${property.propCatName}:</label>
                                    <div class="col-lg-8">
                                        <c:forEach items="${propertyManyChild}" var="propChild">
                                            <c:if test="${property eq propChild.propertyCategoryByProdPropCatId}">
                                                <form:checkbox path="properties"
                                                value="${propChild.prodPropName}"
                                                label="${propChild.prodPropName}"></form:checkbox>
                                                <br>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </div>

                            </c:forEach>


                            <%--<c:forEach items="${radioCategory}" var="radio">--%>
                                <%--<div class="form-group" >--%>
                                    <%--<label class="col-lg-3 control-label">${radio.name}</label>--%>
                                    <%--<div class="col-lg-8">--%>
                                        <%--<c:forEach items="${radioProperties}" var="radioChild">--%>
                                            <%--<c:if test="${radio eq radioChild.propertyRadioCategoryByRadioCategoryId}">--%>
                                                <%--<form:radiobutton path="radioProperties"--%>
                                                               <%--value="${radioChild.id}" label="${radioChild.name}">--%>
                                                <%--</form:radiobutton>--%>
                                                <%--&lt;%&ndash;проблема в path&ndash;%&gt;--%>
                                                <%--<br>--%>
                                            <%--</c:if>--%>
                                        <%--</c:forEach>--%>
                                    <%--</div>--%>
                                <%--</div>--%>

                            <%--</c:forEach>--%>

                            <%--Нужный блок, но в дебаггере видно странную ошибку(не понимаю как работают связи)--%>
                            <%--<h4>Choose one item in each block:</h4><br>--%>
                            <%--<c:forEach items="${radioCategory}" var="radio">--%>
                                <%--<div class="form-group" >--%>
                                    <%--<label class="col-lg-3 control-label">${radio.name}:</label>--%>
                                    <%--<div class="col-lg-8">--%>
                                        <%--<c:forEach items="${radioProperties}" var="radioChild">--%>
                                            <%--<c:if test="${radio eq radioChild.propertyRadioCategoryByRadioCategoryId}">--%>
                                                <%--<form:checkbox path="radioProperties"--%>
                                                                  <%--value="${radioChild.name}" label="${radioChild.name}"></form:checkbox>--%>
                                                <%--&lt;%&ndash;проблема в path&ndash;%&gt;--%>
                                                <%--<br>--%>
                                            <%--</c:if>--%>
                                        <%--</c:forEach>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</c:forEach>--%>

                            <spring:bind path="description">
                                <div class="form-group ${status.error ? 'has-error' : ''}" >
                                    <label class="col-lg-3 control-label">Description:</label>
                                    <div class="col-lg-8">
                                        <form:textarea  path="description" class="form-control" placeholder="Add description less 500 characters"
                                        ></form:textarea>
                                    </div>
                                    <form:errors path="description"></form:errors>
                                </div>
                            </spring:bind>

                            <div class="form-group" >
                                <label class="col-lg-3 control-label">Add picture:</label>
                                <div class="col-lg-8">
                                    <input type="file" name="images" multiple="multiple"/>
                                </div>
                            </div>


                            <%--<spring:bind path="images">--%>
                                <%--<div class="form-group ${status.error ? 'has-error' : ''}" >--%>
                                    <%--<label class="col-lg-3 control-label">Images:</label>--%>
                                    <%--<div class="col-lg-8">--%>
                                        <%--<form:input path="images" type="file" multiple="true"></form:input>--%>

                                    <%--</div>--%>
                                    <%--<form:errors path="images"></form:errors>--%>
                                <%--</div>--%>
                            <%--</spring:bind>--%>



                            <%--<spring:bind path="login">--%>
                                <%--<div class="form-group ${status.error ? 'has-error' : ''}" >--%>
                                    <%--<label class="col-lg-3 control-label">Login:</label>--%>
                                    <%--<div class="col-lg-8">--%>
                                        <%--<form:input type="text" path="login" class="form-control" value="${user.login}"--%>
                                        <%--></form:input>--%>
                                    <%--</div>--%>
                                    <%--<form:errors path="login"></form:errors>--%>
                                <%--</div>--%>
                            <%--</spring:bind>--%>
                            



                            <div class="form-group">
                                <label class="col-md-3 control-label"></label>
                                <div class="col-md-8">
                                    <input class="btn btn-primary" value="Add goods" type="submit">
                                    <span></span>
                                    <input class="btn btn-default" value="Cancel" type="reset">
                                </div>
                            </div>

                        </form:form>
                    <%--</div>--%>




                </div>
            </div>
        </div>


    </div>

</div>

</div>
<!-- /.container -->

</body>
</html>
