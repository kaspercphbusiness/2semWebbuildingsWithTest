<%-- 
    Document   : buildings
    Created on : Oct 11, 2016, 1:10:35 PM
    Author     : kasper
--%>

<%@page import="presentationLayer.RenderUtil"%>
<%@page import="domain.DomainFacade"%>
<%@page import="domain.Building"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buildings Page</title>
    </head>
    <body>
        <h1>Building list!</h1>
        <%
            List<Building> buildings = DomainFacade.getBuildings();
            if (buildings.isEmpty()) {
        %>
            <p>There are no buildings in the database</p>
        <%
            } else {
                RenderUtil.renderBuildingsTable(out, buildings);
        }
        %>
    </body>
</html>
