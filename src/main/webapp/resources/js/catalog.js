

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
        totalPages: calcTotalPages($("#count-all-filtered-products").text(), $("#max-count-products-on-page").text()),
        visiblePages: 7,
        onPageClick: function (event, page) {
            var form = $('#filter-form-in-catalog').serialize();
            var count = $("#max-count-products-on-page").text();
            var category = $("#category-in-catalog").text();
            if(category) { form = form + "&category=" + category; };
            $.ajax({
                type: "POST",
                data: form,
                url: "/catalog/getProductsOnPageWithFilter/" + page + "/" + count,
                success: function (responsePage) {
                    $('#current-catalog-page').html(responsePage);
                    $('html, body').animate({scrollTop: 0}, 300);
                    var newTotalPages = calcTotalPages($("#count-all-filtered-products").text(), $("#max-count-products-on-page").text());
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

    $(".category-item-in-catalog-js").click(function (event) {
        event.preventDefault();

        $(".list-group-item.active").removeClass('active');
        $(this).addClass('active');

        $('#filter-form-in-catalog').trigger('reset');
        var currentCategory = $(this).text();
        if (currentCategory === "All goods") {
            $("#category-in-catalog").empty();
        } else {
            $("#category-in-catalog").text(currentCategory);
        }
        $('#pagination-demo').twbsPagination('show', 1);
    })


    function calcTotalPages(countProducts, countProductsOnPage) {
        var countPages = countProducts / countProductsOnPage;
        countPages = (parseInt(countPages) < countPages) ? parseInt(countPages) + 1 : countPages;
        return countPages;
    }



function addProductToCart(obj) {
    var idProduct = obj.value;
    $("#navbar-count-in-cart").text(Number($("#navbar-count-in-cart").text())+1);
    $("#message-success-add-to-cart").fadeIn(500);
    setTimeout(function(){$("#message-success-add-to-cart").fadeOut(1000)}, 2000);
    $.ajax({
        type: "POST",
        url: "addToCart/" + idProduct
    })
}