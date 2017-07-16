<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple jsp page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<h2>Hello World!</h2>


<br>
<button onclick="location.href = '/countries'">Countries</button>

<%--<div>--%>
    <%--Our users:--%>
    <%--<table class="table">--%>

    <%--<% List<ClientEntity> clientlist = (List<ClientEntity>) Factory.getInstance().getClientDAO().getAllClients();--%>
    <%--for (ClientEntity client:clientlist) {%>--%>
        <%--<tr>--%>
            <%--<td> <%= client.getFirstName()%> </td>--%>
            <%--<td> <%= client.getSecondName()%> </td>--%>
        <%--</tr>--%>
    <%--<%}--%>
    <%--%>--%>
    <%--</table>--%>
<%--</div>--%>
<%--<br>--%>
<%--<br>--%>
<%--<div>--%>
    <%--Our countries:--%>
    <%--<table class="table">--%>

        <%--<% List<CountryEntity> countrylist = Factory.getInstance().getCountryDAO().getAllCountries();--%>
            <%--for (CountryEntity country:countrylist) {%>--%>
        <%--<tr>--%>
            <%--<td> <%= country.getId()%> </td>--%>
            <%--<td> <%= country.getName()%> </td>--%>
        <%--</tr>--%>
        <%--<%}--%>
        <%--%>--%>
    <%--</table>--%>
<%--</div>--%>

</body>
</html>
