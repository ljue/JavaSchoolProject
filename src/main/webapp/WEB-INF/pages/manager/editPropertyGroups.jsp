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
                    <li><a href="${pageContext.request.contextPath}/editCategories">Control categories</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/editPropertyGroups">Control
                        property groups</a></li>
                    <li><a href="${pageContext.request.contextPath}/editProperties">Control properties</a></li>

                </ul>

                <div class="row">
                    <c:if test="${!empty propertyGroups}">
                        <div class="tab-content">
                            <br>


                            <form:form modelAttribute="formEditPropertyGroup" method="POST"
                                         action="${pageContext.request.contextPath}/editPropertyGroups/editPropertyGroup"
                                         class="form-horizontal">

                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Edit property group:</label>
                                    <div class="col-lg-6">
                                        <form:select path="current" class="form-control">
                                            <c:forEach items="${propertyGroups}" var="prop">
                                                <form:option value="${prop}" label="${prop}"></form:option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-lg-3 control-label"></label>
                                    <div class="col-lg-6">
                                        <form:input required="required" type="text" path="edit"
                                                    class="form-control"
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
                        <form:form modelAttribute="formAddPropertyGroup" method="POST" id="form-add-property-group"
                                     action="${pageContext.request.contextPath}/editPropertyGroups/addPropertyGroup"
                                     class="form-horizontal">

                            <div class="form-group">
                                <label class="col-lg-3 control-label">Add property group:</label>

                                <div class="col-lg-6">
                                    <form:input required="required" type="text" path="add"
                                                class="form-control" id="add-property-group-input"
                                    ></form:input>
                                </div>
                            </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label"></label>
                            <div class="col-lg-6">
                                    <form:radiobutton required="required" path="type"
                                                      value="true" label="Product has once property from group"
                                    ></form:radiobutton><br>
                                    <form:radiobutton required="required" path="type"
                                                      value="false" label="Product has several properties from group (default)"
                                    ></form:radiobutton>
                                </div>
                        </div>


                            <div class="form-group">
                                <label class="col-md-3 control-label"></label>
                                <div class="col-md-6">
                                    <input id="add-new-property-group-btn" class="btn btn-primary" value="Add"
                                           type="submit">
                                </div>
                            </div>
                        </form:form>
                    </div>

                    <c:if test="${!empty propertyGroupsForRemove}">
                        <div class="tab-content">
                            <br>
                            <form:form method="POST" modelAttribute="formRemovePropertyGroup"
                                         action="${pageContext.request.contextPath}/editPropertyGroups/removePropertyGroup"
                                         class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Remove property group:</label>
                                    <div class="col-lg-6">
                                        <form:select class="form-control" path="remove">
                                            <c:forEach items="${propertyGroupsForRemove}" var="prop">
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

                    <c:if test="${!empty removedPropertyGroups}">
                        <div class="tab-content">
                            <br>
                            <form:form method="POST" modelAttribute="formReturnPropertyGroup"
                                         action="${pageContext.request.contextPath}/editPropertyGroups/returnPropertyGroup"
                                         class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-lg-3 control-label">Return property group:</label>
                                    <div class="col-lg-6">
                                        <form:select class="form-control" path="returns">
                                            <c:forEach items="${removedPropertyGroups}" var="prop">
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

<div id="message-fail-add-property-group" class="my-message-success alert alert-danger">
    <p style="font-size: 1.1em">Error. May be such property group was removed later.</p>
</div>

<script>
    $("#add-new-property-group-btn").click(function (e) {
        var form = $("#add-property-group-input").val();
        if (form.replace(/\s/g, "")) {
            e.preventDefault();
            $.ajax({
                type: "POST",
                data: {add : form},
                url: "${pageContext.request.contextPath}/editPropertyGroups/checkExisting",
                success: function (resp) {
                    if (resp) {
                        $("#message-fail-add-property-group").fadeIn(500);
                        setTimeout(function () {
                            $("#message-fail-add-property-group").fadeOut(1000)
                        }, 2000);
                    } else {
                        $("#form-add-property-group").submit();
                    }
                }
            })
        }
    })
</script>
</body>
</html>
