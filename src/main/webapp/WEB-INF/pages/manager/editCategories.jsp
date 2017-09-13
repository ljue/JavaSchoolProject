<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
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
                <a href="${pageContext.request.contextPath}/management/adminProducts" class="list-group-item">Goods management</a>
                <a href="${pageContext.request.contextPath}/management/editCategories"
                   class="list-group-item active-list-group-item">Catalog management</a>
            </div>
        </div>

        <br>
        <div class="col-md-9">
            <div class="row">
                <ul class="nav nav-tabs">
                    <%--<li><a href="${pageContext.request.contextPath}/adminProducts">Add new goods</a></li>--%>
                    <li class="active"><a href="${pageContext.request.contextPath}/management/editCategories">Manage
                        categories</a></li>
                    <li><a href="${pageContext.request.contextPath}/management/editPropertyGroups">Manage property groups</a></li>
                    <li><a href="${pageContext.request.contextPath}/management/editProperties">Manage properties</a></li>
                </ul>

                <div class="row">
                    <c:if test="${!empty categories}">
                        <div class="tab-content">
                            <br>


                            <spring:form modelAttribute="formEditCategory" method="POST"
                                         action="${pageContext.request.contextPath}/management/editCategories/editCategoryName"
                                         class="form-horizontal">

                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Edit product category:</label>
                                    <div class="col-lg-6">
                                        <form:select path="categoryName" class="form-control">
                                            <c:forEach items="${categories}" var="cat">
                                                <form:option value="${cat}" label="${cat}"></form:option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-lg-3 control-label"></label>
                                    <div class="col-lg-6">
                                        <form:input required="required" type="text" path="editCategoryName"
                                                    class="form-control" placeholder="New name for category"
                                        ></form:input>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-3 control-label"></label>
                                    <div class="col-md-6">
                                        <input class="btn btn-primary" value="Edit" type="submit"/>
                                        <span></span>
                                        <input class="btn btn-default" value="Cancel" type="reset"/>
                                    </div>
                                </div>
                            </spring:form>
                        </div>
                    </c:if>

                    <div class="tab-content">
                        <br>
                        <spring:form modelAttribute="formAddCategory" method="POST" id="form-add-category"
                                     action="${pageContext.request.contextPath}/management/editCategories/addCategory"
                                     class="form-horizontal">

                            <div class="form-group">
                                <label class="col-lg-3 control-label">Add product category:</label>

                                <div class="col-lg-6">
                                    <form:input required="required" type="text" path="addCategoryName"
                                                class="form-control" id="add-category-input" placeholder="Category name"
                                    ></form:input>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-3 control-label"></label>
                                <div class="col-md-6">
                                    <input id="add-new-category-product" class="btn btn-primary" value="Add"
                                           type="submit">
                                </div>
                            </div>
                        </spring:form>
                    </div>

                    <c:if test="${!empty categoriesForRemove}">
                        <div class="tab-content">
                            <br>
                            <spring:form method="POST" modelAttribute="formRemoveCategory"
                                         action="${pageContext.request.contextPath}/management/editCategories/removeCategory"
                                         class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Remove product category:</label>
                                    <div class="col-lg-6">
                                        <form:select class="form-control" path="removeCategoryName">
                                            <c:forEach items="${categoriesForRemove}" var="cat">
                                                <form:option value="${cat}" label="${cat}"></form:option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"></label>
                                    <div class="col-md-6">
                                        <input type="submit" value="Remove" class="btn btn-primary"/>
                                    </div>
                                </div>
                            </spring:form>
                        </div>
                    </c:if>

                    <c:if test="${!empty removedCategories}">
                        <div class="tab-content">
                            <br>
                            <spring:form method="POST" modelAttribute="formReturnCategory"
                                         action="${pageContext.request.contextPath}/management/editCategories/returnCategory"
                                         class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Return product category:</label>
                                    <div class="col-lg-6">
                                        <form:select class="form-control" path="returnCategoryName">
                                            <c:forEach items="${removedCategories}" var="cat">
                                                <form:option value="${cat}" label="${cat}"></form:option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"></label>
                                    <div class="col-md-6">
                                        <input type="submit" value="Return" class="btn btn-primary"/>
                                    </div>
                                </div>
                            </spring:form>
                        </div>
                    </c:if>
                </div>

            </div>
        </div>
    </div>


</div>

</div>

</div>
<!-- /.container -->

<div id="message-fail-add-category" class="my-message-success alert alert-danger">
    <p style="font-size: 1.1em">Category with such name already exists.</p>
</div>

<script>
    $("#add-new-category-product").click(function (e) {
        var form = $("#add-category-input").val();
        if (form.replace(/\s/g, "")) {
            e.preventDefault();
            $.ajax({
                type: "POST",
                data: {addCategoryName: form},
                url: "${pageContext.request.contextPath}/management/editCategories/checkExisting",
                success: function (resp) {
                    if (resp) {
                        $("#message-fail-add-category").fadeIn(500);
                        setTimeout(function () {
                            $("#message-fail-add-category").fadeOut(1000)
                        }, 2000);
                    } else {
                        $("#form-add-category").submit();
                    }
                }
            })
        }
    })
</script>
</body>
</html>
