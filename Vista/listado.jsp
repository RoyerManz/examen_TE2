<%@page import="com.emergentes.Registro"%>
<%@page import="com.emergentes.RegistroDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
        <th> <strong>EXAMEN TECNOLOGIAS EMERGENTES II</strong> 
            <br>
          NOMBRE: Royer Manzaneda Delgado
          <br>
          CARNET: 13960666 L.P.
        </th>
        </table>
        <%
            RegistroDAO lista = (RegistroDAO) session.getAttribute("gestor");
        %>
        <h1>listado</h1>
        <p><a href="../Principal?op=nuevo">Nuevo</a></p>
        <%
            if (lista.getRegistros().size() > 0) {
        %>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>NOMBRE</th>
                <th>PESO</th>
                <th>TALLA</th>
                <th>VACUNA</th>
                <th></th>
                <th></th>
            </tr>
        <%
            for(Registro item : lista.getRegistros()) {
        %>
            <tr>
                <td><%= item.getId()%></td>
                <td><%= item.getNombre()%></td>
                <td><%= item.getPeso() %></td>
                <td><%= item.getTalla()%></td>
                <td><%= item.getVacuna()%></td>
                <td><a href="../Principal?op=editar&id=<%= item.getId()%>">Editar</a></td>
                <td><a href="../Principal?op=eliminar&id=<%= item.getId()%>">Eliminar</a></td>
            </tr>
        <%
            }
        %>
        </table>
        <%
            }else{
                out.println("<p>NO EXISTEN REGISTROS </p>");
            }
        %>
    </body>
</html>
