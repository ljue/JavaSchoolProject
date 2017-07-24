<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Людмила
  Date: 17.07.2017
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address</title>

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
                <a href="/user" class="list-group-item">My Profile</a>
                <a href="/address" class="list-group-item">My Address</a>
                <a href="/history" class="list-group-item">My orders</a>
            </div>
        </div>

        <div class="col-md-9">
            <div class="row">
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#panel1">Available addresses</a></li>
                    <li><a data-toggle="tab" href="#panel2">Add new Address</a></li>

                </ul>

                <div class="tab-content">

                    <div id="panel1" class="tab-pane fade in active">
                        <%--<h3>Панель 1</h3>--%>
                        <br>
                            <%--<c:if test="${empty addresses}">--%>
                                <%--<p>You haven't add any address yet.</p>--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${!empty addresses}">--%>

                                <%--<c:forEach items="${addresses}" var="address">--%>
                                    <%--<table class="table">--%>

                                        <%--<tr>--%>
                                            <%--<td>Country:</td>--%>
                                            <%--<td>${address.countryEntity.name}</td>--%>
                                        <%--</tr>--%>
                                        <%--<tr>--%>
                                            <%--<td>Region:</td>--%>
                                            <%--<td>${address.regionEntity.name}</td>--%>
                                        <%--</tr>--%>
                                        <%--<tr>--%>
                                            <%--<td>City/town:</td>--%>
                                            <%--<td>${address.cityEntity.name}</td>--%>
                                        <%--</tr>--%>
                                        <%--<tr>--%>
                                            <%--<td>Address:</td>--%>
                                            <%--<td>${address.streetAddress}</td>--%>
                                        <%--</tr>--%>
                                        <%--<tr>--%>
                                            <%--<td>Post index:</td>--%>
                                            <%--<td>${address.postIndex}</td>--%>
                                        <%--</tr>--%>
                                    <%--</table>--%>
                                    <%--<br>--%>
                                    <%--<br>--%>
                                <%--</c:forEach>--%>

                            <%--</c:if>--%>

                    </div>




                    <c:url var="addaddress" value="address/add"/>

                    <div id="panel2" class="tab-pane fade">
                        <%--<h3>Панель 2</h3>--%>
                        <br>
                            <form:form modelAttribute="formAddAddress" method="post" action="${addaddress}" class="form-horizontal">
                                <fieldset>

                                    <!-- Form Name -->
                                    <%--<legend>Source address</legend>--%>

                                    <!-- Select Basic -->
                                    <spring:bind path="countryEntity">

                                        <%--</spring:bind>--%>
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="Country">Country</label>
                                            <div class="col-md-5">
                                                <form:select id="Country" path="countryEntity" class="form-control">
                                                    <c:forEach items="${countries}" var="country">
                                                        <form:option value="${country.name}" label="${country.name}"></form:option>
                                                    </c:forEach>
                                                </form:select>

                                            </div>
                                        </div>
                                    </spring:bind>


                                    <spring:bind path="regionEntity">
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="State">Region/State</label>
                                            <div class="col-md-5">
                                                <form:select id="State" path="regionEntity" class="form-control">
                                                    <c:forEach items="${regions}" var="region">
                                                        <form:option value="${region.name}" label="${region.name}"></form:option>
                                                    </c:forEach>
                                                </form:select>
                                            </div>
                                        </div>
                                    </spring:bind>

                                    <spring:bind path="cityEntity">
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="city">City/Town</label>
                                            <div class="col-md-5">
                                                <form:select id="city" path="cityEntity" class="form-control">
                                                    <c:forEach items="${cities}" var="city">
                                                        <form:option value="${city.name}" label="${city.name}"></form:option>
                                                    </c:forEach>
                                                </form:select>
                                            </div>
                                        </div></spring:bind>

                                    <spring:bind path="streetAddress">
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="address1">Address Line</label>
                                            <div class="col-md-8">
                                                <form:input id="address1" type="text" path="streetAddress" class="form-control" placeholder=""
                                                ></form:input>
                                                <span class="help-block">Street address, P.O. box, company name, c/o</span>
                                            </div>
                                        </div></spring:bind>

                                    <!-- Text input-->
                                    <spring:bind path="postIndex">
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="zip">Postal code</label>
                                            <div class="col-md-4">
                                                <form:input id="zip" type="text" path="postIndex" class="form-control" placeholder="Zip or Postal code"
                                                ></form:input>
                                            </div>
                                        </div></spring:bind>



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
