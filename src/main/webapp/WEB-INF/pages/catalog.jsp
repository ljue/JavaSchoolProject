<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Людмила
  Date: 17.07.2017
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Catalog</title>
    <jsp:include page="../templates/head.jsp" />
</head>
<body>
<jsp:include page="../templates/navigation.jsp" />
<jsp:include page="../templates/scripts.jsp" />

<div class="container">
    <%--<h4>NEW COLLECTION</h4>--%>
    <br>
        <br>

    <div class="row">

        <!-- BEGIN PRODUCTS -->

        <c:if test="${!empty allProducts}">
        <c:forEach items="${allProducts}" var="product">
            <div class="col-md-4 col-sm-3">
                <span class="thumbnail">
                    <a role="button" data-toggle="modal" href="#product${product.productId}">
                    <img src="../resources/Images/${product.presentPic}" alt="...">
                    </a>

                    <h5>${product.productName}</h5>
                    <hr class="line">
                    <div class="row">
                        <div class="col-md-6 col-sm-6">
                            <p class="price">   $${product.cost}</p>
                        </div>
                        <%--<div class="col-md-6 col-sm-6">--%>
                         <%--<a href="http://cookingfoodsworld.blogspot.in/"  >	<button class="btn btn-info right " > View </button></a>--%>
                        <%--</div>--%>
                        <div class="col-md-6 col-sm-6">
                         <button value="${product.productId}" onclick="addProductToCart(this)"   class="btn btn-info right" > Add to Cart </button>
                        </div>

                    </div>
                </span>
            </div>
            <div class="modal fade product_view" id="product${product.productId}">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">

                            <h3 class="modal-title">${product.productName}</h3>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-md-6 product_img">
                                    <img src="../resources/Images/${product.presentPic}" class="img-responsive">
                                </div>
                                <div class="col-md-6 product_content">
                                    <h4>Product Id: <span>${product.productId}</span></h4>

                                    <h5>Name: <span>${product.productName}</span></h5>
                                    <h5>Category: <span>${product.productCategoryByCategory}</span></h5>
                                    <h5>Battery: <span>${product.battery}</span></h5>
                                    <h5>Fly time: <span>${product.flyTime}</span></h5>
                                    <h5>Distance: <span>${product.distance}</span></h5>
                                    <h5>${product.description}</h5>

                                    <h3 class="cost"></span> $${product.cost}</h3>


                                    <div class="space-ten"></div>
                                    <div class="btn-ground">
                                        <button type="button" value="${product.productId}" onclick="addProductToCart(this)" class="btn btn-primary"> Add To Cart</button>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        </c:if>

        <script>
            function addProductToCart(obj){
                var idProduct=obj.value;
                $.ajax({
                    type: "POST",
                    url: "/addToCart/"+idProduct
                })
            }
        </script>


        <%--<div class="col-md-4 col-sm-3">--%>
    		<%--<span class="thumbnail">--%>
      			<%--<img src="https://s12.postimg.org/655583bx9/item_1_180x200.png" alt="...">--%>
      			<%--<h4>Product Tittle</h4>--%>
      			<%--<hr class="line">--%>
      			<%--<div class="row">--%>
      				<%--<div class="col-md-6 col-sm-6">--%>
      					<%--<p class="price">$29,90</p>--%>
      				<%--</div>--%>
      				<%--<div class="col-md-6 col-sm-6">--%>
      				 <%--<a href="http://cookingfoodsworld.blogspot.in/" target="_blank" >	<button class="btn btn-info right" > BUY ITEM</button></a>--%>
      				<%--</div>--%>

      			<%--</div>--%>
    		<%--</span>--%>
        <%--</div>--%>
        <%--<div class="col-md-4 col-sm-3">--%>
    		<%--<span class="thumbnail">--%>
      			<%--<img src="https://s12.postimg.org/5w7ki5z4t/item_4_180x200.png" alt="...">--%>
      			<%--<h4>Product Tittle</h4>--%>
      			<%--<hr class="line">--%>
      			<%--<div class="row">--%>
      				<%--<div class="col-md-6 col-sm-6">--%>
      					<%--<p class="price">$29,90</p>--%>
      				<%--</div>--%>
      				<%--<div class="col-md-6 col-sm-6">--%>
      				 <%--<a href="http://cookingfoodsworld.blogspot.in/" target="_blank" >	<button class="btn btn-info right" > BUY ITEM</button></a>--%>
      				<%--</div>--%>

      			<%--</div>--%>
    		<%--</span>--%>
        <%--</div>--%>
        <%--<div class="col-md-4 col-sm-3">--%>
    		<%--<span class="thumbnail">--%>
      			<%--<img src="https://s12.postimg.org/dawwajl0d/item_3_180x200.png" alt="...">--%>
      			<%--<h4>Product Tittle</h4>--%>
                <%--<hr class="line">--%>
      			<%--<div class="row">--%>
      				<%--<div class="col-md-6 col-sm-6">--%>
      					<%--<p class="price">$29,90</p>--%>
      				<%--</div>--%>
      				<%--<div class="col-md-6 col-sm-6">--%>
      			 <%--<a href="http://cookingfoodsworld.blogspot.in/" target="_blank" >	<button class="btn btn-info right" > BUY ITEM</button></a>--%>
      				<%--</div>--%>

      			<%--</div>--%>
    		<%--</span>--%>
        <%--</div>--%>

        <!-- END PRODUCTS -->
    </div>
</div><!-------container----->







</body>
</html>
