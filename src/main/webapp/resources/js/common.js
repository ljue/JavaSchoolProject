/**
 * Created by Людмила on 09.09.2017.
 */

//////////////// navigation ////////////////////

$(function () {
    var location = window.location.href;
    var loc_arr = location.split('/');
    if(loc_arr.indexOf('catalog')!= -1) {
        $('#catalog-link').addClass('active');
    } else if(loc_arr.indexOf('profile')!= -1) {
        $('#profile-link').addClass('active');
    } else if(loc_arr.indexOf('management')!= -1) {
        $('#management-link').addClass('active');
    } else if(loc_arr.indexOf('login')!= -1) {
        $('#login-link').addClass('active');
    } else if(loc_arr.indexOf('login?logout')!= -1) {
        $('#login-link').addClass('active');
    } else if(loc_arr.indexOf('bucket')!= -1) {
        $('#dropdown-click-navbar-cart').addClass('active');
    } else if(loc_arr.indexOf('checkout')!= -1) {
        $('#dropdown-click-navbar-cart').addClass('active');
    } else  {
        $('#home-link').addClass('active');
    }
    // <%--var location = window.location.href;--%>
    // <%--var cur_url = '${pageContext.request.contextPath}/' + location.split('/').pop();--%>
    // <%--$('#my-menu-navbar li').each(function () {--%>
    // <%--var link = $(this).find('a').attr('href');--%>
    // <%--if (cur_url == link) {--%>
    // <%--$(this).addClass('active');--%>
    //
    // <%--}--%>
    // <%--});--%>
});

$(document).ready(function () {
    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/getCountInCart",
        success: function (resp) {
            $("#navbar-count-in-cart").text(resp);
        }
    })
});

$("#dropdown-click-navbar-cart").click(function () {

    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/getProductsInCart",
        success: function (resp) {
            console.log("dropdown was opened");
            $("#dropdown-cart").html(resp);
            $(".shopping-cart").fadeToggle( "fast");
        }
    })
})


///////////////////////////// cartDown /////////////////////////////////////////

$(document).ready(function () {
    $("#count-in-cart-dropdown").text($("#navbar-count-in-cart").text());
});

////////////////////////////  registration ////////////////////

function checkParams() {
    var loginError = document.getElementById('loginExists').innerHTML;
    var emailError = document.getElementById('emailExists').innerHTML;

    if(loginError.length !== 0 || emailError.length !== 0) {
        $('#submit-registration').removeAttr('active');
        $('#submit-registration').attr('disabled', 'disabled');
    } else {
        $('#submit-registration').removeAttr('disabled');
        $('#submit-registration').attr('active', 'active');
    }
}

function onBlurEmailFunction(obj){
    var email = obj.value;
    $.ajax({
        type: "POST",
        data: {email : email},
        url: "${pageContext.request.contextPath}/registration/findEmail/",
        success: function (msg) {
            $("#emailExists").html(msg);
            checkParams();
        }
    })

};

function onBlurLoginFunction(obj) {
    var login = obj.value;
    $.ajax({
        type: "POST",
        data: {login : login},
        url: "${pageContext.request.contextPath}/registration/findLogin/",
        success: function (msg) {
            $("#loginExists").text(msg);
            checkParams();
        }
    })

}


//////////////////////////////////  product EditInfo     ////////////////////////

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

/////////////////////////////////  product   ///////////////////////////

$(document).ready(function () {
    $('#myCarousel').carousel({
        interval: 10000
    })
    $('.fdi-Carousel .item').each(function () {
        var next = $(this).next();
        if (!next.length) {
            next = $(this).siblings(':first');
        }
        next.children(':first-child').clone().appendTo($(this));

        if (next.next().length > 0) {
            next.next().children(':first-child').clone().appendTo($(this));
        }
        else {
            $(this).siblings(':first').children(':first-child').clone().appendTo($(this));
        }
    });
});

$("#btn-show-edit-product-panel").click(function (e) {
    e.preventDefault();
    $("#product-edit-info-panel").slideDown();
    var top = $("#product-edit-info-panel").offset().top;
    $('body,html').animate({scrollTop: top}, 400);
})

