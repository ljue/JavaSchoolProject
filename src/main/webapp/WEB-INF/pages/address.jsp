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
                        <p>You haven't add any address yet.</p>
                    </div>





                    <div id="panel2" class="tab-pane fade">
                        <%--<h3>Панель 2</h3>--%>
                        <br>
                            <form class="form-horizontal">
                                <fieldset>

                                    <!-- Form Name -->
                                    <%--<legend>Source address</legend>--%>

                                    <!-- Select Basic -->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="Country">Country</label>
                                        <div class="col-md-5">
                                            <select id="Country" name="Country" class="form-control">
                                                <option value="DE">Germany</option>
                                                <option value="Ru">Russia</option>
                                                <option value="USA">United States</option>
                                            </select>
                                        </div>
                                    </div>

                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="State">Region/State</label>
                                        <div class="col-md-5">
                                            <select id="State" name="State" class="form-control">
                                                <option value="1">Berlin</option>
                                                <option value="2">Moscow</option>
                                                <option value="3">Washington</option>
                                            </select>
                                        </div>
                                    </div>

                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="city">City/Town</label>
                                        <div class="col-md-6">
                                            <input id="city" name="city" type="text" placeholder="city or town" class="form-control input-md" required="">

                                        </div>
                                    </div>

                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="address1">Address Line1</label>
                                        <div class="col-md-8">
                                            <input id="address1" name="address1" type="text" placeholder="" class="form-control input-md">
                                            <span class="help-block">Street address, P.O. box, company name, c/o</span>
                                        </div>
                                    </div>

                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="zip">Zip/Postal code</label>
                                        <div class="col-md-4">
                                            <input id="zip" name="zip" type="text" placeholder="zip or postal code" class="form-control input-md" required="">

                                        </div>
                                    </div>



                                    <div class="form-group">
                                        <label class="col-md-3 control-label"></label>
                                        <div class="col-md-8">
                                            <input class="btn btn-primary" value="Save Changes" type="submit">
                                            <span></span>
                                            <input class="btn btn-default" value="Cancel" type="reset">
                                        </div>
                                    </div>

                                </fieldset>
                            </form>
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
