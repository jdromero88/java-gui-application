/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import services.BCrypt;

/**
 *
 * @author jodarove
 */
public class Usuario {
    boolean login = false;
    public boolean loguearUsuario(String usuario, String password){
        String test = BCrypt.hashpw(password, BCrypt.gensalt(12));
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