// function addProductToCart(obj) {
//     var idProduct = obj.value;
//     $("#navbar-count-in-cart").text(Number($("#navbar-count-in-cart").text()) + 1);
//     $("#message-success-add-to-cart-pr").fadeIn(500);
//     setTimeout(function () {
//         $("#message-success-add-to-cart-pr").fadeOut(1000)
//     }, 2000);
//     $.ajax({
//         type: "POST",
//         url: "${pageContext.request.contextPath}/addToCart/" + idProduct
//     })
// }

///////////////////////////////    login     ///////////////////////

$("#click-forgot-password").click(function (e) {
        e.preventDefault();
        $("#modal-forgot-password").modal('show');
    }
)
$("#send-forgot-password").click(function (e) {
    e.preventDefault();
    $("#modal-forgot-password").modal('hide');
    $.ajax({
        type: "POST",
        data: {sendEmail: $("#input-email-forgot-password").val()},
        url: "${pageContext.request.contextPath}/sendPassword",
        success: function (resp) {
            if (resp) {
                $("#message-success-send-email").fadeIn(500);
                setTimeout(function () {
                    $("#message-success-send-email").fadeOut(1000)
                }, 2000);
            } else {
                $("#message-fail-send-email").fadeIn(500);
                setTimeout(function () {
                    $("#message-fail-send-email").fadeOut(1000)
                }, 2000);
            }
        }
    })
})


///////////////////////////  catalogProducts     ////////////////////////////

// function addProductToCart(obj) {
//     var idProduct = obj.value;
//     $("#navbar-count-in-cart").text(Number($("#navbar-count-in-cart").text())+1);
//     $("#message-success-add-to-cart").fadeIn(500);
//     setTimeout(function(){$("#message-success-add-to-cart").fadeOut(1000)}, 2000);
//     $.ajax({
//         type: "POST",
//         url: "${pageContext.request.contextPath}/addToCart/" + idProduct
//     })
// }

/////////////////////////////// catalog /////////////////////////////////

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

//////////////////////////////////// bucketInto ///////////////////////////////////////////

function checkOptions(count, idProduct) {
    if ($("#check-count-product-"+idProduct).data("seq")>count) {
        $("#check-count-product-"+idProduct).html("<i class='fa fa-check fa-lg' aria-hidden='true'></i>");
    } else {
        $("#check-count-product-"+idProduct).html("<i class='fa fa-times fa-lg' aria-hidden='true'></i>");
    }
}


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

    checkOptions(count, idProduct);

    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/addToCart/" + idProduct
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

        checkOptions(count, idProduct);

        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/minusFromCart/" + idProduct
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
        url: "${pageContext.request.contextPath}/changeCountInCart/" + idProduct,
        success: function (page) {
            $("#products-in-bucket").html(page);
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/getCountInCart",
                success: function (resp) {
                    $("#navbar-count-in-cart").text(resp);
                }
            })
        }
    })
};

$("#btn-go-checkout").click(function (e) {
    if($(".fa-times").length) {
        e.preventDefault();
        $("#message-empty-count-of-product-in-bucket").fadeIn(500);
        setTimeout(function () {
            $("#message-empty-count-of-product-in-bucket").fadeOut(1000)
        }, 2000);
    }
})

$(".change-count-product-in-bucketInto").change(function () {
    var count = $(this).val();
    var idProduct = $(this).data("seq");
    if (count > 0) {
        $.ajax({
            type: "POST",
            data: {count: count},
            url: "${pageContext.request.contextPath}/changeCountInCart/" + idProduct,
            success: function (page) {
                $("#products-in-bucket").html(page);
                checkOptions(count, idProduct);
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/getCountInCart",
                    success: function (resp) {
                        $("#navbar-count-in-cart").text(resp);
                    }
                })
            }
        })
    } else {
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/changeCountInCart/getCurrentVal/" + idProduct,
            success: function (resp) {
                $("#changeCountProducts" + idProduct).val(resp);
                checkOptions(count, idProduct);
            }
        })
    }
})

/////////////////////////////////////// profile ////////////////////////////

