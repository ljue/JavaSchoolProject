<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row" style="margin-top: 10px; min-height: 250px">
    <div class="col-md-1"></div>
    <div class="col-md-10">

        <div class="col-md-3">
            <ul class="nav nav-tabs tabs-left border-none">
                <li class="active">
                    <a href="#tab_default_1" data-toggle="tab">
                        Description </a>
                </li>
                <li>
                    <a href="#tab_default_2" data-toggle="tab">
                        Details </a>
                </li>
            </ul>
        </div>
        <div class="col-md-9">
            <div class="tab-content">
                <div class="tab-pane active" id="tab_default_1"
                     style="width:100%;border-top:1px solid silver">
                    <p style="padding:15px;">
                        <%--<small>--%>
                        ${product.description}
                        <%--</small>--%>
                    </p>
                </div>
                <div class="tab-pane" id="tab_default_2" style="width:100%;border-top:1px solid silver">
                    <div style="padding: 15px;">
                        <p>Category: <span>${product.category}</span></p>
                        <p>Battery: <span>${product.battery}</span></p>
                        <p>Fly time: <span>${product.flyTime} min</span></p>
                        <p>Distance: <span>${product.distance} m</span></p>
                        <c:forEach items="${product.properties}" var="propertyGroup">
                            <p>${propertyGroup.key}: <span>
                                        <c:forEach items="${propertyGroup.value}" var="property" varStatus="status">
                                            <c:if test="${status.index eq 0}">${property}</c:if><c:if
                                                test="${status.index gt 0}">, ${property}</c:if>
                                        </c:forEach>
                                    </span></p>
                        </c:forEach>

                    </div>

                </div>
            </div>
        </div>
        <%--</div>--%>
        <%--</div>--%>
    </div>
</div>