/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bean;

import com.test.conexion.VariablesConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.PreDestroy;

/**
 *
 * @author Usuario
 */
public class AutorBean {

    private VariablesConexion variable;
    private Connection connection;

    public AutorBean() throws SQLException {
        variable = new VariablesConexion();
        variable.inicioConexion();
        connection = variable.getConnection();
        System.out.println("Iniciando la conexion");

    }

    @PreDestroy
    public void cerrarConexion() {
        variable.cerrarConexion();
    }

    public String listarAutor() {
        StringBuilder salidaTabla = new StringBuilder();
        StringBuilder query = new StringBuilder();

        query.append(" select cod_autor, paterno, materno, nombre,nacionalidad from autor ");

        try {
            PreparedStatement pst = connection.prepareStatement(query.toString());
            //pasando la consulta 
      
            ResultSet resultado = pst.executeQuery();/*Como no se realizara 
            ninguna modificacion de datos solo se obtendran datos usamos executeqUERY*/
            while (resultado.next()) {
//                salidaTabla.append("<tr><td scope='row'>");
                salidaTabla.append("<tr><td >");
                salidaTabla.append(resultado.getInt(1));
                salidaTabla.append("</td ><td>");
                salidaTabla.append(resultado.getString(2));
                salidaTabla.append("</td><td>");
                salidaTabla.append(resultado.getString(3));
                salidaTabla.append("</td><td>");
                salidaTabla.append(resultado.getString(4));
                salidaTabla.append("</td><td>");
                salidaTabla.append(resultado.getString(5));
                salidaTabla.append("</td>");
                salidaTabla.append("</tr>");

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return salidaTabla.toString();
    }

}
