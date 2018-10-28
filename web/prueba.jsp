<%-- 
    Document   : index.jsp
    Created on : 21-10-2018, 20:14:20
    Author     : Sebastian
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="./ServMostrarAtenciones" flush="true"></jsp:include>
        <label>Usuario</label>
    <select class="form-control" name="ddlTipo">
    <option value="0">Seleccione</option>
    <c:forEach items="${datosAtencion}" var="u">
        <option value="${u.rut_medico}"><c:out value="${u.observaciones}"/></option>
    </c:forEach>
    </select>
    </body>
</html>

