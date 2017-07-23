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
                    <li class="active"><a data-toggle="tab" href="#panel1">Add new goods</a></li>
                    <li><a data-toggle="tab" href="#panel2">Control categories</a></li>

                </ul>

                <div class="tab-content">

                    <div id="panel1" class="tab-pane fade in active">
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
                                            <%--<c:forEach items="${categories}" var="cat">--%>
                                                <%--<form:option value="${cat.categoryName}" label="${cat.categoryName}"></form:option>--%>
                                            <%--</c:forEach>--%>
                                            <form:options items="${categories}" itemValue="categoryId"
                                                          itemLabel="categoryName"></form:options>
                                        </form:select>
                                    </div>
                                    <form:errors path="productCategoryByCategory"></form:errors>
                                </div>
                            </spring:bind>
                            <%--itemValue="categoryId"--%>

                            <c:forEach items="${propertiesMany}" var="property">
                                <div class="form-group" >
                                    <label class="col-lg-3 control-label">${property.propCatName}:</label>
                                    <div class="col-lg-8">
                                        <c:forEach items="${propertyManyChild}" var="propChild">
                                            <c:if test="${property eq propChild.propertyCategoryByProdPropCatId}">
                                                <form:checkbox path="radioProperties"
                                                value="${propChild.prodPropId}"
                                                label="${propChild.prodPropName}"></form:checkbox>
                                                <br>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </div>
                                
                            </c:forEach>


                            <c:forEach items="${radioCategory}" var="radio">
                                <div class="form-group" >
                                    <label class="col-lg-3 control-label">${radio.name}</label>
                                    <div class="col-lg-8">
                                        <c:forEach items="${radioProperties}" var="radioChild">
                                            <c:if test="${radio eq radioChild.propertyRadioCategoryByRadioCategoryId}">
                                                <form:radiobutton path="radioProperties"
                                                               value="${radioChild.id}" label="${radioChild.name}">
                                                </form:radiobutton>
                                                <%--проблема в path--%>
                                                <br>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </div>

                            </c:forEach>

                            <h4>Choose one item in each block:</h4><br>
                            <c:forEach items="${radioCategory}" var="radio">
                                <div class="form-group" >
                                    <label class="col-lg-3 control-label">${radio.name}:</label>
                                    <div class="col-lg-8">
                                        <c:forEach items="${radioProperties}" var="radioChild">
                                            <c:if test="${radio eq radioChild.propertyRadioCategoryByRadioCategoryId}">
                                                <form:checkbox path="radioProperties"
                                                                  value="${radioChild.id}" label="${radioChild.name}"></form:checkbox>
                                                <%--проблема в path--%>
                                                <br>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </div>
                            </c:forEach>

                            <div class="form-group" >
                                <label class="col-lg-3 control-label">Add picture:</label>
                                <div class="col-lg-8">
                                    <input type="file" name="images" multiple="multiple"/>
                                </div>
                            </div>



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
                    </div>


                    <div id="panel2" class="tab-pane fade">
                        <br>
                            <jsp:include page="../content/manageCategories.jsp" />
                    </div>

                </div>
            </div>
        </div>


    </div>

</div>

</div>
<!-- /.container -->

</body>
</html>
