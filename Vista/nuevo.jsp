<%@page import="com.emergentes.Registro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            Registro item=(Registro) request.getAttribute("item");
        %>
        <h1>EDITAR REGISTRO</h1>
        <form action="Principal?op=guardar" method="post">
            Id: <input type="number" name="id" value="<%= item.getId() %>" size="2" pattern="[1-9] {1} [0-9]*"/>
            <input type="hidden" name="tipo" value="-1" required/>
            <br>
            Nombre: <input type="text" name="nombre" value="<%= item.getNombre()%>" required/>
            <br>
            Peso: <input type="text" name="peso" value="<%= item.getPeso()%>" />
            <br>
            Talla: <input type="text" name="talla" value="<%= item.getTalla()%>" />
            <br>
            Vacuna: <input type="text" name="vacuna" value="<%= item.getVacuna()%>" />
            <br>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
