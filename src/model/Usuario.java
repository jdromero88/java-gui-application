/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;

/**
 *
 * @author jodarove
 */
public class Usuario extends Funcionario{
    private String usuario;
    private String password;

    public Usuario() {
    }

    public Usuario(String usuario, String password, String emergenciaContacto, String emergenciaTelefono, String emergenciaRelacion, String nombre, String apellido, String cedula, String sexo, String telefono, String email, String comentario, Date fechaNacimiento) {
        super(emergenciaContacto, emergenciaTelefono, emergenciaRelacion, nombre, apellido, cedula, sexo, telefono, email, comentario, fechaNacimiento);
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
