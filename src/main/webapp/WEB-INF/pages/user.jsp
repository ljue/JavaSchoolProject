<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserInfo</title>
    <jsp:include page="../templates/head.jsp" />
</head>
<body>
<jsp:include page="../templates/navigation.jsp" />
<jsp:include page="../templates/scripts.jsp" />

<c:url var="editInfo" value="/my-webapp/user/editInfo"/>
<c:url var="editPass" value="/my-webapp/user/editPass"/>

<br>
<br>
<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-md-3">
                <p class="lead">   </p>
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/user" class="list-group-item">My Profile</a>
                <a href="${pageContext.request.contextPath}/address" class="list-group-item">My Address</a>
                <a href="${pageContext.request.contextPath}/history" class="list-group-item">My Orders</a>
            </div>
        </div>

        <div class="col-md-9">
            <div class="row">

                <!-- edit form column -->
                <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
                    <h3>Personal info</h3>


                    <form:form method="POST" modelAttribute="userForm" action="${editInfo}" class="form-horizontal">


                        <spring:bind path="firstName">
                        <div class="form-group ${status.error ? 'has-error' : ''}" >
                            <label class="col-lg-3 control-label">First roleName:</label>
                            <div class="col-lg-8">
                                <form:input type="text" path="firstName" class="form-control" value="${user.firstName}"
                                ></form:input>
                            </div>
                            <form:errors path="firstName"></form:errors>
                        </div>
                        </spring:bind>

                        <spring:bind path="secondName">
                            <div class="form-group ${status.error ? 'has-error' : ''}" >
                                <label class="col-lg-3 control-label">Second roleName:</label>
                                <div class="col-lg-8">
                                    <form:input type="text" path="secondName" class="form-control" value="${user.secondName}"
                                    ></form:input>
                                </div>
                                <form:errors path="secondName"></form:errors>
                            </div>
                        </spring:bind>

                        <spring:bind path="birthday">
                            <div class="form-group ${status.error ? 'has-error' : ''}" >
                                <label class="col-lg-3 control-label">Birthday:</label>
                                <div class="col-lg-8">
                                    <form:input type="date" path="birthday" class="form-control" value="${user.birthday}"
                                    ></form:input>
                                </div>
                                <form:errors path="birthday"></form:errors>
                            </div>
                        </spring:bind>


                        <spring:bind path="email">
                            <div class="form-group ${status.error ? 'has-error' : ''}" >
                                <label class="col-lg-3 control-label">Email:</label>
                                <div class="col-lg-8">
                                    <form:input type="text" path="email" class="form-control" value="${user.email}"
                                    ></form:input>
                                </div>
                                <form:errors path="email"></form:errors>
                            </div>
                        </spring:bind>

                        <spring:bind path="login">
                            <div class="form-group ${status.error ? 'has-error' : ''}" >
                                <label class="col-lg-3 control-label">Login:</label>
                                <div class="col-lg-8">
                                    <form:input type="text" path="login" class="form-control" value="${user.login}"
                                    ></form:input>
                                </div>
                                <form:errors path="login"></form:errors>
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

                    </form:form>
                </div>


                <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
                    <h4>Change Password</h4>

                    <form:form method="POST" modelAttribute="userForm" action="${editPass}"  class="form-horizontal">

                        <spring:bind path="pass">
                        <div class="form-group ${status.error ? 'has-error' : ''}" >
                        <label class="col-lg-3 control-label">Password:</label>
                        <div class="col-lg-8">
                        <form:input type="password" path="login" class="form-control" placeholder="Password"
                        ></form:input>
                        </div>
                        <form:errors path="pass"></form:errors>
                        </div>
                        </spring:bind>

                        <spring:bind path="pass">
                        <div class="form-group ${status.error ? 'has-error' : ''}" >
                        <label class="col-lg-3 control-label">Confirm password:</label>
                        <div class="col-lg-8">
                        <form:input type="password" path="pass" class="form-control" placeholder="Confirm password"
                        ></form:input>
                        </div>
                        <form:errors path="pass"></form:errors>
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

                    </form:form>
                </div>



            </div>
        </div>



    </div>
</div>

<!-- /.container -->

</body>
</html>
