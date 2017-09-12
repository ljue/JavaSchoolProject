<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page isELIgnored="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--<title>Catalog</title>--%>
</head>
<body>
<jsp:include page="../templates/navigation.jsp"/>
<%--<script src="${pageContext.request.contextPath}/resources/js/catalog.js"></script>--%>

<br><br><br>
<div class="container">

    <div class="row">

        <div class="col-md-3">
            <div class="row">
                <div class="list-group list-category-item-in-catalog-js  cursor-pointer">

                    <a class="list-group-item active-list-group-item category-item-in-catalog-js">All goods</a>

                    <c:if test="${!empty categories}">
                        <c:forEach var="category" items="${categories}">
                        <a class="list-group-item category-item-in-catalog-js">${category}</a>
                        </c:forEach>
                    </c:if>

                    <sec:authorize access="hasRole('ROLE_MANAGER')">
                        <a class="list-group-item category-item-in-catalog-js">Removed goods</a>

                        <c:if test="${!empty removedCategories}">
                            <c:forEach var="removedCat" items="${removedCategories}">
                                <a class="list-group-item category-item-in-catalog-js">${removedCat}</a>
                            </c:forEach>
                        </c:if>

                    </sec:authorize>

                </div>
                <sping:form id="filter-form-in-catalog" modelAttribute="filter"
                            action="${pageContext.request.contextPath}/catalog/doFilter"
                            method="post"
                            class="form-horizontal">
                    <label>Cost:</label>
                    <div class="form-group">
                        <div class="col-lg-5">
                            <form:input path="costFROM" class="form-control"  type="number" step="any"></form:input>
                        </div>
                        <label class="col-lg-1">-</label>
                        <div class="col-lg-5">
                            <form:input path="costTO" class="form-control"  type="number" step="any"></form:input>
                        </div>
                    </div>

                    <label>Fly time:</label>
                    <div class="form-group">
                        <div class="col-lg-5">
                            <form:input path="flyTimeFROM" class="form-control"  type="number"></form:input>
                        </div>
                        <label class="col-lg-1">-</label>
                        <div class="col-lg-5">
                            <form:input path="flyTimeTO" class="form-control" type="number"></form:input>
                        </div>
                    </div>

                    <label>Distance:</label>
                    <div class="form-group">
                        <div class="col-lg-5">
                            <form:input path="distanceFROM" class="form-control"  type="number"></form:input>
                        </div>
                        <label class="col-lg-1">-</label>
                        <div class="col-lg-5">
                            <form:input path="distanceTO" class="form-control"  type="number"></form:input>
                        </div>
                    </div>

                    <c:forEach items="${allProperties}" var="propertyGroup">

                        <label>${propertyGroup.key}:</label><br>
                        <div class="form-group">
                            <div class="col-lg-8">
                                <c:forEach items="${propertyGroup.value}" var="currentProperty">
                                    <form:checkbox path="properties"
                                                   value="${currentProperty}" label="  ${currentProperty}"
                                    ></form:checkbox><br>
                                </c:forEach>
                                <br>
                            </div>
                        </div>
                    </c:forEach>

                    <div class="form-group">
                        <div class="col-md-8">
                            <input id="filter-submit-btn" class="btn btn-primary" value="Apply" type="submit">
                            <input class="btn btn-default" value="Cancel" type="reset">
                        </div>
                    </div>

                </sping:form>

            </div>
        </div>


        <div class="col-md-9">

            <div class="row">
                <div class="catalog-products-by-category">
                    <div class="container-my-mini">
                        <div class="row">
                            <div id="current-catalog-page">
                                <jsp:include page="catalogProducts.jsp"/>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>

    </div>
    <%--<div id="max-count-products-on-page" style="visibility: hidden;">12</div>--%>


    <div class="text-center">
        <form class="form-horizontal">
            <div class="form-group">
                <label style="margin-right: 15px;">Count on page: </label>
            <select id="max-count-products-on-page" >
                <option>6</option>
                <option>9</option>
                <option selected="selected">12</option>
                <option>21</option>
                <option>27</option>
            </select>
            </div>
        </form>

        <ul id="pagination-demo" class="pagination-sm"></ul>
    </div>

    <div id="category-in-catalog" style="visibility: hidden;"></div>
    <div id="visible-products-in-filter" style="visibility: hidden;"></div>
</div>
<div id="message-success-add-to-cart" class="my-message-success alert alert-success">
    <p style="font-size: 1.1em">Product was added to cart.</p>
</div>
<%--<jsp:include page="../templates/footer.jsp"/>--%>
</body>

<script>
    function displayPage(newTotal){
        var pageData = $('#pagination-demo').data();
        if (newTotal === 0) { newTotal = 1;};
        if (pageData.twbsPagination.options.totalPages !== newTotal) {
            $('#pagination-demo').twbsPagination('destroy');
            $('#pagination-demo').twbsPagination($.extend(oops, {
                totalPages: newTotal,
                startPage: 1
            }));
        }

    }

    var oops = {
        initiateStartPageClick: false,
        totalPages: calcTotalPages($("#count-all-filtered-products").text(), $("#max-count-products-on-page option:selected").text()),
        visiblePages: 7,
        onPageClick: function (event, page) {
            var form = $('#filter-form-in-catalog').serialize();
            var count = $("#max-count-products-on-page option:selected").text();
            var category = $("#category-in-catalog").text();
            var visible = $("#visible-products-in-filter").text();
            if (visible) { form = form + "&visible=" + visible; };
            if(category) { form = form + "&category=" + category; };
            $.ajax({
                type: "POST",
                data: form,
                url: "${pageContext.request.contextPath}/catalog/getProductsOnPageWithFilter/" + page + "/" + count,
                success: function (responsePage) {
                    $('#current-catalog-page').html(responsePage);
                    $('html, body').animate({scrollTop: 0}, 300);
                    var newTotalPages = calcTotalPages($("#count-all-filtered-products").text(), $("#max-count-products-on-page option:selected").text());
                    displayPage(newTotalPages);
                }
            })

        }
    };

    $('#pagination-demo').twbsPagination(oops);

    $('#filter-submit-btn').click(function (event) {
        event.preventDefault();
        $('#pagination-demo').twbsPagination('show', 1);
    });

    $("#max-count-products-on-page").change(function (event) {
        event.preventDefault();
        $('#pagination-demo').twbsPagination('show', 1);
    })

    $(".category-item-in-catalog-js").click(function (event) {
        event.preventDefault();

        $(".list-group-item.active-list-group-item").removeClass('active-list-group-item');
        $(this).addClass('active-list-group-item');

        $('#filter-form-in-catalog').trigger('reset');
        var currentCategory = $(this).text();
        if (currentCategory === "All goods") {
            $("#category-in-catalog").empty();
            $("#visible-products-in-filter").empty();
        } else if (currentCategory === "Removed goods") {
            $("#category-in-catalog").empty();
            $("#visible-products-in-filter").text("false");
        } else {
            $("#category-in-catalog").text(currentCategory);
            $("#visible-products-in-filter").empty();
        }
        $('#pagination-demo').twbsPagination('show', 1);
    })


    function calcTotalPages(countProducts, countProductsOnPage) {
        var countPages = countProducts / countProductsOnPage;
        countPages = (parseInt(countPages) < countPages) ? parseInt(countPages) + 1 : countPages;
        return countPages;
    }

</script>
</html>
