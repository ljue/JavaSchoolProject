<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">

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
                    <li><a href="${pageContext.request.contextPath}/management/editCategories">Manage categories</a></li>
                    <li><a href="${pageContext.request.contextPath}/management/editPropertyGroups">Manage
                        property groups</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/management/editProperties">Manage
                        properties</a></li>

                </ul>

                <div class="row">
                    <c:if test="${!empty properties}">
                        <div class="tab-content">
                            <br>


                            <form:form modelAttribute="formEditProperty" method="POST"
                                       action="${pageContext.request.contextPath}/management/editProperties/editProperty"
                                       class="form-horizontal">

                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Edit property:</label>
                                    <div class="col-lg-6">
                                        <form:select path="current" class="form-control">
                                            <c:forEach items="${properties}" var="prop">
                                                <form:option value="${prop}" label="${prop}"></form:option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-lg-3 control-label"></label>
                                    <div class="col-lg-6">
                                        <form:input required="required" type="text" path="edit"
                                                    class="form-control" placeholder="New name for property"
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
                            </form:form>
                        </div>
                    </c:if>

                    <div class="tab-content">
                        <br>
                        <form:form modelAttribute="formAddProperty" method="POST" id="form-add-property"
                                   action="${pageContext.request.contextPath}/management/editProperties/addProperty"
                                   class="form-horizontal">

                            <div class="form-group">
                                <label class="col-lg-3 control-label">Add property to group:</label>
                                <div class="col-lg-6">
                                    <form:select path="type" class="form-control">
                                        <c:forEach items="${propertyGroups}" var="prop">
                                            <form:option value="${prop}" label="${prop}"></form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-lg-3 control-label"></label>
                                <div class="col-lg-6">
                                    <form:input required="required" type="text" path="add" placeholder="Property name"
                                                class="form-control" id="add-property-input"
                                    ></form:input>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-3 control-label"></label>
                                <div class="col-md-6">
                                    <input id="add-new-property-btn" class="btn btn-primary" value="Add"
                                           type="submit">
                                </div>
                            </div>
                        </form:form>
                    </div>

                    <c:if test="${!empty propertiesForRemove}">
                        <div class="tab-content">
                            <br>
                            <form:form method="POST" modelAttribute="formRemoveProperty"
                                       action="${pageContext.request.contextPath}/management/editProperties/removeProperty"
                                       class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Remove property:</label>
                                    <div class="col-lg-6">
                                        <form:select class="form-control" path="remove">
                                            <c:forEach items="${propertiesForRemove}" var="prop">
                                                <form:option value="${prop}" label="${prop}"></form:option>
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
                            </form:form>
                        </div>
                    </c:if>

                    <c:if test="${!empty removedProperties}">
                        <div class="tab-content">
                            <br>
                            <form:form method="POST" modelAttribute="formReturnProperty"
                                       action="${pageContext.request.contextPath}/management/editProperties/returnProperty"
                                       class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Return property:</label>
                                    <div class="col-lg-6">
                                        <form:select class="form-control" path="returns">
                                            <c:forEach items="${removedProperties}" var="prop">
                                                <form:option value="${prop}" label="${prop}"></form:option>
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
                            </form:form>
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

<div id="message-fail-add-property" class="my-message-success alert alert-danger">
    <p style="font-size: 1.1em">Error. May be such property group was removed later.</p>
</div>

<script>
    $("#add-new-property-btn").click(function (e) {
        var form = $("#add-property-input").val();
        if (form.replace(/\s/g, "")) {
            e.preventDefault();
            $.ajax({
                type: "POST",
                data: {add : form},
                url: "${pageContext.request.contextPath}/management/editProperties/checkExisting",
                success: function (resp) {
                    if (resp) {
                        $("#message-fail-add-property").fadeIn(500);
                        setTimeout(function () {
                            $("#message-fail-add-property").fadeOut(1000)
                        }, 2000);
                    } else {
                        $("#form-add-property").submit();
                    }
                }
            })
        }
    })
</script>
</body>
</html>

