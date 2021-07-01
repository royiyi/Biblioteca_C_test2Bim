<%-- 
    Document   : listaAutor
    Created on : Jun 30, 2021, 1:40:09 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title> 
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    </head>
    <body>
         <jsp:useBean id="autorBean" scope="session" class="com.test.bean.AutorBean"/>
        
        
        <div class=" col-6">
            <h4>LISTA DE AUTORES</h4>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">cod_autor</th>
                        <th scope="col">Paterno</th>
                        <th scope="col">Materno</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Nacionalidad</th>
                    </tr>
                </thead>
                <tbody>
                      <%=autorBean.listarAutor()%>
                  
                </tbody>
            </table>
        </div>
    </body>
</html>
