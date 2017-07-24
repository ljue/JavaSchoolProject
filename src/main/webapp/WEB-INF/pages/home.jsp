<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start page</title>
    <jsp:include page="../templates/head.jsp" />
</head>
<body>
<jsp:include page="../templates/navigation.jsp" />
<jsp:include page="../templates/scripts.jsp" />

/><div class="page-flexbox-wrapper">
    <div class="parallax-container">
        <div class="parallax"><img src="../resources/Images/zakat.jpg" class="img-responsive"></div>
    </div>
    <div class="row">

        <script src="//yandex.st/jquery/1.9.1/jquery.min.js"></script>

        <!-- arcticModal -->
        <script src="js/arcticmodal/jquery.arcticmodal-0.3.min.js"></script>
        <link rel="stylesheet" href="js/arcticmodal/jquery.arcticmodal-0.3.css">

        <!-- arcticModal theme -->
        <link rel="stylesheet" href="js/arcticmodal/themes/simple.css">

        <div style="display: none;">
            <div class="box-modal" id="exampleModal">
                <div class="box-modal_close arcticmodal-close">закрыть</div>
                Пример модального окна
            </div>
        </div>
<script>$(function(){
    $('#exampleModal').arcticmodal();
});</script>







    </div>
</div>
<!-- /.container -->

<!-- /.container -->


<%--<script>$(document).ready(function () {--%>
    <%--$('.parallax').parallax();--%>
<%--});</script>--%>
</body>
</html>
