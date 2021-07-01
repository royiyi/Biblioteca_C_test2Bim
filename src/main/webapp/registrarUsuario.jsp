<%-- 
    Document   : registrarUsuario
    Created on : Jun 30, 2021, 1:42:54 PM
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
          <jsp:useBean id="usuario" scope="session" class="com.test.bean.UsuarioBean"/>
        <%
            if (request.getParameter("guardar") != null) {
                String mensaje = usuario.registrarUsuario(request);
                out.print(mensaje);
            }

            /*if (request.getParameter("guardar") != null) {
                String nam=request.getParameter("guardar");
                out.print(nam+"botonPRESIONADO "+request.getParameter("desCat"));
            }*/
        %>

        <div class="bg-secondary col-8 mx-auto mt-5 ">
            <h4>REGISTRO DE USUARIO</h4>

            <form method="POST">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="pater_us">PATERNO</label>
                        <input type="text" name="pater_us" class="form-control">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="mater_us">MATERNO</label>
                        <input name="mater_us" type="text" class="form-control">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="nom_us">NOMBRE</label>
                        <input name="nom_us" type="text" class="form-control">
                    </div>
                </div>
                <div class="form-row">

                    <div class="form-group col-md-6">
                        <label for="ci_us">CI</label>
                        <input name="ci_us" type="number" class="form-control" placeholder="1234">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputState">Expedido</label>
                        <select name="exped_us" class="form-control" id="selectOP">
                            <option selected>Choose...</option>
                           
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="direc_us">Direccion</label>
                        <input name="direc_us" type="text" class="form-control" placeholder="Z/ CIUDAD SATELITE">
                    </div>

                    <div class="form-group col-md-">
                        <label for="telf_us">Telefono</label>
                        <input name="telf_us" type="number" class="form-control">
                    </div>
                </div>

                <button type="submit" name="guardar" class="btn btn-primary">enviar</button>
            </form>
        </div>
    </body>
</html>
<script>
    let depas = ["LA PAZ", "ORURO", "POTOSI", "PANDO", "TARIJA", "COCHABAMBA", "SANTA CRUZ", "CHUQUISACA"];
    var counter = "";
    for (let i = 0; i < depas.length; i++) {
        let element = depas[i];
        let op = "<option value='" + element + "'>" + element + "</option>";
        counter = counter + op
    }
    document.getElementById("selectOP").innerHTML = counter;
    console.log(counter)

</script>