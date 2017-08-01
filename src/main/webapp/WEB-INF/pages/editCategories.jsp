<%--
  Created by IntelliJ IDEA.
  User: Людмила
  Date: 24.07.2017
  Time: 11:38
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
                <a href="/adminOrders" class="list-group-item">Order list</a>
                <a href="/statistics" class="list-group-item">Shop statistic</a>
                <a href="/adminProducts" class="list-group-item">Goods management</a>
            </div>
        </div>

        <div class="col-md-9">
            <div class="row">
                <ul class="nav nav-tabs">
                    <li ><a  href="/adminProducts">Add new goods</a></li>
                    <li class="active"><a href="/editCategories">Control categories</a></li>

                </ul>

                <div class="row">
                <c:url var="edit" value="/editCategories/editCategory"/>

                <div class="tab-content">
                    <%--<div class="tab-pane fade">--%>
                        <br>

                        <form:form modelAttribute="formEditCategory"  method="POST" action="${edit}" class="form-horizontal">

                            <spring:bind path="chooseCategory">
                                <div class="form-group ${status.error ? 'has-error' : ''}" >
                                    <label class="col-lg-3 control-label">Edit product category:</label>
                                    <div class="col-lg-8">
                                        <form:select path="chooseCategory.categoryName" class="form-control">
                                            <c:forEach items="${categories}" var="cat">
                                                <form:option value="${cat.categoryName}" label="${cat.categoryName}"></form:option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                    <form:errors path="chooseCategory"></form:errors>
                                </div>
                            </spring:bind>

                            <spring:bind path="editCategory">
                                <div class="form-group ${status.error ? 'has-error' : ''}" >
                                    <label class="col-lg-3 control-label"></label>
                                    <div class="col-lg-8">
                                        <form:input type="text" path="editCategory" class="form-control"
                                        ></form:input>
                                    </div>
                                    <form:errors path="editCategory"></form:errors>
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
                        <%--<c:if test="${!empty categories}">--%>
                        <%--<form:form modelAttribute="categories" action="editCategory" method="post">--%>
                        <%--<c:forEach items="${categories}" var="cat" varStatus="status">--%>
                        <%--<div class="form-group" >--%>
                        <%--<div class="col-lg-6">--%>

                        <%--<form:input path="categories[${varStatus.index}].categoryName"--%>
                        <%--type="text" class="form-control" value="${cat.categoryName}"></form:input>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-2">--%>
                        <%--<input class="btn btn-primary" value="Edit" type="submit">--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--<br><br>--%>

                        <%--</c:forEach>--%>
                        <%--</form:form>--%>
                        <%--</c:if>--%>

                        <%--<c:if test="${!empty categories}">--%>
                        <%--<form:form modelAttribute="formCategories" action="editCategory" method="post">--%>
                        <%--<c:forEach items="${formCategories.productCategoryEntityList}" var="productCategoryEntityList" varStatus="status">--%>
                        <%--&lt;%&ndash;<div class="form-group" >&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<div class="col-lg-6">&ndash;%&gt;--%>

                        <%--&lt;%&ndash;&lt;%&ndash;<form:input path="cat[${status.index}]."&ndash;%&gt;&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<form:input path="productCategoryEntityList[${status.index}].categoryName"&ndash;%&gt;--%>

                        <%--&lt;%&ndash;type="text" class="form-control" value="${cat.categoryName}"></form:input>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<div class="col-md-2">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<input class="btn btn-primary" value="Edit" type="submit">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<br><br>&ndash;%&gt;--%>

                        <%--</c:forEach>--%>
                        <%--</form:form>--%>
                        <%--</c:if>--%>



                    <div class="tab-content">

                        <c:url var="add" value="/editCategories/addCategory"/>
                        <br>

                        <form:form modelAttribute="formNewCategory"  method="POST" action="${add}" class="form-horizontal">

                            <spring:bind path="categoryName">
                                <div class="form-group ${status.error ? 'has-error' : ''}" >
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
                                    <%--<span></span>--%>
                                    <%--<input class="btn btn-default" value="Cancel" type="reset">--%>
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

</div>

</div>
<!-- /.container -->

</body>
</html>
