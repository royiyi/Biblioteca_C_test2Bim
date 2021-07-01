/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bean;

import com.test.conexion.VariablesConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Usuario
 */
public class UsuarioBean {

    private Connection connection;
    private PreparedStatement insertUsuario;
    private VariablesConexion variable;

    public UsuarioBean()throws SQLException {
        //instanciando
        variable = new VariablesConexion();
        variable.inicioConexion();
        //obteniendo la conexion
        connection = variable.getConnection();
        System.out.println("Iniciando la conexion");
    }
    //metodos
    @PreDestroy//cuando ya no la estemos utilizando automaticamente se ejecutara y se serrara la conexion
    public void cerrarConexion() {
        variable.cerrarConexion();
    }
    
    

    public String registrarUsuario(HttpServletRequest request) {
        String mensaje = "";
        if (request == null) {
            return "--";
        }
        if (connection != null) {
            try {
                //Definiendo la consulta
                StringBuilder query = new StringBuilder();
                query.append(" insert into usuario ");//append concatena los string
                query.append(" values (?,?,?,?,?,?,?) ");
                //los para metros que son enviados desde el formulario se ponen con '?'
                //nextval('sec_cat') son los valores automaticos puestos(indice automatico  )
                //enviando la consulta
                if (insertUsuario == null) {
                    insertUsuario = connection.prepareStatement(query.toString());
                }
                //rescatando los parametros del formulario jsp registrarCategoria
                /*Deben ir en el orden delas tablas para que los valores no salgan al reves*/
                String pater = request.getParameter("pater_us");
                String mater = request.getParameter("mater_us");
                String nom = request.getParameter("nom_us");
//                int ci = request.getParameter("ci_us");
                int ci = Integer.parseInt(request.getParameter("ci_us"));
                String ex = request.getParameter("exped_us");
                String dir = request.getParameter("direc_us");
                int telf = Integer.parseInt(request.getParameter("telf_us"));
                //pasando los datos a los parametros de a consulta
                
                insertUsuario.setInt(1,ci );
                insertUsuario.setString(2,pater );
                insertUsuario.setString(3, mater);
                insertUsuario.setString(4,nom );
                insertUsuario.setString(5,ex );
                insertUsuario.setInt(6, telf);
                insertUsuario.setString(7,dir );
//                insertUsuario.setString(1, pater);
//                insertUsuario.setString(2, mater);
//                insertUsuario.setString(3, nom);
//                insertUsuario.setInt(4,ci );
//                insertUsuario.setString(5,ex );
//                insertUsuario.setString(6,dir);
//                insertUsuario.setInt(7,telf );
                
                //ejecutando la consulta
                int registro = insertUsuario.executeUpdate();//Se realiza una modificacion en
                // la base de datos usamos >executeUpdate()
                if (registro == 1) {
                    mensaje = "Registro realizado con exito";
                } else {
                    mensaje = "Error al insertar el registro ";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mensaje;
    }

}
