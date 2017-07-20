<%--
  Created by IntelliJ IDEA.
  User: Людмила
  Date: 17.07.2017
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person</title>

        <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="/resources/css/shop-homepage.css" rel="stylesheet">
    </head>
<body>
<jsp:include page="/navigation" />

<%--<jsp:include page="/countries" />--%>
<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <p class="lead">Shop Name</p>
            <div class="list-group">
                <a href="/user" class="list-group-item">Профиль</a>
                <a href="/history" class="list-group-item">Заказы</a>
            </div>
        </div>

        <div class="col-md-9">
            <div class="row">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="/user" class="list-group-item">Личная информация</a></li>
                    <li><a href="/adress" class="list-group-item">Адрес</a></li>
                </ul>



                <p class="text-left">
                    <br>Имя: ${user.firstName}
                    <br>Фамилия: ${user.secondName}
                    <br>Дата рождения: ${user.birthday}
                    <br>E-mail: ${user.email}
                    <br>Логин: ${user.login}
                    <br>Пароль: ${user.pass}


                </p>
            </div>
        </div>

    </div>
</div>

<!-- /.container -->
<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