// function checkParams() {
//     var loginError = document.getElementById('loginEditExists').innerHTML;
//     var emailError = document.getElementById('emailEditExists').innerHTML;
//
//     if(loginError.length !== 0 || emailError.length !== 0) {
//         $('#edit-user-info-button').removeAttr('active');
//         $('#edit-user-info-button').attr('disabled', 'disabled');
//     } else {
//         $('#edit-user-info-button').removeAttr('disabled');
//         $('#edit-user-info-button').attr('active', 'active');
//     }
// }

function onBlurEmailEdit(obj) {
    var email = obj.value;
    $.ajax({
        type: "POST",
        data: {email : email},
        url: "${pageContext.request.contextPath}/profile/editInfo/findEmail/",
        success: function (msg) {
            $("#emailEditExists").html(msg);
            checkParams();
        }
    })
}

function onBlurLoginEdit(obj) {
    var login = obj.value;
    $.ajax({
        type: "POST",
        data: {login : login},
        url: "${pageContext.request.contextPath}/profile/editInfo/findLogin/",
        success: function (msg) {
            $("#loginEditExists").text(msg);
            checkParams();
        }
    })

}

//////////////////////////////////// orderInHistory ////////////////////////////////////


function repeatOrder(obj) {
    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/profile/orderInHistory/repeatOrder/" + $("#order-id-in-order-in-history").text(),
        success: function () {
            location.href = "/bucket";
        }
    });
};


//////////////////////////////// checkout ////////////////////////////////////////

$("#finish-checkout-button").click(function (e) {
    var s = $("#checkout-list-addresses").text().replace(/\s/g, "");
    if (!s) {
        e.preventDefault();
        $("#message-empty-address").fadeIn(500);
        setTimeout(function () {
            $("#message-empty-address").fadeOut(1000)
        }, 2000);
    }
    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/checkout/checkAndSubCountProducts",
        success: function (resp) {
            if (!resp) {
                e.preventDefault();
                $("#message-empty-count-of-product").fadeIn(500);
                setTimeout(function () {
                    $("#message-empty-count-of-product").fadeOut(1000)
                }, 2000);
            }
        }
    })
});

//////////////////////////////////// address /////////////////////////////////////////////////////

$('a.remove-address-panel').click(function (e) {
    e.preventDefault();
    var addressId = $(this).data('seq');
    var panelId = "#panel-address-" + addressId;
    $(panelId).slideUp();//400mc
    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/profile/address/remove/" + addressId
    })
})

//////////////////////////////////// editPropertyGroups /////////////////////////////////

$("#add-new-property-group-btn").click(function (e) {
    var form = $("#add-property-group-input").val();
    if (form.replace(/\s/g, "")) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            data: {add : form},
            url: "${pageContext.request.contextPath}/management/editPropertyGroups/checkExisting",
            success: function (resp) {
                if (resp) {
                    $("#message-fail-add-property-group").fadeIn(500);
                    setTimeout(function () {
                        $("#message-fail-add-property-group").fadeOut(1000)
                    }, 2000);
                } else {
                    $("#form-add-property-group").submit();
                }
            }
        })
    }
})

////////////////////////////////////////// editProperties //////////////////////////

$("#add-new-property-btn").click(function (e) {
    var form = $("#add-property-input").val();
    if (form.replace(/\s/g, "")) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            data: {add : form},
            url: "${pageContext.request.contextPath}/management/editProperties/checkExisting",
            success: function (resp) {
                if (resp) {
                    $("#message-fail-add-property").fadeIn(500);
                    setTimeout(function () {
                        $("#message-fail-add-property").fadeOut(1000)
                    }, 2000);
                } else {
                    $("#form-add-property").submit();
                }
            }
        })
    }
})

////////////////////////////////////////// editCategories /////////////////////////////////

$("#add-new-category-product").click(function (e) {
    var form = $("#add-category-input").val();
    if (form.replace(/\s/g, "")) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            data: {addCategoryName: form},
            url: "${pageContext.request.contextPath}/management/editCategories/checkExisting",
            success: function (resp) {
                if (resp) {
                    $("#message-fail-add-category").fadeIn(500);
                    setTimeout(function () {
                        $("#message-fail-add-category").fadeOut(1000)
                    }, 2000);
                } else {
                    $("#form-add-category").submit();
                }
            }
        })
    }
})

