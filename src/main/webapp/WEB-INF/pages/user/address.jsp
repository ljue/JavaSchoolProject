<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<title>Address</title>--%>

</head>
<body>
<jsp:include page="../../templates/navigation.jsp"/>
<br>
<br>


<%--<jsp:include page="/countries" />--%>
<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-md-3">
            <p class="lead"></p>
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/user" class="list-group-item">My Profile</a>
                <a href="${pageContext.request.contextPath}/address" class="list-group-item">My Address</a>
                <a href="${pageContext.request.contextPath}/history" class="list-group-item">My orders</a>
            </div>
        </div>

        <div class="col-md-9">
            <div class="row">
                <br>
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#panel1">Available addresses</a></li>
                    <li><a data-toggle="tab" href="#panel2">Add new Address</a></li>

                </ul>

                <div class="tab-content">
                    <div id="panel1" class="tab-pane fade in active">
                        <%--<h3>Панель 1</h3>--%>
                        <row>
                            <br>
                            <c:if test="${empty addresses}">
                                <p>You haven't add any address yet.</p>
                            </c:if>
                            <c:if test="${!empty addresses}">

                                <c:forEach items="${addresses}" var="address" varStatus="status">

                                    <div class="container" id="panel-address-${address.addressId}">
                                        <div class="col-lg-6 col-sm-4 text-center">
                                            <div class="well" style="background: #fdf7f7">
                                                <a title="Remove address" data-seq="${address.addressId}"
                                                   class="pull-right remove-address-panel">
                                                    <span><i class="fa fa-times fa-lg"></i></span></a>
                                                <strong class="pull-left primary-font">Address ${status.count}</strong>

                                                <ul class="list-unstyled ui-sortable">
                                                    <hr>
                                                    </br>
                                                    <li class="ui-state-default" style="font-size: 1.2em">
                                                            ${address.country},<br>
                                                            ${address.region},<br>
                                                            ${address.city},<br>
                                                            ${address.streetAddress},<br>
                                                        Post code: ${address.postIndex}<br>
                                                    </li>
                                                    <br><br><br>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>

                            </c:if>
                            <br>
                        </row>
                    </div>


                    <%--<c:url var="addaddress" value="${pageContext.request.contextPath}/address/add"/>--%>

                    <div id="panel2" class="tab-pane fade">
                        <br>
                        <form:form modelAttribute="formAddAddress" method="post" action="${pageContext.request.contextPath}/address/add"
                                   class="form-horizontal">
                            <fieldset>
                                <spring:bind path="country">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label class="col-md-3 control-label">Country</label>
                                        <div class="col-md-6">
                                            <form:input type="text" path="country" class="form-control"
                                                        placeholder="Country"
                                            ></form:input>
                                        </div>
                                        <form:errors path="country"></form:errors>
                                    </div>
                                </spring:bind>
                                <spring:bind path="region">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label class="col-md-3 control-label">Region</label>
                                        <div class="col-md-6">
                                            <form:input type="text" path="region" class="form-control"
                                                        placeholder="Region"
                                            ></form:input>
                                        </div>
                                        <form:errors path="region"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="city">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label class="col-md-3 control-label">City/Town</label>
                                        <div class="col-md-6">
                                            <form:input type="text" path="city" class="form-control"
                                                        placeholder="City / Town"
                                            ></form:input>
                                        </div>
                                        <form:errors path="city"></form:errors>
                                    </div>
                                </spring:bind>

                                <spring:bind path="streetAddress">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label class="col-md-3 control-label" for="address1">Address Line</label>
                                        <div class="col-md-8">
                                            <form:input id="address1" type="text" path="streetAddress"
                                                        class="form-control" placeholder=""
                                            ></form:input>
                                            <span class="help-block">Street address, P.O. box, company roleName, c/o</span>
                                        </div>
                                        <form:errors path="streetAddress"></form:errors>
                                    </div>
                                </spring:bind>

                                <!-- Text input-->
                                <spring:bind path="postIndex">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <label class="col-md-3 control-label" for="zip">Postal code</label>
                                        <div class="col-md-4">
                                            <form:input id="zip" type="text" path="postIndex" class="form-control"
                                                        placeholder="Zip or Postal code"
                                            ></form:input>
                                        </div>
                                        <form:errors path="postIndex"></form:errors>
                                    </div>
                                </spring:bind>


                                <div class="form-group">
                                    <label class="col-md-3 control-label"></label>
                                    <div class="col-md-8">
                                        <input class="btn btn-primary" value="Save Changes" type="submit">
                                        <span></span>
                                        <input class="btn btn-default" value="Cancel" type="reset">
                                    </div>
                                </div>

                            </fieldset>
                        </form:form>
                    </div>

                </div>
            </div>
        </div>


    </div>

</div>

</div>
<script>
    $('a.remove-address-panel').click(function (e) {
        e.preventDefault();
        var addressId = $(this).data('seq');
        var panelId = "#panel-address-" + addressId;
        $(panelId).slideUp();//400mc
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/address/remove/" + addressId
        })
    })

</script>
</body>
</html>
