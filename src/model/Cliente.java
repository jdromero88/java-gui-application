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
public class Cliente extends Persona{
    private boolean programaRecompensa;

    public Cliente() {
    }

    public Cliente(boolean programaRecompensa, String nombre, String apellido, String cedula, String sexo, String telefono, String email, String comentario, Date fechaNacimiento) {
        super(nombre, apellido, cedula, sexo, telefono, email, comentario, fechaNacimiento);
        this.programaRecompensa = programaRecompensa;
    }

    public boolean isProgramaRecompensa() {
        return programaRecompensa;
    }

    public void setProgramaRecompensa(boolean programaRecompensa) {
        this.programaRecompensa = programaRecompensa;
    }
    
    
}
