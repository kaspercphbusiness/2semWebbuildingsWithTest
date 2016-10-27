<%-- 
    Document   : editbuilding
    Created on : Oct 12, 2016, 1:20:17 PM
    Author     : kasper
--%>

<%@page import="domain.Building"%>
<%@page import="domain.DomainFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit building</title>
    </head>
    <body>
        <h1>Edit building </h1>
        <%
            int buildingID = Integer.parseInt( request.getParameter( "buildingid" ) );
            Building b = DomainFacade.getBuilding( buildingID );
        %>
        <form action="updateBuilding" method="POST">
            <table>
                <tr><td>Street</td><td><input type="text" name="street" value="<%=b.getAddress()%>"></td></tr>
                <tr><td>Zip</td><td><input type="text" name="zip" value="<%=b.getZip()%>"></td></tr>
                <tr><td>City</td><td><input type="text" name="city" value="<%=b.getCity()%>"></td></tr>
                <tr><td>Contact</td><td><input type="text" name="contact" value="<%=b.getContactPerson()%>"></td></tr>
                <tr><td>Phone</td><td><input type="text" name="phone" value="<%=b.getContactPhone()%>"></td></tr>
            </table>
            <input type="hidden" name="id" value="<%=buildingID%>">
            <input type="submit" name="action" value="Submit">
            <input type="submit" name="action" value="Cancel">
        </form>
    </body>
</html>
