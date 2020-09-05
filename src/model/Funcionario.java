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
public class Funcionario extends Persona{
    private String emergenciaContacto;
    private String emergenciaTelefono;
    private String emergenciaRelacion;

    public Funcionario() {
    }

    public Funcionario(String emergenciaContacto, String emergenciaTelefono, String emergenciaRelacion, String nombre, String apellido, String cedula, String sexo, String telefono, String email, String comentario, Date fechaNacimiento) {
        super(nombre, apellido, cedula, sexo, telefono, email, comentario, fechaNacimiento);
        this.emergenciaContacto = emergenciaContacto;
        this.emergenciaTelefono = emergenciaTelefono;
        this.emergenciaRelacion = emergenciaRelacion;
    }

    public String getEmergenciaContacto() {
        return emergenciaContacto;
    }

    public void setEmergenciaContacto(String emergenciaContacto) {
        this.emergenciaContacto = emergenciaContacto;
    }

    public String getEmergenciaTelefono() {
        return emergenciaTelefono;
    }

    public void setEmergenciaTelefono(String emergenciaTelefono) {
        this.emergenciaTelefono = emergenciaTelefono;
    }

    public String getEmergenciaRelacion() {
        return emergenciaRelacion;
    }

    public void setEmergenciaRelacion(String emergenciaRelacion) {
        this.emergenciaRelacion = emergenciaRelacion;
    }
    
    
    
}
