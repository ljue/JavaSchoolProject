<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<jsp:include page="../templates/navigation.jsp"/>

<br><br><br>


<div class="container">
    <div class="row">
        <div class="col-xs-4 item-photo">
            <img style="max-width:100%;" src="${pageContext.request.contextPath}/resources/Images/${product.presentPic}" alt="..." />
        </div>
        <div class="col-xs-5" style="border:0px solid gray">
            <h3>${product.productName}</h3>
            <h6><small>#Id: ${product.productId}</small></h6>

            <h3 style="margin-top:0px;">${product.cost}$</h3>


            <%--<div class="section" style="padding-bottom:20px;">--%>
                <%--<h6 class="title-attr"><small>CANTIDAD</small></h6>--%>
                <%--<div>--%>
                    <%--<div class="btn-minus"><span class="glyphicon glyphicon-minus"></span></div>--%>
                    <%--<input value="1" />--%>
                    <%--<div class="btn-plus"><span class="glyphicon glyphicon-plus"></span></div>--%>
                <%--</div>--%>
            <%--</div>--%>

            <div class="section" style="padding-bottom:20px;">
                <button class="btn btn-success"> Add to cart</button>
                <%--<h6><a href="#"> Add to cart</a></h6>--%>
            </div>
        </div>

        <div class="col-xs-9">
            <ul class="menu-items">
                <li class="active">Description</li>
                <li>Details</li>
            </ul>
            <div style="width:100%;border-top:1px solid silver">
                <p style="padding:15px;">
                    <small>
                        ${product.description}
                    </small>
                </p>
                <%--<small>--%>
                    <%--${product.description}--%>
                <%--</small>--%>
            </div>
        </div>
    </div>
</div>
</body>
</html>
