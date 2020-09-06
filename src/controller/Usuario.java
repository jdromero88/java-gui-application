/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import database.DBUtil;
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
    boolean login = false;
    LinkedHashMap findBy(String nombre) throws Exception{
        String usuario = nombre;
        String password = null;
        String query = "SELECT * FROM usuarios WHERE nombre LIKE '" + usuario + "'";
        LinkedHashMap<String, String> user = new LinkedHashMap<String, String>();
        Connection connection = DBUtil.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                usuario = rs.getString("nombre");
                password = rs.getString("password_digest");
            }
            user.put(usuario, password);
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        } finally{
            DBUtil.closeConnection();
        }
        return user;
    }
    public boolean loguearUsuario(String usuario, String password) throws Exception{        
        if(usuario == findBy(usuario).get(usuario)){
            System.out.println(findBy(usuario).get(password));
            System.out.println("Usuario encontrado: " + usuario);
        }
        String test = BCrypt.hashpw(password, BCrypt.gensalt(12));        
        System.out.println("soytest:" + test);
        if ("jromero".equals(usuario)) {
            if (BCrypt.checkpw("password", test)) {
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
