<%@ page import="DAO.Factory" %>
<%@ page import="DAO.*" %>
<%@ page import="ShopEntities.ClientEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple jsp page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<h2>Hello World!</h2>
<div>
    Our users:
    <table class="table">

    <% List<ClientEntity> clientlist = (List<ClientEntity>) Factory.getInstance().getClientDAO().getAllClients();
    for (ClientEntity client:clientlist) {%>
        <tr>
            <td> <%= client.getFirstName()%> </td>
            <td> <%= client.getSecondName()%> </td>
        </tr>
    <%}
    %>
    </table>
</div>

</body>
</html>
