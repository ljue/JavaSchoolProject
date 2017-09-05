<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>

    <title>Log in</title>
</head>
<body>
<jsp:include page="../templates/navigation.jsp"/>
<script src="${pageContext.request.contextPath}/resources/js/login.js"></script>

<div class="container">

    <form method="POST" action="${pageContext.request.contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input id="login-login" required name="login" type="text" class="form-control" placeholder="Login"
                   autofocus="true"/>
            <input id="login-password" required name="pass" type="password" class="form-control"
                   placeholder="Password"/>
            <span id="login-error">${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${pageContext.request.contextPath}/registration">Create an account</a></h4>
            <p class="text-center" style="color: #a5a5a5; text-decoration: underline"><a id="click-forgot-password">I forgot my password</a></p>
        </div>

    </form>

</div>

<div id="modal-forgot-password" class="modal fade" style="padding-top: 200px;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" style="padding-bottom: 50px">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <div class="text-center">
                <h4 style="padding: 20px">Input your e-mail, please.</h4>
                <input id="input-email-forgot-password" type="email" class="form-control"
                      required placeholder="Email" style="width: 250px; display: inline-block"/>
                <button id="send-forgot-password" type="button" style="margin-bottom: 8px" class="btn btn-primary">
                   <i class="fa fa-paper-plane" aria-hidden="true"></i> Send
                </button>
                </div>
            </div>

        </div>
    </div>
</div>

<div id="message-success-send-email" class="my-message-success alert alert-success">
    <p style="font-size: 1.1em">Password was sent. Check your mail.</p>
</div>
<div id="message-fail-send-email" class="my-message-success alert alert-danger">
    <p style="font-size: 1.1em">Such email didn`t registered in system.</p>
</div>

</body>
</html>
