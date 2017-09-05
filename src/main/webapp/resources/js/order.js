// $(document).ready(function () {
//     $.ajax({
//         type: "POST",
//         url: "getCountInCart",
//         success: function (resp) {
//             $("#navbar-count-in-cart").text(resp);
//         }
//     })
// });

$(function () {

    $("#finish-checkout-button").click(function (e) {
        var s = $("#checkout-list-addresses").text().replace(/\s/g, "");
        if (!s) {
            e.preventDefault();
            $("#message-empty-address").fadeIn(500);
            setTimeout(function () {
                $("#message-empty-address").fadeOut(1000)
            }, 2000);
        }
    });

    $("#dropdown-click-navbar-cart").click(function () {

        $.ajax({
            type: "POST",
            url: "getProductsInCart",
            success: function (resp) {
                console.log("dropdown was opened");
                $("#dropdown-cart").html(resp);
                $(".shopping-cart").fadeToggle( "fast");
            }
        })
    })

    function repeatOrder(obj) {
        $.ajax({
            type: "POST",
            url: "orderInHistory/repeatOrder/" + $("#order-id-in-order-in-history").text(),
            success: function () {
                $.ajax({
                    type: "POST",
                    url: "getCountInCart",
                    success: function (resp) {
                        $("#navbar-count-in-cart").text(resp);
                    }
                })
            }
        });
        location.href = "/bucket";
    };

});

function addProductToCart(obj) {
    var idProduct = obj.value;
    var count = Number($("#changeCountProducts" + idProduct).val());
    var cost = Number($('#costProduct' + idProduct).text());
    var total = Number($('#calc-total-price').text());
    $("#navbar-count-in-cart").text(Number($("#navbar-count-in-cart").text()) + 1);

    count = count + 1;
    total = total + cost;

    $("#changeCountProducts" + idProduct).val(count);
    $("#calc-total-price").text(total.toFixed(2));

    $.ajax({
        type: "POST",
        url: "addToCart/" + idProduct
    });
};
function minusProductFromCart(obj) {
    var idProduct = obj.value;
    var count = Number($("#changeCountProducts" + idProduct).val());
    if (count > 0) {
        var cost = Number($('#costProduct' + idProduct).text());
        var total = Number($('#calc-total-price').text());
        $("#navbar-count-in-cart").text(Number($("#navbar-count-in-cart").text()) - 1);

        count = count - 1;
        total = total - cost;

        $("#changeCountProducts" + idProduct).val(count);
        $("#calc-total-price").text(total.toFixed(2));
        $.ajax({
            type: "POST",
            url: "minusFromCart/" + idProduct
        })

    }
};
function deleteProductFromCart(obj) {
    var idProduct = obj.value;
    var count = 0;
    //$("#tr-in-bucket-table"+idProduct).slideUp();
    $.ajax({
        type: "POST",
        data: {count: count},
        url: "changeCountInCart/" + idProduct,
        success: function (page) {
            $("#products-in-bucket").html(page);
            $.ajax({
                type: "POST",
                url: "getCountInCart",
                success: function (resp) {
                    $("#navbar-count-in-cart").text(resp);
                }
            })
        }
    })
};

function changeCountProducts(obj) {
    var idProduct = obj.value;
    var count = Number($("#changeCountProducts" + idProduct).val());

    $.ajax({
        type: "POST",
        data: {count: count},
        url: "changeCountInCart/" + idProduct,
        success: function (page) {
            $("#products-in-bucket").html(page);
            $.ajax({
                type: "POST",
                url: "getCountInCart",
                success: function (resp) {
                    $("#navbar-count-in-cart").text(resp);
                }
            })
        }
    })
};


$(function () {
    $('tbody > tr').on('click', function(event) {
        event.preventDefault();
        $('#myModal').modal('show');
    })

    $('.btn-mais-info').on('click', function(event) {
        $( '.open_info' ).toggleClass( "hide" );
    })
});
