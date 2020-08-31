/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import database.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import services.BCrypt;

/**
 *
 * @author jodarove
 */
public class Usuario {
    String query;
    Conexion mysql = new Conexion();
    Connection cn = mysql.conectar();
    boolean login = false;
    LinkedHashMap findBy(String nick_usuario) throws SQLException{
        String usuario = nick_usuario;
        String password = null;
        LinkedHashMap<String, String> user = new LinkedHashMap<String, String>();
            query = "SELECT * FROM usuarios WHERE nick_usuario LIKE '" + nick_usuario + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                usuario = rs.getString("nick_usuario");
                password = rs.getString("pass_usuario");
            }
            user.put(usuario, password);
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        } finally{
            if(cn != null) cn.close();
//            System.err.println("No cerre la conexion");
        }
        return user;
    }
    public boolean loguearUsuario(String usuario, String password) throws SQLException{        
        if(usuario == findBy(usuario).get(usuario)){
            System.out.println(findBy(usuario).get(password));
            System.out.println("Usuario encontrado: " + usuario);
        }
        String test = BCrypt.hashpw(password, BCrypt.gensalt(12));        
        System.out.println("soytest:" + test);
        if ("admin".equals(usuario)) {
            if (BCrypt.checkpw("admin", test)) {
                login = true;
            }else{
                login = false;
                System.err.println("Datos incorrectos.");
            }  
        }else{
            login = false;
            System.err.println("Datos Incorrectos.");
        }
        return login;
    }
    boolean cerrarSesion(){
        return true;
    }
    public void salir(){
        System.exit(0);
    }
}
