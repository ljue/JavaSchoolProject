<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <%--<title>Goods management</title>--%>
</head>
<body>
<jsp:include page="../../templates/navigation.jsp"/>
<br>
<br>

<div class="container">

    <div class="row">

        <div class="col-md-3">
            <p class="lead"></p>
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/management/adminOrders" class="list-group-item">Order list</a>
                <a href="${pageContext.request.contextPath}/management/statistics" class="list-group-item">Shop statistic</a>
                <a href="${pageContext.request.contextPath}/management/adminProducts"
                   class="list-group-item active-list-group-item">Goods management</a>
                <a href="${pageContext.request.contextPath}/management/editCategories" class="list-group-item">Catalog management</a>
            </div>
        </div>

        <div class="col-md-9">
            <div class="row">
                <%--<br>--%>
                <%--<ul class="nav nav-tabs">--%>
                    <%--<li class="active"><a href="${pageContext.request.contextPath}/adminProducts">Add new goods</a></li>--%>
                    <%--&lt;%&ndash;<li><a href="${pageContext.request.contextPath}/editCategories">Control categories</a></li>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<li><a href="${pageContext.request.contextPath}/editPropertyGroups">Control property groups</a></li>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<li><a href="${pageContext.request.contextPath}/editProperties">Control properties</a></li>&ndash;%&gt;--%>

                <%--</ul>--%>


                <%--<div class="tab-content">--%>
                    <%--<br><br>--%>
                    <form:form method="POST" enctype="multipart/form-data" modelAttribute="productForm"
                               action="${pageContext.request.contextPath}/management/addProduct" class="form-horizontal">

                        <div class="form-group">
                            <div class="col-lg-2"></div>
                            <h3 class="col-lg-8">Add goods:</h3>
                        </div>
                        <spring:bind path="productName">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="col-lg-2 control-label">Goods name:</label>
                                <div class="col-lg-8">
                                    <form:input required="required" type="text" path="productName" class="form-control"
                                                placeholder="Goods name"
                                    ></form:input>
                                </div>
                                <form:errors path="productName"></form:errors>
                            </div>
                        </spring:bind>

                        <spring:bind path="cost">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="col-lg-2 control-label">Cost:</label>
                                <div class="col-lg-8">
                                    <form:input required="required" type="text" path="cost" class="form-control" placeholder="Cost"
                                    ></form:input>
                                </div>
                                <form:errors path="cost"></form:errors>
                            </div>
                        </spring:bind>

                        <spring:bind path="count">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="col-lg-2 control-label">Count:</label>
                                <div class="col-lg-8">
                                    <form:input required="required" type="text" pattern="[0-9]{1,4}" path="count" class="form-control" placeholder="Count"
                                    ></form:input>
                                </div>
                                <form:errors path="count"></form:errors>
                            </div>
                        </spring:bind>


                        <spring:bind path="category">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="col-lg-2 control-label">Category:</label>
                                <div class="col-lg-8">
                                    <form:select path="category" class="form-control">
                                        <c:forEach items="${categories}" var="cat">
                                            <form:option value="${cat}"
                                                         label="${cat}"></form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                <form:errors path="category"></form:errors>
                            </div>
                        </spring:bind>

                        <spring:bind path="size">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="col-lg-2 control-label">Size:</label>
                                <div class="col-lg-8">
                                    <form:input required="required" type="text" path="size" class="form-control" placeholder="Size (cm)"
                                    ></form:input>
                                </div>
                                <form:errors path="size"></form:errors>
                            </div>
                        </spring:bind>

                        <spring:bind path="battery">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="col-lg-2 control-label">Battery:</label>
                                <div class="col-lg-8">
                                    <form:input type="text" path="battery" class="form-control"
                                                placeholder="Battery type, value"
                                    ></form:input>
                                </div>
                                <form:errors path="battery"></form:errors>
                            </div>
                        </spring:bind>

                        <spring:bind path="flyTime">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="col-lg-2 control-label">Fly time:</label>
                                <div class="col-lg-8">
                                    <form:input type="text"  pattern="[0-9]{0,4}" path="flyTime" class="form-control"
                                                placeholder="Fly time (minutes)"
                                    ></form:input>
                                </div>
                                <form:errors path="flyTime"></form:errors>
                            </div>
                        </spring:bind>

                        <spring:bind path="distance">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="col-lg-2 control-label">Distance:</label>
                                <div class="col-lg-8">
                                    <form:input type="text"  pattern="[0-9]{0,4}" path="distance" class="form-control"
                                                placeholder="Distance (m)"
                                    ></form:input>
                                </div>
                                <form:errors path="distance"></form:errors>
                            </div>
                        </spring:bind>


                        <c:forEach items="${propertiesNotSolo}" var="properties">
                            <div class="form-group">
                                <label class="col-lg-2 control-label">${properties.key}:</label>
                                <div class="col-lg-8">
                                    <c:forEach items="${properties.value}" var="currentProperty">
                                            <form:checkbox path="saveProperties"
                                                           value="${currentProperty}" label="${currentProperty}"
                                            ></form:checkbox><br>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:forEach>


                        <c:forEach items="${propertiesSolo}" var="properties">
                            <div class="form-group">
                                <label class="col-lg-2 control-label">${properties.key}:</label>
                                <div class="col-lg-8">
                                    <form:select path="saveProperties" class="form-control">
                                        <c:forEach items="${properties.value}" var="property">
                                            <form:option value="${property}" label="${property}"></form:option>
                                        </c:forEach>
                                    </form:select>
                                    <br>
                                </div>
                            </div>
                        </c:forEach>

                        <spring:bind path="description">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="col-lg-2 control-label">Description:</label>
                                <div class="col-lg-8">
                                    <form:textarea path="description" class="form-control" style="min-height:200px;"
                                                   placeholder="Add description less 2000 characters"
                                    ></form:textarea>
                                </div>
                                <form:errors path="description"></form:errors>
                            </div>
                        </spring:bind>

                        <spring:bind path="images">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <label class="col-lg-2 control-label">Add picture:</label>
                                <div class="col-lg-8">
                                    <input type="file" name="images" multiple="multiple"/>
                                </div>
                                <div class="has-error">${picExistsMsg}</div>
                                <form:errors path="images"></form:errors>
                            </div>
                        </spring:bind>


                        <div class="form-group">
                            <label class="col-md-2 control-label"></label>
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

</body>
</html>
