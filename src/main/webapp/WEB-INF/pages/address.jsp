<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address</title>

    <jsp:include page="../templates/head.jsp"/>
</head>
<body>
<jsp:include page="../templates/navigation.jsp"/>
<jsp:include page="../templates/scripts.jsp"/>
<br>
<br>


<%--<jsp:include page="/countries" />--%>
<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-md-3">
            <p class="lead"></p>
            <div class="list-group">
                <a href="/user" class="list-group-item">My Profile</a>
                <a href="/address" class="list-group-item">My Address</a>
                <a href="/history" class="list-group-item">My orders</a>
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

                                    <div class="container">
                                        <div class="col-lg-6 col-sm-4 text-center">
                                            <div class="well">
                                                <strong class="pull-left primary-font">Address ${status.count}</strong>

                                                <ul data-brackets-id="12674" id="sortable"
                                                    class="list-unstyled ui-sortable">
                                                    <hr data-brackets-id="12673">
                                                    </br>
                                                    <li class="ui-state-default">
                                                            ${address.country},<br>
                                                            ${address.region},<br>
                                                            ${address.city},<br>
                                                            ${address.streetAddress},<br>
                                                        Post code: ${address.postIndex}<br>
                                                    </li>
                                                    <br><br><br></br>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>

                            </c:if>
                            <br>
                        </row>
                    </div>


                    <c:url var="addaddress" value="address/add"/>

                    <div id="panel2" class="tab-pane fade">
                        <br>
                        <form:form modelAttribute="formAddAddress" method="post" action="${addaddress}"
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
                                            <span class="help-block">Street address, P.O. box, company name, c/o</span>
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
<!-- /.container -->

</body>
</html>
