<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<hr>
<div class="row" style="margin: 50px 0 50px 0" ;>

    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="row">
            <form:form modelAttribute="product" class="form-horizontal" id="form-edit-product-info">

                <div class="form-group">
                    <label class="col-md-4"></label>
                    <label class="col-md-6">Add items:</label>
                </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Current count is: ${product.count}</label>
                        <div class="col-md-6">
                            <form:input path="count" value="0" type="number" pattern="[0-9]{1,4}" class="form-control"/>
                        </div>
                    </div>

                <div class="form-group">
                    <label class="col-md-4"></label>
                    <label class="col-md-6">Edit category:</label>
                </div>
                <div class="form-group">
                    <label class="col-md-4  control-label">Current category is: "${product.category}"</label>
                    <div class="col-md-6">
                        <form:select path="category" class="form-control">
                            <c:forEach items="${categories}" var="cat">
                                <c:if test="${cat eq product.category}">
                                    <form:option selected="selected" value="${cat}"
                                                 label="${cat}"></form:option>
                                </c:if>
                                <c:if test="${cat ne product.category}">
                                    <form:option value="${cat}"
                                                 label="${cat}"></form:option>
                                </c:if>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4"></label>
                    <label class="col-md-6">Edit cost:</label>
                </div>
                    <div class="form-group">
                        <label class="col-md-4  control-label">Current cost is: ${product.cost}$</label>
                        <div class="col-md-6">
                            <form:input path="cost" value="${product.cost}" id="input-cost-edit-product"
                                        type="text" required="required" class="form-control"/>
                        </div>
                        <div class="has-error double-regex-error-message"></div>
                    </div>


                <div class="form-group">
                    <label class="col-md-4"></label>
                    <div class="col-md-6">
                        <input class="btn btn-primary" type="submit"
                               id="btn-edit-product-info" value="Edit"/>
                        <c:if test="${product.visible eq true}">
                        <input class="btn btn-default" type="button"
                               id="btn-remove-product-info" value="Remove"/>
                        </c:if>
                        <c:if test="${product.visible eq false}">
                            <input class="btn btn-default" type="button"
                                   id="btn-return-product-info" value="Return"/>
                        </c:if>
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</div>

<script>
    $("#btn-edit-product-info").click(function (e) {
        e.preventDefault();
//        var re = new RegExp("^(?:[1-9]\d*|0)?(?:\.\d+)?$");
//        var doub = $("#input-cost-edit-product").val();
//        var parsDoub = parseFloat(doub);
//        if (parsDoub === doub && doub>0 && doub!=="") {
//            alert("+");
            var form = $("#form-edit-product-info").serialize();
            var productId = $("#product-id-edit-info").text();
            $.ajax({
                type: "POST",
                data: form,
                url: "${pageContext.request.contextPath}/management/editProductInfo/" + productId,
                success: function (page) {
                    $("#product-edit-info-panel").html(page);
                    $("#message-success-edit-product").fadeIn(500);
                    setTimeout(function () {
                        $("#message-success-edit-product").fadeOut(1000)
                    }, 2000);
                }
            })
//        } else {
//            $(".double-regex-error-message").text("Invalid format.")
//        }
    })

    $("#btn-remove-product-info").click(function (e) {
        e.preventDefault();
        var productId = $("#product-id-edit-info").text();
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/management/removeProduct/" + productId,
            success: function (page) {
                $("#product-edit-info-panel").html(page);
                $("#message-success-edit-product").fadeIn(500);
                setTimeout(function () {
                    $("#message-success-edit-product").fadeOut(1000)
                }, 2000);
            }
        })
    })

    $("#btn-return-product-info").click(function (e) {
        e.preventDefault();
        var productId = $("#product-id-edit-info").text();
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/management/returnProduct/" + productId,
            success: function (page) {
                $("#product-edit-info-panel").html(page);
                $("#message-success-edit-product").fadeIn(500);
                setTimeout(function () {
                    $("#message-success-edit-product").fadeOut(1000)
                }, 2000);
            }
        })
    })
</script>
