<%--
  Created by IntelliJ IDEA.
  User: Людмила
  Date: 29.07.2017
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>

<div class="container">

    <div class="panel panel-default">
        <div class="panel-heading text-center"><h4>Current Cart</h4></div>
        <div class="panel-body">
            <table class="table borderless">
                <thead>
                <tr>
                    <td><strong>Your Cart: # item</strong></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <!-- foreach ($order->lineItems as $line) or some such thing here -->
                <tr>
                    <td class="col-md-3">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="http://lorempixel.com/460/250/" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h5 class="media-heading"> Product Name</h5>
                                <h5 class="media-heading"> Product Code</h5>
                            </div>
                        </div>
                    </td>
                    <td class="text-center">$10.99</td>
                    <td class="text-center">1</td>
                    <td class="text-right">$32.99</td>
                    <td class="text-right"><button type="button" class="btn btn-danger">Remove</button></td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
