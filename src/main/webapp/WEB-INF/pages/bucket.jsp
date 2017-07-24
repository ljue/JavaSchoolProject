<%--
  Created by IntelliJ IDEA.
  User: Людмила
  Date: 17.07.2017
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bucket</title>
    <jsp:include page="../templates/head.jsp" />

    <style>
        @import url(//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css);

        tbody > tr {
            cursor: pointer;
        }

        .result{
            margin-top:20px;
        }
    </style>
</head>
<body>
<jsp:include page="../templates/navigation.jsp" />
<jsp:include page="../templates/scripts.jsp" />


<%--<jsp:include page="/countries" />--%>
<!-- Page Content -->
<%--<div class="container">--%>

    <%--<div class="row">--%>

        <%--<div class="col-md-3">--%>
            <%--<p class="lead">Shop Name</p>--%>
            <%--<div class="list-group">--%>
                <%--<a href="/user" class="list-group-item">Личная информация</a>--%>
                <%--<a href="/adress" class="list-group-item">Адрес</a>--%>
                <%--<a href="/history" class="list-group-item">Заказы</a>--%>
            <%--</div>--%>
        <%--</div>--%>

    <%--</div>--%>

<%--</div>--%>

</div>
<!-- /.container -->
<div class="container">

    <div class="alert alert-info">
        <a id="fullscreen" href="#fullscreen" class="alert-link"><strong>Click here</strong></a> to view this snippet in an iframe.
        <i class="fa fa-info-circle fa-2x pull-right"></i>
    </div>

    <h1> <i class="fa fa-shopping-cart"></i> Produtos <small> - click on product for details</small> <a href="http://bootsnipp.com/alisonpedro/snippets/Q60Oj" class="btn btn-danger pull-right hide" id="back-to-bootsnipp">Back to Bootsnipp</a></h1>

    <hr>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>#Cod</th>
            <th>Name</th>
            <th>Manufacturers</th>
            <th>Model</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>Dell 18.5 Inch Monitor</td>
            <td>Dell</td>
            <td>IN1930</td>
        </tr>
        <tr>
            <td>2</td>
            <td>Intel Core i5</td>
            <td>Intel</td>
            <td>Core i5</td>
        </tr>
        <tr>
            <td>3</td>
            <td >Gaming Keyboard G510</td>
            <td>Logitech</td>
            <td>G510</td>
        </tr>

        <tr>
            <td>1</td>
            <td>Dell 18.5 Inch Monitor</td>
            <td>Dell</td>
            <td>IN1930</td>
        </tr>
        <tr>
            <td>2</td>
            <td>Intel Core i5</td>
            <td>Intel</td>
            <td>Core i5</td>
        </tr>
        <tr>
            <td>3</td>
            <td >Gaming Keyboard G510</td>
            <td>Logitech</td>
            <td>G510</td>
        </tr>
        </tbody>
    </table>

    <div class="col-sm-12 ">
        <div class="result pull-left"><strong>Mostrando 1 até 6 de 5000</strong></div>

        <ul class="pagination pull-right">
            <li><a href="#">«</a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">»</a></li>
        </ul>

    </div>



</div>

<!-- Modal -->
<div class="modal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="text-danger fa fa-times"></i></button>
                <h4 class="modal-title" id="myModalLabel"><i class="text-muted fa fa-shopping-cart"></i> <strong>02051</strong> - Nome do Produto </h4>
            </div>
            <div class="modal-body">

                <table class="pull-left col-md-8 ">
                    <tbody>
                    <tr>
                        <td class="h6"><strong>Código</strong></td>
                        <td> </td>
                        <td class="h5">02051</td>
                    </tr>

                    <tr>
                        <td class="h6"><strong>Descrição</strong></td>
                        <td> </td>
                        <td class="h5">descrição do produto</td>
                    </tr>

                    <tr>
                        <td class="h6"><strong>Marca/Fornecedor</strong></td>
                        <td> </td>
                        <td class="h5">Marca do produto</td>
                    </tr>

                    <tr>
                        <td class="h6"><strong>Número Original</strong></td>
                        <td> </td>
                        <td class="h5">0230316</td>
                    </tr>

                    <tr>
                        <td class="h6"><strong>Código N.C.M</strong></td>
                        <td> </td>
                        <td class="h5">032165</td>
                    </tr>

                    <tr>
                        <td class="h6"><strong>Código de Barras</strong></td>
                        <td> </td>
                        <td class="h5">0321649843</td>
                    </tr>

                    <tr>
                        <td class="h6"><strong>Unid. por Embalagem</strong></td>
                        <td> </td>
                        <td class="h5">50</td>
                    </tr>

                    <tr>
                        <td class="h6"><strong>Quantidade Mínima</strong></td>
                        <td> </td>
                        <td class="h5">50</td>
                    </tr>

                    <tr>
                        <td class="h6"><strong>Preço Atacado</strong></td>
                        <td> </td>
                        <td class="h5">R$ 35,00</td>
                    </tr>

                    <tr>
                        <td class="btn-mais-info text-primary">
                            <i class="open_info fa fa-plus-square-o"></i>
                            <i class="open_info hide fa fa-minus-square-o"></i> informações
                        </td>
                        <td> </td>
                        <td class="h5"></td>
                    </tr>

                    </tbody>
                </table>


                <div class="col-md-4">
                    <img src="http://lorempixel.com/150/150/technics/" alt="teste" class="img-thumbnail">
                </div>

                <div class="clearfix"></div>
                <p class="open_info hide">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
            </div>

            <div class="modal-footer">

                <div class="text-right pull-right col-md-3">
                    Varejo: <br/>
                    <span class="h3 text-muted"><strong> R$50,00 </strong></span></span>
                </div>

                <div class="text-right pull-right col-md-3">
                    Atacado: <br/>
                    <span class="h3 text-muted"><strong>R$35,00</strong></span>
                </div>

            </div>
        </div>
    </div>
</div>
<!-- fim Modal-->




</body>
</html>
