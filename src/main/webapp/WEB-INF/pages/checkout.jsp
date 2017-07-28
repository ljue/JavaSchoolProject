<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Людмила
  Date: 27.07.2017
  Time: 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
    <jsp:include page="../templates/head.jsp"/>
</head>
<body>
<jsp:include page="../templates/navigation.jsp"/>
<jsp:include page="../templates/scripts.jsp"/>
<br>
<br>

<div class="container">
    <div class="row">
        <div class="col-md-3">

        </div>

        <div class="col-md-9">
            <c:url var="goPay" value="/checkout/goPay"/>
            <form:form modelAttribute="orderForm" method="post" action="${goPay}">

                <h4>Address</h4><br>
                <a data-toggle="modal" href="#modalAddress">Add new address</a><br>
                <div >
                    <%--<div class="row">--%>
                        <c:if test="${!empty addresses}">
                            <c:forEach items="${addresses}" var="address" varStatus="status">

                                <div class="container">
                                <form:radiobutton path="addressId" value="${address.addressId}"></form:radiobutton>
                                    <br>
                                <div class="col-lg-4 col-sm-3 text-center">
                                    <div class="well">
                                        <strong class="pull-left primary-font">Address ${status.count}</strong>
                                        <ul class="list-unstyled ui-sortable">
                                            <hr>
                                            <li class="ui-state-default">
                                                    ${address.country},<br>
                                                    ${address.region},<br>
                                                    ${address.city},<br>
                                                    ${address.streetAddress},<br>
                                                Post code: ${address.postIndex}<br>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    <%--</div>--%>
                </div>
                <br><br>

                <c:if test="${!empty deliveryWays}">
                    <hr>
                    <h4>Delivery</h4>
                    <c:forEach items="${deliveryWays}" var="delivery">
                        <form:radiobutton path="deliveryWay" value="${delivery}" label="${delivery}"/><br>
                    </c:forEach>
                </c:if>
                <br><br>
                <c:if test="${!empty payWays}">
                    <h4>Pay Way</h4>
                    <c:forEach items="${payWays}" var="payW">
                        <form:radiobutton path="payWay" value="${payW}" label="${payW}"/><br>
                    </c:forEach>
                </c:if>
                <div class="form-group">
                    <label class="col-md-3 control-label"></label>
                    <div class="col-md-8">
                        <input class="btn btn-primary" value="Next" type="submit">
                    </div>
                </div>


            </form:form>
        </div>


    </div>
</div>


<div class="modal fade product_view" id="modalAddress">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h3 class="modal-title">Add new Address</h3>
            </div>
            <div class="modal-body">
                <div class="row">
                    <c:url var="addNewAddress" value="/checkout/addNewAddress"/>

                    <form:form modelAttribute="newAddress" method="post" action="${addNewAddress}"
                               class="form-horizontal">
                        <fieldset>
                            <spring:bind path="country">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Country</label>
                                    <div class="col-md-6">
                                        <form:input type="text" path="country" class="form-control"
                                                    placeholder="Country"
                                        ></form:input>
                                    </div>
                                </div>
                            </spring:bind>
                            <spring:bind path="region">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Region</label>
                                    <div class="col-md-6">
                                        <form:input type="text" path="region" class="form-control"
                                                    placeholder="Region"
                                        ></form:input>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="city">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">City/Town</label>
                                    <div class="col-md-6">
                                        <form:input type="text" path="city" class="form-control"
                                                    placeholder="City / Town"
                                        ></form:input>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="streetAddress">
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="address1">Address
                                        Line</label>
                                    <div class="col-md-8">
                                        <form:input id="address1" type="text" path="streetAddress"
                                                    class="form-control" placeholder=""
                                        ></form:input>
                                        <span class="help-block">Street address, P.O. box, company name, c/o</span>
                                    </div>
                                </div>
                            </spring:bind>

                            <!-- Text input-->
                            <spring:bind path="postIndex">
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="zip">Postal code</label>
                                    <div class="col-md-4">
                                        <form:input id="zip" type="text" path="postIndex"
                                                    class="form-control"
                                                    placeholder="Zip or Postal code"
                                        ></form:input>
                                    </div>
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

</body>
</html>
