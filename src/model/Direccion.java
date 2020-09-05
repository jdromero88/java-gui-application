/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author jodarove
 */
public class Direccion {
    private int numero;
    private String nombre;
    private String extra;
    private int codigoPostal;

    public Direccion() {
    }

    public Direccion(int numero, String nombre, String extra, int codigoPostal) {
        this.numero = numero;
        this.nombre = nombre;
        this.extra = extra;
        this.codigoPostal = codigoPostal;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
}
