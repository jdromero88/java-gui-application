/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author jodarove
 */
public class Testing {
    
    public double getKilo(String codigo){
        double kilo = 0; //declaramos kilo y le asignamos el valor 0
//      Declaramos nueva variable para splice codigo
        String str = codigo.substring(7);
        kilo = Double.parseDouble(str);
        return kilo;
    }    
}
