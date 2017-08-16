<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>Goods management</title>
</head>
<body>
<jsp:include page="../templates/navigation.jsp"/>
<br>
<br>

<div class="container">

    <div class="row">

        <div class="col-md-3">
            <p class="lead"></p>
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/adminOrders" class="list-group-item">Order list</a>
                <a href="${pageContext.request.contextPath}/statistics" class="list-group-item">Shop statistic</a>
                <a href="${pageContext.request.contextPath}/adminProducts" class="list-group-item">Goods management</a>
            </div>
        </div>

        <br>
        <div class="col-md-9">
            <div class="row">
                <ul class="nav nav-tabs">
                    <li><a href="${pageContext.request.contextPath}/adminProducts">Add new goods</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/editCategories">Control categories</a></li>

                </ul>

                <div class="row">
                    <%--<c:url var="edit" value="${pageContext.request.contextPath}/editCategories/editCategoryName"/>--%>

                    <div class="tab-content">
                        <br>

                        <form:form modelAttribute="formEditCategory" method="POST" action="${pageContext.request.contextPath}/editCategories/editCategoryName"
                                   class="form-horizontal">

                            <spring:bind path="categoryName">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-3 control-label">Edit product category:</label>
                                    <div class="col-lg-8">
                                        <form:select path="categoryName" class="form-control">
                                            <c:forEach items="${categories}" var="cat">
                                                <form:option value="${cat}" label="${cat}"></form:option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                    <form:errors path="categoryName"></form:errors>
                                </div>
                            </spring:bind>

                            <spring:bind path="editCategoryName">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-3 control-label"></label>
                                    <div class="col-lg-8">
                                        <form:input type="text" path="editCategoryName" class="form-control"
                                        ></form:input>
                                    </div>
                                    <form:errors path="editCategoryName"></form:errors>
                                </div>
                            </spring:bind>

                            <div class="form-group">
                                <label class="col-md-3 control-label"></label>
                                <div class="col-md-8">
                                    <input class="btn btn-primary" value="Edit" type="submit">
                                    <span></span>
                                    <input class="btn btn-default" value="Cancel" type="reset">
                                </div>
                            </div>

                        </form:form>
                        <br>
                    </div>


                    <div class="tab-content">

                        <%--<c:url var="add" value="/editCategories/addCategory"/>--%>
                        <br>

                        <form:form modelAttribute="formAddCategory" method="POST" action="${pageContext.request.contextPath}/editCategories/addCategory"
                                   class="form-horizontal">

                            <spring:bind path="categoryName">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <label class="col-lg-3 control-label">Add product category:</label>

                                    <div class="col-lg-8">
                                        <form:input type="text" path="categoryName" class="form-control"
                                        ></form:input>
                                    </div>
                                    <form:errors path="categoryName"></form:errors>
                                </div>
                            </spring:bind>

                            <div class="form-group">
                                <label class="col-md-3 control-label"></label>
                                <div class="col-md-8">
                                    <input class="btn btn-primary" value="Add" type="submit">
                                </div>
                            </div>

                        </form:form>
                    </div>
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
